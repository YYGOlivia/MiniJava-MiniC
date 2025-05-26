package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;

public abstract class AbstractAttribute<ObjectKind extends Expression> implements Expression {

	protected ObjectKind object;
	protected String name;
	protected AttributeDeclaration attribute;

	public AbstractAttribute(ObjectKind object, String name) {
		this.object = object;
		this.name = name;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String image = "";
		image += this.object;
		image += ".";
		image += this.name;
		return image;
	}

}
