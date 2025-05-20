/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractField;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for accessing a field in a
 * record.
 * 
 * @author Marc Pantel
 *
 */
public class FieldAccess extends AbstractField<AccessibleExpression> implements AccessibleExpression {

	/**
	 * Construction for the implementation of a record field access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param record Abstract Syntax Tree for the record part in a record field
	 *                access expression.
	 * @param name   Name of the field in the record field access expression.
	 */
	public FieldAccess(AccessibleExpression record, String name) {
		super(record, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		fragment.append(record.getCode(factory));
		fragment.add(factory.createPop(super.field.getOffset(), super.field.getType().length()));
		return fragment;
	}

}
