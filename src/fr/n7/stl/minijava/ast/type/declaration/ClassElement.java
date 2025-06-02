package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;

public abstract class ClassElement implements Declaration {

	/**
	 * élément de classe ou d'instance
	 */
	private ElementKind elementKind;

	private AccessRight accessRight;

	private String name;

	private ClassDeclaration classDeclaration;

	public ClassElement(ElementKind elementKind, AccessRight accessRight, String name) {
		this.elementKind = elementKind;
		this.accessRight = accessRight;
		this.name = name;
	}

	public ClassElement(String name) {
		this(ElementKind.OBJECT, AccessRight.PACKAGE, name);
	}

	public abstract boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope);

	public abstract boolean completeResolve(HierarchicalScope<Declaration> scope);

	public ElementKind getElementKind() {
		return this.elementKind;
	}

	public void setElementKind(ElementKind elementKind) {
		this.elementKind = elementKind;
	}

	public AccessRight getAccessRight() {
		return this.accessRight;
	}

	public void setAccessRight(AccessRight accessRight) {
		this.accessRight = accessRight;
	}

	public ClassDeclaration getClassDeclaration() {
		return this.classDeclaration;
	}

	public void setClassDeclaration(ClassDeclaration classDecl) {
		this.classDeclaration = classDecl;
	}

	@Override
	public String getName() {
		return this.name;
	}
}
