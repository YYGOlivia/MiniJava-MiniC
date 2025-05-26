package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.type.Type;

public class AttributeDeclaration extends ClassElement {

	private Type type;

	public AttributeDeclaration(String name, Type type) {
		super(name);
		this.type = type;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.getAccessRight() + " " + type + " " + this.getName() + ";\n";
	}
}
