package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

public class UnaryExpression implements Expression {

    private UnaryOperator operator;
    private Expression parameter;

    public UnaryExpression(UnaryOperator operator, Expression parameter) {
        this.operator = operator;
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "(" + this.operator + " " + this.parameter + ")";
    }

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        return this.parameter.collectAndPartialResolve(scope);
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        return this.parameter.completeResolve(scope);
    }

    @Override
    public Type getType() {
        Type resultType = this.parameter.getType();
        if (resultType.equals(AtomicType.ErrorType)) {
            return resultType;
        } else {
            switch (this.operator) {
                case Negate: {
                    if (resultType.compatibleWith(AtomicType.BooleanType)) {
                        return resultType;
                    } else {
                        Logger.warning("Type error in unary expression : Negate parameter " + resultType);
                        return AtomicType.ErrorType;
                    }
                }
                case Opposite: {
                    if (resultType.compatibleWith(AtomicType.FloatingType)) {
                        return resultType;
                    } else {
                        Logger.warning("Type error in unary expression : Opposite parameter " + resultType);
                        return AtomicType.ErrorType;
                    }
                }
                default:
                    return AtomicType.ErrorType;
            }
        }
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        Fragment frag = this.parameter.getCode(factory);
        frag.add(this.operator.toTAM());
        return frag;
    }
}