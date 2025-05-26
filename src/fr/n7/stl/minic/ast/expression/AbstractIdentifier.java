package fr.n7.stl.minic.ast.expression;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractIdentifier implements Expression {

	/**
	 * Name of the variable.
	 */
	private String name;

	/**
	 * Creates a variable related expression Abstract Syntax Tree node.
	 * 
	 * @param name Name of the variable.
	 */
	public AbstractIdentifier(String name) {
		this.name = name;
	}

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
		return " " + this.name + " ";
	}

}