package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.scope.Declaration;

public abstract class ClassElement implements Declaration {

	private ElementKind elementKind;

	private AccessRight accessRight;

	private String name;

	public ClassElement(ElementKind elementKind, AccessRight accessRight, String name) {
		this.elementKind = elementKind;
		this.accessRight = accessRight;
		this.name = name;
	}

	public ClassElement(String name) {
		this(ElementKind.OBJECT, AccessRight.PACKAGE, name);
	}

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

	@Override
	public String getName() {
		return this.name;
	}
}
