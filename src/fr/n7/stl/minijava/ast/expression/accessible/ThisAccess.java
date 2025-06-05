package fr.n7.stl.minijava.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minijava.ast.expression.AbstractThis;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ThisAccess extends AbstractThis<AccessibleExpression> implements AccessibleExpression {

	public ThisAccess() {
		super();
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragThisAcc = factory.createFragment();
		fragThisAcc.add(factory.createLoad(Register.SB, 0, 1));
		return fragThisAcc;
	}

}
