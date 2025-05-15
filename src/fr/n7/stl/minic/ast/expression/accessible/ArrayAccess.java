/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractArray;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for accessing an array
 * element.
 * 
 * @author Marc Pantel
 *
 */
public class ArrayAccess extends AbstractArray<AccessibleExpression> implements AccessibleExpression {

	/**
	 * Construction for the implementation of an array element access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param _array Abstract Syntax Tree for the array part in an array element
	 *               access expression.
	 * @param _index Abstract Syntax Tree for the index part in an array element
	 *               access expression.
	 */
	public ArrayAccess(AccessibleExpression _array, AccessibleExpression _index) {
		super(_array, _index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		//variable array
		fragment.append(array.getCode(_factory));
		//variable index
		fragment.append(index.getCode(_factory));
		//taille des elements
		fragment.add(_factory.createLoadL(array.getType().length()));
		// indice*taille elem
		fragment.add(Library.IMul);
		// debut tableau + (indice*taille elem)
		fragment.add(Library.IAdd);
		//charge element
		fragment.add(_factory.createLoadI(array.getType().length()));
		return fragment;
	}

}
