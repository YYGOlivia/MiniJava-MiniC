package fr.n7.stl.minijava.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.expression.AbstractAttribute;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class AttributeAssignment extends AbstractAttribute<AssignableExpression> implements AssignableExpression {

	public AttributeAssignment(AssignableExpression object, String name) {
		super(object, name);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		super.collectAndPartialResolve(scope);
		if (this.getAttribute().isFinal()) {
			Logger.error("[AttributeAssignment] The attribute " + getAttribute().getName()
					+ " is final is final and cannot be assigned.");
		}
		return true;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		super.completeResolve(scope);
		if (this.getAttribute().isFinal()) {
			Logger.error("[AttributeAssignment] The attribute " + getAttribute().getName()
					+ " is final is final and cannot be assigned.");
		}
		return true;
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in AttributeAssignment.");
	}

}
