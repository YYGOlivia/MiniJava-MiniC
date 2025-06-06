package fr.n7.stl.minijava.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minijava.ast.expression.AbstractThis;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ThisAssignment extends AbstractThis<AssignableExpression> implements AssignableExpression {

	public ThisAssignment() {
		// rien à faire
		// throw new SemanticsUndefinedException("Semantics constructor is undefined in ThisAssignment.");
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment frag = factory.createFragment();
		frag.add(factory.createLoad(Register.LB, -1, 1));
		return frag;
		//throw new SemanticsUndefinedException("Semantics getCode is undefined in ThisAssignment.");
	}

}
