/**
 * 
 */
package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;
import java.util.List;

/**
 * 
 */
public class ClassDeclaration implements Instruction, Declaration {

	private List<ClassElement> elements;

	private boolean concrete;

	private String name;

	private String ancestor;

	private ClassDeclaration ancestorClass;

	public ClassDeclaration getAncestor() {
		return ancestorClass;
	}

	/**
	 * 
	 */
	public ClassDeclaration(boolean concrete, String name, String ancestor, List<ClassElement> elements) {
		this.concrete = concrete;
		this.name = name;
		this.ancestor = ancestor;
		this.elements = elements;

		for (ClassElement elt : this.elements) {
			elt.setClassDeclaration(this);
		}
	}

	/**
	 * 
	 */
	public ClassDeclaration(boolean concrete, String name, List<ClassElement> elements) {
		this(concrete, name, null, elements);
	}

	public boolean isConcrete() {
		return this.concrete;
	}

	// added
	public ClassElement getElement(String name) {
		ClassElement el = elements.stream().filter((e) -> e.getName().equals(name)).findFirst().orElse(null);
		return el;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (scope.knows(name)) {
			Logger.error("[ClassDeclaration] The name " + this.name + " is already used");
		}
		scope.register(this);

		if (ancestor != null) {
			// Faut que l'ancêtre soit connue dans le scope
			if (!scope.knows(this.ancestor)) {
				Logger.error("[ClassDeclaration] Class " + this.name + " cannot extend unknown class " + this.ancestor);
			}

			// Faut que l'ancêtre soit une classe
			if (!(scope.get(this.ancestor) instanceof ClassDeclaration)) {
				Logger.error("[ClassDeclaration] Class " + this.name + " cannot extend non-class " + this.ancestor);
			}

			this.ancestorClass = (ClassDeclaration) scope.get(this.ancestor);
			// Une classe abstraite ne peut pas étendre une classe concrète
			if (!this.concrete && ancestorClass.concrete) {
				Logger.error(
						"[ClassDeclaration]" + this.name + " is abstract but extends concrete class " + this.ancestor);
			}

			// TODO: ajouter les ClassElement de l'ancêtre ?
		}

		// Scope de la classe
		SymbolTable classScope = new SymbolTable();
		// Ajout de "this" dans la classe
		String trueName = this.name;
		this.name = "this";
		classScope.register(this);
		this.name = trueName;
		// Premier parcours pour ajouter les elements au scope de la classe
		// for (ClassElement element : this.elements) {
		// if (!classScope.accepts(element)){
		// Logger.error("[ClassDeclaration] The element " + element.getName() + " is
		// already declared in class " + this.name);
		// }
		// classScope.register(element);
		// }
		// boolean okElems = true;

		// Second parcours pour resolve et verifier abstract methods
		boolean okElems = true;
		for (ClassElement element : this.elements) {
			if (element instanceof MethodDeclaration) {
				MethodDeclaration method = (MethodDeclaration) element;
				if (this.concrete && !method.isConcrete()) {
					Logger.error("[ClassDeclaration] Concrete class " + this.name + " cannot contain abstract method "
							+ method.getName());
				}
				okElems = okElems && (!method.isConcrete() || method.collectAndPartialResolve(classScope));
			}
			// else if (element instanceof ConstructorDeclaration) {
			// ConstructorDeclaration constructor = (ConstructorDeclaration) element;
			// okElems = okElems &&
			// constructor.getBody().collectAndPartialResolve(classScope);
			// }
			// Rien besoinde collect si c'est un attribut
		}
		return true;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		Logger.error("[ClassDeclaration] The class " + this.name + " cannot be declared inside a function.");
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO method.getBody().completResolve()

		return true;
		// throw new SemanticsUndefinedException("Semantics resolve is undefined in
		// ClassDeclaration.");
	}

	@Override
	public boolean checkType() {
		if (ancestor != null) {
			return ancestorClass.checkType();
		}
		return true;
		// throw new SemanticsUndefinedException("Semantics checkType is undefined in
		// ClassDeclaration.");
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		throw new SemanticsUndefinedException("Semantics allocatememory is undefined in ClassDeclaration.");
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in ClassDeclaration.");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Type getType() {
		ClassType type = new ClassType(name);
		type.setDeclaration(this);
		return type;
	}

	@Override
	public String toString() {
		String image = "";
		if (!this.concrete) {
			image += "abstract ";
		}
		image += "class " + this.name + " ";
		if (this.ancestor != null) {
			image += "extends " + this.ancestor + " ";
		}
		image += "{\n";
		for (ClassElement e : this.elements) {
			image += e;
		}
		image += "}\n";
		return image;
	}

}
