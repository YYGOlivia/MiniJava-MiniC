/**
 * 
 */
package fr.n7.stl.minic.ast.expression.value;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an integer constant
 * expression.
 * 
 * @author Marc Pantel
 *
 */
public class FloatingValue implements Value {

	private float value;

	/**
	 * Builds an integer value expression implementation from a textual
	 * representation of the integer.
	 * 
	 * @param text Textual representation of the integer value.
	 */
	public FloatingValue(String text) {
		value = Float.parseFloat(text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + this.value;
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
		return true;
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
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return AtomicType.FloatingType;
	}

	/*
	 * (non-Javadoc)
	 * Pushes the value on the stack.
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		// fragment.add(factory.createLoadL(this.value));
		return fragment;
	}

}
