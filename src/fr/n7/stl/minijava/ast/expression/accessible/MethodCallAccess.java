package fr.n7.stl.minijava.ast.expression.accessible;

import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minijava.ast.expression.AbstractMethodCall;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class MethodCallAccess extends AbstractMethodCall<AccessibleExpression> implements AccessibleExpression {

	public MethodCallAccess(AccessibleExpression target, String name, List<AccessibleExpression> arguments) {
		super(target, name, arguments);
	}

	public MethodCallAccess(String name, List<AccessibleExpression> arguments) {
		super(name, arguments);
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragMethAcc = factory.createFragment();
		for (AccessibleExpression arg : this.getArguments()) {
			fragMethAcc.append(arg.getCode(factory));
		}
		if (this.target == null) {//Appel à une methode statique
			fragMethAcc.add(factory.createCall(this.declaration.getName(), Register.LB));
		} else {//Appel à une methode d'instance
			fragMethAcc.append(this.target.getCode(factory));
			fragMethAcc.add(factory.createLoadL(0));
			fragMethAcc.add(factory.createLoad(Register.ST, -2, 1));
			fragMethAcc.add(factory.createLoadL(this.declaration.getOffset()));
			fragMethAcc.add(Library.IAdd);
			fragMethAcc.add(factory.createCallI());
		}
		return fragMethAcc;
	}

}
