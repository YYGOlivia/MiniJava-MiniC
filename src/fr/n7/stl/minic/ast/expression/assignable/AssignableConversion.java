package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractConversion;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.Logger;

public class AssignableConversion extends AbstractConversion<AssignableExpression> implements AssignableExpression {

	public AssignableConversion(AssignableExpression target, String type) {
		super(target, type);
	}

	public AssignableConversion(AssignableExpression target, Type type) {
		super(target, type);
	}
}
