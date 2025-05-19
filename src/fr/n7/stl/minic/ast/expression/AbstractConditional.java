/**
 * 
 */
package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

/**
 * Abstract Syntax Tree node for a conditional expression.
 * 
 * @author Marc Pantel
 *
 */
public class AbstractConditional<ExpressionKind extends Expression> implements Expression {

	/**
	 * AST node for the expression whose value is the condition for the conditional
	 * expression.
	 */
	protected Expression condition;

	/**
	 * AST node for the expression whose value is the then parameter for the
	 * conditional expression.
	 */
	protected ExpressionKind thenExpression;

	/**
	 * AST node for the expression whose value is the else parameter for the
	 * conditional expression.
	 */
	protected ExpressionKind elseExpression;

	/**
	 * Builds a binary expression Abstract Syntax Tree node from the left and right
	 * sub-expressions
	 * and the binary operation.
	 * 
	 * @param _left     : Expression for the left parameter.
	 * @param _operator : Binary Operator.
	 * @param _right    : Expression for the right parameter.
	 */
	public AbstractConditional(Expression _condition, ExpressionKind _then, ExpressionKind _else) {
		this.condition = _condition;
		this.thenExpression = _then;
		this.elseExpression = _else;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean okCond = condition.collectAndPartialResolve(_scope);
		boolean okThen = thenExpression.collectAndPartialResolve(_scope);
		boolean okElse = elseExpression.collectAndPartialResolve(_scope);
		return okCond && okThen && okElse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		boolean okCond = condition.completeResolve(_scope);
		boolean okThen = thenExpression.completeResolve(_scope);
		boolean okElse = elseExpression.completeResolve(_scope);
		return okCond && okThen && okElse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.condition + " ? " + this.thenExpression + " : " + this.elseExpression + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		Type thenType = this.thenExpression.getType();
		Type elseType = this.elseExpression.getType();
		return thenType.merge(elseType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in ConditionalExpression.");
	}

}
