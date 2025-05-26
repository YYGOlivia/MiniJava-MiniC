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
	 *              access expression.
	 * @param index Abstract Syntax Tree for the index part in an array element
	 *              access expression.
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
		// variable array
		if (this.getArray() instanceof IdentifierAccess) {
			IdentifierAccess id = (IdentifierAccess) this.getArray();
			VariableDeclaration dec = (VariableDeclaration) id.getExpression().getDeclaration();
			fragment.add(factory.createLoad(dec.getRegister(), dec.getOffset(), this.getArray().getType().length()));
		} else if (this.getArray() instanceof ArrayAccess) {
			fragment.append(this.getArray().getCode(factory));
		}
		// variable index
		fragment.append(this.getIndex().getCode(factory));
		// taille des elements
		fragment.add(factory.createLoadL(this.getArray().getType().length()));
		// indice*taille elem
		fragment.add(Library.IMul);
		// debut tableau + (indice*taille elem)
		fragment.add(Library.IAdd);
		// charge element
		fragment.add(factory.createLoadI(this.getArray().getType().length()));
		fragment.addComment("Access");
		return fragment;
	}

}
