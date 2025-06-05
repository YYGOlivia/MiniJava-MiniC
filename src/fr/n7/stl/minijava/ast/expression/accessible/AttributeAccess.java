package fr.n7.stl.minijava.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.expression.AbstractAttribute;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class AttributeAccess extends AbstractAttribute<AccessibleExpression> implements AccessibleExpression {

	public AttributeAccess(AccessibleExpression object, String name) {
		super(object, name);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		return super.collectAndPartialResolve(scope);
		// throw new SemanticsUndefinedException("Semantics collect is undefined in AttributeAccess.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		return super.completeResolve(scope);
		//throw new SemanticsUndefinedException("Semantics resolve is undefined in AttributeAccess.");
	}

	@Override
	public Type getType() {
		return super.getType();
		//throw new SemanticsUndefinedException("Semantics getType is undefined in AttributeAccess.");
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragAttAcc = factory.createFragment();
		if (!this.attribute.isFinal()) {
			fragAttAcc.append(this.object.getCode(factory));
			fragAttAcc.add(factory.createLoadL(this.attribute.getOffset()));
			fragAttAcc.add(Library.IAdd);
			fragAttAcc.add(factory.createLoadI(this.attribute.getType().length()));
		}
		else {
			fragAttAcc.append(this.attribute.getValue().getCode(factory));
		}
		return fragAttAcc;
	}

}
