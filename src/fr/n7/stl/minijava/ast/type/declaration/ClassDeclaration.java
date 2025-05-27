/**
 * 
 */
package fr.n7.stl.minijava.ast.type.declaration;

import java.util.List;

import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

/**
 * 
 */
public class ClassDeclaration implements Instruction, Declaration {

	private List<ClassElement> elements;

	private boolean concrete;

	private String name;

	private String ancestor;

	private ClassDeclaration ancestorClass;

	/**
	 * 
	 */
	public ClassDeclaration(boolean concrete, String name, String ancestor, List<ClassElement> elements) {
		this.concrete = concrete;
		this.name = name;
		this.ancestor = ancestor;
		this.elements = elements;
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

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.accepts(this)) {
			Logger.error("[ClassDeclaration] Declaration of class " + this.name + " is not accepted in scope");
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

		for (ClassElement element : this.elements) {
			if (element instanceof MethodDeclaration) {
				MethodDeclaration method = (MethodDeclaration) element;
				if (this.concrete && !method.isConcrete()) {
					Logger.error("[ClassDeclaration] Concrete class " + this.name + " cannot contain abstract method "
							+ method.getName());
				}
			} else if (element instanceof ConstructorDeclaration) {
			}
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
		throw new SemanticsUndefinedException("Semantics resolve is undefined in ClassDeclaration.");
	}

	@Override
	public boolean checkType() {
		throw new SemanticsUndefinedException("Semantics checkType is undefined in ClassDeclaration.");
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
		return new ClassType(name);
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
