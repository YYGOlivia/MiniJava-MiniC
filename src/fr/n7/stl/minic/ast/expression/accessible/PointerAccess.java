/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractPointer;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer access
 * expression.
 * 
 * @author Marc Pantel
 *
 */
public class PointerAccess extends AbstractPointer<AccessibleExpression> implements AccessibleExpression {

	/**
	 * Construction for the implementation of a pointer content access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param pointer Abstract Syntax Tree for the pointer expression in a pointer
	 *                 content access expression.
	 */
	public PointerAccess(AccessibleExpression pointer) {
		super(pointer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		// LOAD (size) pos_memoire[LB]
		Fragment fragment = factory.createFragment();
		fragment.append(pointer.getCode(factory));
		fragment.add(factory.createLoadI(pointer.getType().length()));
		return fragment;
	}

	@Override
	public String toString() {
		return "* " + this.pointer.toString();
	}

}
