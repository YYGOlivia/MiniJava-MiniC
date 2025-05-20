/**
 * 
 */
package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.CoupleType;
import fr.n7.stl.minic.ast.type.NamedType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for an expression extracting
 * the second component in a couple.
 * 
 * @author Marc Pantel
 *
 */
public class Second implements AccessibleExpression {

	/**
	 * AST node for the expression whose value must whose second element is
	 * extracted by the expression.
	 */
	private AccessibleExpression target;

	/**
	 * Builds an Abstract Syntax Tree node for an expression extracting the second
	 * component of a couple.
	 * 
	 * @param target : AST node for the expression whose value must whose second
	 *                element is extracted by the expression.
	 */
	public Second(AccessibleExpression target) {
		this.target = target;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(snd" + this.target + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		Type targetType = NamedType.getTrueType(target);
		return ((CoupleType) targetType).getSecond();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean okTarget = this.target.collectAndPartialResolve(scope);
		Type targetTrueType = NamedType.getTrueType(target);
		if (!(targetTrueType instanceof CoupleType)) {
			Logger.error("[Second] " + target + " should be a couple type (is " + target.getType() + ").");
			return false;
		}
		return okTarget;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean okTarget = this.target.completeResolve(scope);
		Type targetTrueType = NamedType.getTrueType(target);
		if (!(targetTrueType instanceof CoupleType)) {
			Logger.error("[Second] " + target + " should be a couple type (is " + target.getType() + ").");
			return false;
		}
		return okTarget;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		// LOAD la variable
		fragment.append(target.getCode(factory));
		// POP (1) 1
		fragment.add(factory.createPop(1, 1));
		return fragment;
	}

}
