package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

public class BinaryExpression implements Expression {

    private Expression left;
    private Expression right;
    private BinaryOperator operator;

    public BinaryExpression(Expression left, BinaryOperator operator, Expression right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "(" + this.left + " " + this.operator + " " + this.right + ")";
    }

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        boolean okLeft = this.left.collectAndPartialResolve(scope);
        boolean okRight = this.right.collectAndPartialResolve(scope);
        return okLeft && okRight;
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        boolean okLeft = this.left.completeResolve(scope);
        boolean okRight = this.right.completeResolve(scope);
        return okLeft && okRight;
    }

    @Override
    public Type getType() {
        Type lType = this.left.getType();
        Type rType = this.right.getType();
        Type resultType = lType.merge(rType);
        if (resultType.equals(AtomicType.ErrorType)) {
            Logger.warning("Type error in binary expression : Merged parameters " + lType + " " + rType);
        }
        switch (this.operator) {
            case Add: {
                if (resultType.compatibleWith(AtomicType.FloatingType)
                        || resultType.compatibleWith(AtomicType.StringType)) {
                    return resultType;
                } else {
                    Logger.warning("Type error in binary expression : " + this.operator + " parameter " + resultType);
                    return AtomicType.ErrorType;
                }
            }
            case Substract:
            case Multiply:
            case Divide: {
                if (resultType.compatibleWith(AtomicType.FloatingType)) {
                    return resultType;
                } else {
                    Logger.warning("Type error in binary expression : " + this.operator + " parameter " + resultType);
                    return AtomicType.ErrorType;
                }
            }
            case Modulo: {
                if (resultType.compatibleWith(AtomicType.IntegerType)) {
                    return resultType;
                } else {
                    Logger.warning("Type error in binary expression : " + this.operator + " parameter " + resultType);
                    return AtomicType.ErrorType;
                }
            }
            case Lesser:
            case Greater:
            case LesserOrEqual:
            case GreaterOrEqual: {
                if (resultType.compatibleWith(AtomicType.FloatingType)) {
                    return AtomicType.BooleanType;
                } else {
                    Logger.warning("Type error in binary expression : " + this.operator + " parameter " + resultType);
                    return AtomicType.ErrorType;
                }
            }
            case Equals:
            case Different: {
                if (resultType.equals(AtomicType.ErrorType)) {
                    return resultType;
                } else {
                    return AtomicType.BooleanType;
                }
            }
            default:
                return AtomicType.ErrorType;
        }
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        Fragment frag = this.left.getCode(factory);
        frag.append(this.right.getCode(factory));
        frag.add(this.operator.toTAM());
        return frag;
    }
}