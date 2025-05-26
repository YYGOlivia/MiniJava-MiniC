package fr.n7.stl.minijava.expression.accessible;

import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minijava.expression.AbstractMethodCall;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class MethodCallAccess extends AbstractMethodCall<AccessibleExpression> implements AccessibleExpression {

	public MethodCallAccess(AccessibleExpression target, String name, List<AccessibleExpression> arguments) {
		super(target, name, arguments);
	}

	public MethodCallAccess(String name, List<AccessibleExpression> arguments) {
		super(name, arguments);
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
