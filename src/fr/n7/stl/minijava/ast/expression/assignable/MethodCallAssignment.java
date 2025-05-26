package fr.n7.stl.minijava.ast.expression.assignable;

import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minijava.ast.expression.AbstractMethodCall;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class MethodCallAssignment extends AbstractMethodCall<AssignableExpression> implements AssignableExpression {

	public MethodCallAssignment(AssignableExpression target, String name, List<AccessibleExpression> arguments) {
		super(target, name, arguments);
	}

	public MethodCallAssignment(String name, List<AccessibleExpression> arguments) {
		this(null, name, arguments);
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in MethodCallAssignment.");
	}

}
