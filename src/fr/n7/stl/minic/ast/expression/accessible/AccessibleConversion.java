package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractConversion;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.type.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a type conversion
 * expression.
 * 
 * @author Marc Pantel
 *
 */
public class AccessibleConversion extends AbstractConversion<Expression> implements AccessibleExpression {

	public AccessibleConversion(Expression target, String type) {
		super(target, type);
	}

	public AccessibleConversion(Expression target, Type type) {
		super(target, type);
	}

}
