/**
 * 
 */
package fr.n7.stl.tam.ast;

/**
 * Sequence of TAMInstruction.
 * 
 * @author Marc Pantel
 *
 */
public interface Fragment {

	/**
	 * Adds a TAM instruction at the end of the fragment.
	 * 
	 * @param instruction TAM instruction added at the end of the fragment.
	 */
	public void add(TAMInstruction instruction);

	/**
	 * Adds a prefix comment to the first TAM instruction of the fragment.
	 * 
	 * @param comment Comment that is added to the first TAM instruction of the
	 *                 fragment.
	 */
	public void addComment(String comment);

	/**
	 * Adds a prefix label to the first TAM instruction of the fragment.
	 * 
	 * @param label Label that is added to the first TAM instruction of the
	 *               fragment.
	 */
	public void addPrefix(String label);

	/**
	 * Adds a suffix label to the last TAM instruction of the fragment.
	 * 
	 * @param label Label that is added to the last TAM instruction of the
	 *               fragment.
	 */
	public void addSuffix(String label);

	/**
	 * Add the instructions from the provided fragment at the end of the fragment.
	 * 
	 * @param fragment Fragment whose instructions are added at the end of the
	 *                  fragment.
	 */
	public void append(Fragment fragment);

	public int getSize();

}
