/**
 * 
 */
package fr.n7.stl.minic.ast.scope;

/**
 * Interface to mark a node in the Abstract Syntax Tree as a Hierarchical Scope
 * in the language.
 * 
 * @author Marc Pantel
 *
 */
public interface HierarchicalScope<D extends Declaration> extends Scope<D> {

	/**
	 * Check if an element is registered (known) in the whole hierarchical scope.
	 * 
	 * @param name : Name of the element looked for in the whole hierarchical
	 *              scope.
	 * @return : True if the whole hierarchical scope knows an element named name,
	 *         false if not.
	 */
	public boolean knows(String name);

}
