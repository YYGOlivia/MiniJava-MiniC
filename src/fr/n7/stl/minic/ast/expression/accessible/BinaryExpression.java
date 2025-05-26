/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Abstract Syntax Tree node for a binary expression.
 * @author Marc Pantel
 *
 */
/**
 * @author Marc Pantel
 *
 */
public class BinaryExpression implements AccessibleExpression {

	/**
	 * AST node for the expression whose value is the left parameter for the binary
	 * expression.
	 */
	private AccessibleExpression left;

	/**
	 * AST node for the expression whose value is the left parameter for the binary
	 * expression.
	 */
	private AccessibleExpression right;

	/**
	 * Binary operator computed by the Binary Expression.
	 */
	private BinaryOperator operator;

	/**
	 * Builds a binary expression Abstract Syntax Tree node from the left and right
	 * sub-expressions
	 * and the binary operation.
	 * 
	 * @param left     : Expression for the left parameter.
	 * @param operator : Binary Operator.
	 * @param right    : Expression for the right parameter.
	 */
	public BinaryExpression(AccessibleExpression left, BinaryOperator operator, AccessibleExpression right) {
		this.left = left;
		this.right = right;
		this.operator = operator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.left + " " + this.operator + " " + this.right + ")";
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean left = this.left.collectAndPartialResolve(scope);
		boolean right = this.right.collectAndPartialResolve(scope);
		return left && right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean left = this.left.completeResolve(scope);
		boolean right = this.right.completeResolve(scope);
		return left && right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		Type left = this.left.getType();
		Type right = this.right.getType();
		Type resultType = left.merge(right);
		if (resultType.equals(AtomicType.ErrorType)) {
			Logger.warning("Type error in binary expression : Merged parameters " + left + " " + right);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment result = this.left.getCode(factory);
		//result.addComment(this.toString());
		/*
		 * if (this.left instanceof AccessibleExpression) {
		 * result.add(factory.createLoadI(this.left.getType().length())); }
		 */
		result.append(this.right.getCode(factory));
		/*
		 * if (this.right instanceof AccessibleExpression) {
		 * result.add(factory.createLoadI(this.right.getType().length())); }
		 */
		result.add(this.operator.toTAM());
		return result;
	}

}
