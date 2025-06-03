package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;

public class AttributeDeclaration extends ClassElement {

	private Type type;
	private boolean isFinal;
	private Expression value;

	public AttributeDeclaration(String name, Type type, boolean isFinal, Expression value) {
		super(name);
		this.type = type;
		this.isFinal = isFinal;
		this.value = value;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'collectAndPartialResolve'");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'completeResolve'");
	}

	@Override
	public Type getType() {
		return this.type;
	}

	public boolean isFinal() {
		return this.isFinal;
	}

	public Expression getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.getAccessRight() + " " + this.getElementKind() + " " + type + " " + this.getName() + ";\n";
	}
}
