/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.type.Type;

/**
 * Abstract Syntax Tree node for a formal parameter in a function declaration.
 * 
 * @author Marc Pantel
 */
public class ParameterDeclaration implements Declaration {

	/**
	 * Name of the formal parameter
	 */
	private String name;

	/**
	 * AST node for the type of the formal parameter
	 */
	private Type type;

	/**
	 * Offset of the formal parameter in the list of parameters for the function
	 * i.e. the size of the memory allocated to the previous parameters
	 */
	private int offset;

	/**
	 * Builds an AST node for a formal parameter declaration
	 * 
	 * @param name : Name of the formal parameter
	 * @param type : AST node for the type of the formal parameter
	 */
	public ParameterDeclaration(String name, Type type) {
		this.name = name;
		this.type = type;
		this.offset = -1; // This value should never occur...
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type + " " + this.name;
	}

	/**
	 * Provide the type of the formal parameter in the list of formal parameters for
	 * the function
	 * 
	 * @return Type of the formal parameter
	 */
	public Type getType() {
		return this.type;
	}

	/**
	 * Provide the offset of the formal parameter in the list of formal parameters
	 * for the function
	 * 
	 * @return Offset of the formal parameter
	 */
	public int getOffset() {
		return this.offset;
	}

	/**
	 * Set the offset of the formal parameter in the list of formal parameters for
	 * the function
	 *
	 * @param offset Offset of the formal parameter
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

}
