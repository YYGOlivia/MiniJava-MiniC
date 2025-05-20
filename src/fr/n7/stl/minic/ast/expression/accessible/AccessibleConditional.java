/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractConditional;
import fr.n7.stl.minic.ast.expression.Expression;

/**
 * @author marc
 *
 */
public class AccessibleConditional extends AbstractConditional<AccessibleExpression> implements AccessibleExpression {

	public AccessibleConditional(Expression condition, AccessibleExpression thenExpr, AccessibleExpression elseExpr) {
		super(condition, thenExpr, elseExpr);
	}

}
