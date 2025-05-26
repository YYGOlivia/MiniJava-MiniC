package fr.n7.stl.minijava.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.SemanticsUndefinedException;

public abstract class AbstractThis<ObjectKind extends Expression> implements Expression {

	public AbstractThis() {
		throw new SemanticsUndefinedException("Semantics constructor is undefined in AbstractThis.");
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
throw new SemanticsUndefinedException("Semantics collect is undefined in AbstractThis.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in AbstractThis.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is undefined in AbstractThis.");
	}

	@Override
	public String toString() {
		return "this";
	}
}
