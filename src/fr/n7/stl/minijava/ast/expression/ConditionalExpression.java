package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ConditionalExpression implements Expression {

    private Expression condition;
    private Expression thenExpression;
    private Expression elseExpression;

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
        Type condType = condition.getType();
        if (!(condType.equalsTo(AtomicType.BooleanType))) {
            Logger.error("[ConditionalExpression] Condition is of type " + condType
                    + "(expected BooleanType).");
        }
        boolean okCond = condition.collectAndPartialResolve(_scope);
        boolean okThen = thenExpression.collectAndPartialResolve(_scope);
        boolean okElse = elseExpression.collectAndPartialResolve(_scope);
        return okCond && okThen && okElse;
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
        Type condType = condition.getType();
        if (!(condType.equalsTo(AtomicType.BooleanType))) {
            Logger.error("[ConditionalExpression] Condition is of type " + condType
                    + "(expected BooleanType).");
        }
        boolean okCond = condition.completeResolve(_scope);
        boolean okThen = thenExpression.completeResolve(_scope);
        boolean okElse = elseExpression.completeResolve(_scope);
        return okCond && okThen && okElse;
    }

    @Override
    public String toString() {
        return "(" + this.condition + " ? " + this.thenExpression + " : " + this.elseExpression + ")";
    }

    @Override
    public Type getType() {
        Type thenType = this.thenExpression.getType();
        Type elseType = this.elseExpression.getType();
        return thenType.merge(elseType);
    }

    @Override
    public Fragment getCode(TAMFactory _factory) {
        throw new SemanticsUndefinedException("Semantics getCode is undefined in ConditionalExpression.");
    }
}