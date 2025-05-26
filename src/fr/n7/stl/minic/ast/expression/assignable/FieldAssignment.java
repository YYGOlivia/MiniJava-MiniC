/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractField;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Abstract Syntax Tree node for an expression whose computation assigns a field
 * in a record.
 * 
 * @author Marc Pantel
 *
 */
public class FieldAssignment extends AbstractField<AssignableExpression> implements AssignableExpression {

	/**
	 * Construction for the implementation of a record field assignment expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param record Abstract Syntax Tree for the record part in a record field
	 *                assignment expression.
	 * @param name   Name of the field in the record field assignment expression.
	 */
	public FieldAssignment(AssignableExpression record, String name) {
		super(record, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		if (this.getRecord() instanceof VariableAssignment){
			VariableAssignment var = (VariableAssignment) this.getRecord();
			VariableDeclaration dec = (VariableDeclaration) var.getDeclaration();
			fragment.add(factory.createLoadA(dec.getRegister(), dec.getOffset()));
		}else{
			fragment.append(this.getRecord().getCode(factory));
		}
		fragment.add(factory.createLoadL(this.getField().getOffset()));
		fragment.add(Library.IAdd);
		fragment.addComment("FieldAssignement" + this.getField());
		return fragment;
		//throw new SemanticsUndefinedException("Semantics getCode undefined in FieldAssignment.");
	}

}
