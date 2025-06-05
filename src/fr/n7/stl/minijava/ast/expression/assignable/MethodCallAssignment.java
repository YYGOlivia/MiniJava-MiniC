package fr.n7.stl.minijava.ast.expression.assignable;

import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minijava.ast.expression.AbstractMethodCall;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
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
		Fragment fragMethAss = factory.createFragment();
		for (AccessibleExpression arg : this.getArguments()) {
			fragMethAss.append(arg.getCode(factory));
		}
		if (this.target == null) {//Appel à une methode statique
			fragMethAss.add(factory.createCall(this.declaration.getName(), Register.LB));
		} else {//Appel à une methode d'instance
			fragMethAss.append(this.target.getCode(factory));
			fragMethAss.add(factory.createLoadL(0));
			fragMethAss.add(factory.createLoad(Register.ST, -2, 1));
			fragMethAss.add(factory.createLoadL(this.declaration.getOffset()));
			fragMethAss.add(Library.IAdd);
			fragMethAss.add(factory.createCallI());
		}	
		return fragMethAss;
	}

}
