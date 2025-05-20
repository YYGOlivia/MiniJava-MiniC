/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractArray;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
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
	 * @param array Abstract Syntax Tree for the array part in an array element
	 *               access expression.
	 * @param index Abstract Syntax Tree for the index part in an array element
	 *               access expression.
	 */
	public ArrayAccess(AccessibleExpression array, AccessibleExpression index) {
		super(array, index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		//variable array
		if (array instanceof IdentifierAccess){
			IdentifierAccess id = (IdentifierAccess) array;
			VariableDeclaration dec = (VariableDeclaration) id.expression.getDeclaration();
			fragment.add(factory.createLoad(dec.getRegister(), dec.getOffset(), array.getType().length()));
		}else if (array instanceof  ArrayAccess){
			fragment.append(array.getCode(factory));
		}
		//variable index
		fragment.append(index.getCode(factory));
		//taille des elements
		fragment.add(factory.createLoadL(array.getType().length()));
		// indice*taille elem
		fragment.add(Library.IMul);
		// debut tableau + (indice*taille elem)
		fragment.add(Library.IAdd);
		//charge element
		fragment.add(factory.createLoadI(array.getType().length()));
		fragment.addComment("Access");
		return fragment;
	}

}
