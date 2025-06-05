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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassDeclaration implements Instruction, Declaration {

	private List<ClassElement> elements;

	private List<AttributeDeclaration> attributes;

	private List<MethodDeclaration> methods;

	private List<ConstructorDeclaration> constructors;

	private boolean concrete;

	private String name;

	private String ancestor;

	private ClassDeclaration ancestorClass;

	private ClassType type;

	public ClassDeclaration getAncestor() {
		return ancestorClass;
	}

	public ClassDeclaration(boolean concrete, String name, String ancestor, List<ClassElement> elements) {
		this.concrete = concrete;
		this.name = name;
		this.ancestor = ancestor;
		this.elements = elements;
		this.attributes = new ArrayList<>();
		this.methods = new ArrayList<>();
		this.constructors = new ArrayList<>();

		this.type = new ClassType(name);
		this.type.setDeclaration(this);

		for (ClassElement elt : this.elements) {
			elt.setClassDeclaration(this);
			if (elt instanceof AttributeDeclaration) {
				attributes.add((AttributeDeclaration) elt);
			} else if (elt instanceof MethodDeclaration) {
				methods.add((MethodDeclaration) elt);
			} else if (elt instanceof ConstructorDeclaration) {
				constructors.add((ConstructorDeclaration) elt);
			} else {
				Logger.error("[ClassDeclaration] Unknown ClassElement type: " + elt.getClass().getSimpleName());
			}
		}
	}

	public ClassDeclaration(boolean concrete, String name, List<ClassElement> elements) {
		this(concrete, name, null, elements);
	}

	public boolean isConcrete() {
		return this.concrete;
	}

	/**
	 * Renvoie l'attribut de nom "name" de la classe et null si l'attribut n'existe
	 * pas.
	 */
	public AttributeDeclaration getAttribute(String name) {
		return this.attributes.stream()
				.filter((e) -> e.getName().equals(name))
				.findFirst().orElse(null);
	}

	/**
	 * Renvoie la liste des méthodes de nom <code>name</code> et de nombre de
	 * paramètre <code>nbparam</code> de la classe.
	 */
	public List<MethodDeclaration> getMethods(String name, int nbParams) {
		return this.methods.stream()
				.filter((e) -> e.getName().equals(name))
				.filter((e) -> e.getParameters().size() == nbParams)
				.collect(Collectors.toList());
	}

	/**
	 * Renvoie la liste des constructeurs de la classe.
	 */
	public List<ConstructorDeclaration> getConstructors() {
		return this.constructors;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (scope.knows(name)) {
			Logger.error("[ClassDeclaration] The name " + this.name + " is already used");
		}
		scope.register(this);

		// vérification de l'ancêtre
		if (ancestor != null) {
			// Faut que l'ancêtre soit connu dans le scope
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

		// ajout du type de la classe dans le scope
		classScope.register(this);

		boolean okElements = this.elements.stream()
				.allMatch((e) -> e.collectAndPartialResolve(classScope));

		// vérif unicité des noms d'attributs
		List<String> attributeNames = this.attributes.stream()
				.map(e -> e.getName()).collect(Collectors.toList());
		Set<String> duplicates = attributeNames.stream()
				.filter(e -> Collections.frequency(attributeNames, e) > 1)
				.collect(Collectors.toSet());
		if (!duplicates.isEmpty()) {
			Logger.error("[ClassDeclaration] The class " + this.name + " has duplicate attributes: " + duplicates);
		}

		// vérif unicité des (noms, signature) des méthodes
		Set<String> methodSignatures = new HashSet<>();
		Set<String> duplicateMethods = new HashSet<>();
		for (MethodDeclaration m : this.methods) {
			String signature = m.getSignature();
			if (!methodSignatures.add(signature)) {
				duplicateMethods.add(signature);
			}
		}
		if (!duplicateMethods.isEmpty()) {
			Logger.error("[ClassDeclaration] The class " + this.name + " has duplicate method signatures: "
					+ duplicateMethods);
		}

		// vérif unicité des constructeurs
		Set<String> constructorSignatures = new HashSet<>();
		Set<String> duplicateConstructors = new HashSet<>();
		for (ConstructorDeclaration c : this.constructors) {
			String signature = c.getSignature();
			if (!constructorSignatures.add(signature)) {
				duplicateConstructors.add(signature);
			}
		}
		if (!duplicateConstructors.isEmpty()) {
			Logger.error("[ClassDeclaration] The class " + this.name + " has duplicate constructor signatures: "
					+ duplicateConstructors);
		}

		return okElements;
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
		boolean okAncestor = ancestorClass == null || ancestorClass.checkType();
		boolean okElements = this.elements.stream()
				.allMatch((e) -> e.checkType());
		return okAncestor && okElements;
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		int off = 0;
		//Instancie les offsets : ex class Chien{int poids, method grossir} -> poids offset 0, grossir offset 1
		// appel methode grossir -> adresse objet + offset (1)
		for (ClassElement elem : elements) { // liste triée 
			off += elem.allocateMemory(register, off);
		}
		return 0; // Pas d'off
		//throw new SemanticsUndefinedException("Semantics allocatememory is undefined in ClassDeclaration.");
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
		return this.type;
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
