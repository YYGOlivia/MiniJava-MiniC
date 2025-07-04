/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractAccess;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a constant access
 * expression.
 * 
 * @author Marc Pantel
 */
public class ConstantAccess extends AbstractAccess {

	private ConstantDeclaration declaration;

	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * 
	 * @param name Name of the used variable.
	 */
	public ConstantAccess(ConstantDeclaration declaration) {
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
	public Fragment getCode(TAMFactory factory) {
		return this.declaration.getCode(factory);
	}

}
