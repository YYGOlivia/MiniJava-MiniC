/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractConditional;
import fr.n7.stl.minic.ast.expression.Expression;

/**
 * @author marc
 *
 */
public class AssignableConditional extends AbstractConditional<AssignableExpression> implements AssignableExpression {

	public AssignableConditional(Expression condition, AssignableExpression thenExpr, AssignableExpression elseExpr) {
		super(condition, thenExpr, elseExpr);
	}

}
