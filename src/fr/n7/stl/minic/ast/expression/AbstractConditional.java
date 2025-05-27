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
	private Expression condition;

	/**
	 * AST node for the expression whose value is the then parameter for the
	 * conditional expression.
	 */
	private ExpressionKind thenExpression;

	/**
	 * AST node for the expression whose value is the else parameter for the
	 * conditional expression.
	 */
	private ExpressionKind elseExpression;

	/**
	 * Builds a binary expression Abstract Syntax Tree node from the left and right
	 * sub-expressions
	 * and the binary operation.
	 * 
	 * @param left     : Expression for the left parameter.
	 * @param operator : Binary Operator.
	 * @param right    : Expression for the right parameter.
	 */
	public AbstractConditional(Expression condition, ExpressionKind thenBlock, ExpressionKind elseBlock) {
		this.condition = condition;
		this.thenExpression = thenBlock;
		this.elseExpression = elseBlock;
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
		boolean okCond = condition.collectAndPartialResolve(scope);
		boolean okThen = thenExpression.collectAndPartialResolve(scope);
		boolean okElse = elseExpression.collectAndPartialResolve(scope);
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
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean okCond = condition.completeResolve(scope);
		boolean okThen = thenExpression.completeResolve(scope);
		boolean okElse = elseExpression.completeResolve(scope);
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
	public Fragment getCode(TAMFactory factory) {
		int lNum = factory.createLabelNumber();

		Fragment fragAbsCond = factory.createFragment();
		fragAbsCond.append(this.condition.getCode(factory));
		fragAbsCond.add(factory.createJumpIf("if" + lNum, 1));
		fragAbsCond.append(this.elseExpression.getCode(factory));
		fragAbsCond.add(factory.createJump("fi" + lNum));

		Fragment fragAbsCondIf = factory.createFragment();
		fragAbsCondIf.append(this.thenExpression.getCode(factory));
		fragAbsCondIf.addPrefix("if" + lNum);
		fragAbsCondIf.addSuffix("fi" + lNum);

		fragAbsCond.append(fragAbsCondIf);

		return fragAbsCond;	}

}
