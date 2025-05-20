/**
 * 
 */
package fr.n7.stl.tam.ast;

/**
 * A TAM instruction than can be prefixed by a label used to resolve the address
 * of the instruction
 * in the code part of the memory in the TAM virtual machine.
 * 
 * @author Marc Pantel
 *
 */
public interface TAMInstruction {

	/**
	 * Adds a prefix comment for the instruction.
	 * 
	 * @param comment Comment to be added as an instruction prefix.
	 */
	public void addComment(String comment);

	/**
	 * Adds a prefix label for the instruction.
	 * 
	 * @param label Label to be added to the instruction prefixes.
	 */
	public void addPrefix(String label);

	/**
	 * Adds a suffix label to the instruction.
	 * 
	 * @param label Label to be added to the instruction suffixes.
	 */
	public void addSuffix(String label);
}
