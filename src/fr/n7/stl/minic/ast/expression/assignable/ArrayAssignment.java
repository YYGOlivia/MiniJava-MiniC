/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractArray;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Abstract Syntax Tree node for an expression whose computation assigns a cell
 * in an array.
 * 
 * @author Marc Pantel
 */
public class ArrayAssignment extends AbstractArray<AssignableExpression> implements AssignableExpression {

	/**
	 * Construction for the implementation of an array element assignment expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param array Abstract Syntax Tree for the array part in an array element
	 *               assignment expression.
	 * @param index Abstract Syntax Tree for the index part in an array element
	 *               assignment expression.
	 */
	public ArrayAssignment(AssignableExpression array, AccessibleExpression index) {
		super(array, index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.impl.ArrayAccessImpl#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		//variable array
		if (array instanceof ArrayAssignment){
			fragment.append(array.getCode(factory));
		}else {
			VariableAssignment var = (VariableAssignment) array;
			VariableDeclaration dec = (VariableDeclaration) var.getDeclaration();
			fragment.add(factory.createLoad(dec.getRegister(), dec.getOffset(), array.getType().length()));
		}
		//variable index
		fragment.append(index.getCode(factory));
		//taille des elements
		fragment.add(factory.createLoadL(array.getType().length()));
		// indice*taille elem
		fragment.add(Library.IMul);
		// debut tableau + (indice*taille elem)
		fragment.add(Library.IAdd);
		// ecriture dans la case
		fragment.add(factory.createStoreI(array.getType().length()));
		fragment.addComment("Assignement");
		return fragment;
	}

	public Fragment getAccessCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		//variable array
		if (array instanceof ArrayAssignment){
			fragment.append(array.getCode(factory));
		}else {
			VariableAssignment var = (VariableAssignment) array;
			VariableDeclaration dec = (VariableDeclaration) var.getDeclaration();
			fragment.add(factory.createLoad(dec.getRegister(), dec.getOffset(), array.getType().length()));
		}
		
		//variable index
		fragment.append(index.getCode(factory));
		//taille des elements
		fragment.add(factory.createLoadL(array.getType().length()));
		// indice*taille elem
		fragment.add(Library.IMul);
		// debut tableau + (indice*taille elem)
		fragment.add(Library.IAdd);
		return fragment;
	}

}
