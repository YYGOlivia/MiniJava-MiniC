/**
 * 
 */
package fr.n7.stl.minic.ast.type;

/**
 * @author Marc Pantel
 *
 */
public interface PartialType extends Type {

	public Type complete(Type type);

	public void enrich(PartialType type);

}
