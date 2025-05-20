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
 * Implementation of the Abstract Syntax Tree node for an unary operation
 * expression.
 * 
 * @author Marc Pantel
 *
 */
public class UnaryExpression implements AccessibleExpression {

	private UnaryOperator operator;
	private AccessibleExpression parameter;

	/**
	 * Builds a unary expression Abstract Syntax Tree node from the parameter
	 * sub-expression
	 * and the unary operation.
	 * 
	 * @param operator  : Unary Operator.
	 * @param parameter : Expression for the parameter.
	 */
	public UnaryExpression(UnaryOperator operator, AccessibleExpression parameter) {
		this.operator = operator;
		this.parameter = parameter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.operator + " " + this.parameter + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		return this.parameter.collectAndPartialResolve(scope);
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
		return this.parameter.completeResolve(scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment result = this.parameter.getCode(factory);
		// result.addComment(this.toString());
		/*
		 * if (this.parameter instanceof AccessibleExpression) {
		 * result.add(factory.createLoadI(this.parameter.getType().length())); }
		 */
		result.add(this.operator.toTAM());
		return result;
	}

}
