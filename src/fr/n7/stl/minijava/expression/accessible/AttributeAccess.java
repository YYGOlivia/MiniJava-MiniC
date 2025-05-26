package fr.n7.stl.minijava.expression.accessible;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.expression.AbstractAttribute;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class AttributeAccess extends AbstractAttribute<AccessibleExpression> implements AccessibleExpression {

	public AttributeAccess(AccessibleExpression object, String name) {
		super(object, name);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
