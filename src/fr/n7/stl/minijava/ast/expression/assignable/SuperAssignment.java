package fr.n7.stl.minijava.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minijava.ast.expression.AbstractSuper;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class SuperAssignment extends AbstractSuper<AssignableExpression> implements AssignableExpression {

	public SuperAssignment() {
		// rien a faire non plus ? 
		//throw new SemanticsUndefinedException("Semantics constructor is undefined in SuperAssignment.");
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in SuperAssignment.");
	}

}
