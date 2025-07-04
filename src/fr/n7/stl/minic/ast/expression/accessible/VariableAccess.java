/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractAccess;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable access
 * expression.
 * 
 * @author Marc Pantel
 */
public class VariableAccess extends AbstractAccess {

	private VariableDeclaration declaration;

	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * 
	 * @param name Name of the used variable.
	 */
	public VariableAccess(VariableDeclaration declaration) {
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
		Fragment result = factory.createFragment();
		result.add(factory.createLoad(
				this.declaration.getRegister(),
				this.declaration.getOffset(),
				this.declaration.getType().length()));
		return result;
	}

}
