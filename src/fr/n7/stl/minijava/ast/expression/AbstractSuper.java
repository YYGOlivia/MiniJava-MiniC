package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.SemanticsUndefinedException;

public abstract class AbstractSuper<ObjectKind extends Expression> implements Expression {

	public AbstractSuper() {
		throw new SemanticsUndefinedException("Semantics constructor is undefined in AbstractSuper.");
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics collect is undefined in AbstractSuper.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in AbstractSuper.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is undefined in AbstractSuper.");
	}

	@Override
	public String toString() {
		return "super";
	}

}
