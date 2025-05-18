/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractField;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

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
	 * @param _record Abstract Syntax Tree for the record part in a record field
	 *                assignment expression.
	 * @param _name   Name of the field in the record field assignment expression.
	 */
	public FieldAssignment(AssignableExpression _record, String _name) {
		super(_record, _name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Logger.warning("FiledAssignement " + super.record.getClass().toString());
		Fragment fragment = _factory.createFragment();
		if (record instanceof VariableAssignment){
			VariableAssignment var = (VariableAssignment) record;
			VariableDeclaration dec = (VariableDeclaration) var.getDeclaration();
			fragment.add(_factory.createLoadA(dec.getRegister(), dec.getOffset()));
		}else{
			fragment.append(record.getCode(_factory));
		}
		fragment.add(_factory.createLoadL(super.field.getOffset()));
		fragment.add(Library.IAdd);
		fragment.addComment("FieldAssignement" + record.toString());
		return fragment;
		//throw new SemanticsUndefinedException("Semantics getCode undefined in FieldAssignment.");
	}

}
