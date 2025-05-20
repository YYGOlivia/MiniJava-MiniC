/**
 * 
 */
package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.CoupleType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Abstract Syntax Tree node for building a couple value.
 * 
 * @author Marc Pantel
 *
 */
public class Couple implements AccessibleExpression {

	/**
	 * AST node for the expression whose value is the first value in a couple
	 * expression.
	 */
	private AccessibleExpression first;

	/**
	 * AST node for the expression whose value is the second value in a couple
	 * expression.
	 */
	private AccessibleExpression second;

	/**
	 * Construction for a couple expression implementation.
	 * 
	 * @param first  First part of the couple.
	 * @param second Second part of the couple.
	 */
	public Couple(AccessibleExpression first, AccessibleExpression second) {
		this.first = first;
		this.second = second;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "< " + this.first + ", " + this.second + ">";
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
		boolean first = this.first.collectAndPartialResolve(scope);
		boolean second = this.second.collectAndPartialResolve(scope);
		return first && second;
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
		boolean first = this.first.completeResolve(scope);
		boolean second = this.second.completeResolve(scope);
		return first && second;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return new CoupleType(this.first.getType(), this.second.getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		fragment.append(first.getCode(factory));
		fragment.append(second.getCode(factory));
		return fragment;
	}

}
