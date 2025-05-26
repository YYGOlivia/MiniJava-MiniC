package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.util.SemanticsUndefinedException;

public abstract class AbstractAttribute<ObjectKind extends Expression> implements Expression {

	private ObjectKind object;
	private String name;
	private AttributeDeclaration attribute;

	public AbstractAttribute(ObjectKind object, String name) {
		this.object = object;
		this.name = name;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics collect is undefined in AbstractAttribute.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in AbstractAttribute.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is undefined in AbstractAttribute.");
	}

	@Override
	public String toString() {
		return this.object + "." + this.name;
	}

}
