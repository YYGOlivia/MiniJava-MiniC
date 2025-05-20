/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractAccess;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable access
 * expression.
 * 
 * @author Marc Pantel
 */
public class ParameterAccess extends AbstractAccess {

	protected ParameterDeclaration declaration;

	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * 
	 * @param name Name of the used variable.
	 */
	public ParameterAccess(ParameterDeclaration declaration) {
		this.declaration = declaration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.expression.AbstractUse#getDeclaration()
	 */
	public Declaration getDeclaration() {
		return this.declaration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.expression.AbstractUse#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		int pos = -declaration.getOffset();
		int size = declaration.getType().length();
		fragment.add(factory.createLoad(Register.LB, pos, size));
		return fragment;

	}

}
