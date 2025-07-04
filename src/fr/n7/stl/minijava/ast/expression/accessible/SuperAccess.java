package fr.n7.stl.minijava.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minijava.ast.expression.AbstractSuper;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class SuperAccess extends AbstractSuper<AccessibleExpression> implements AccessibleExpression {

	public SuperAccess() {
		super();
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in SuperAccess.");
	}

}
