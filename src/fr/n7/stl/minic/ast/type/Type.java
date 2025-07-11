/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;

/**
 * Gathers the common services provided by types.
 * Must be implemented by all the classes representing types in the language.
 * 
 * @author Marc Pantel
 *
 */
public interface Type {

	/**
	 * Check if two types are equals.
	 * This must be an equivalence relation.
	 * 
	 * @param other The other type (with respect to self).
	 * @return True if the type is equals with the type other, False otherwise.
	 */
	public boolean equalsTo(Type other);

	/**
	 * Check if two types are compatibles. A subtype is compatibleWith a supertype,
	 * but a supertype is not compatible with a subtype.
	 * This must be a partial order relation.
	 * Check that the self type is compatible with the other type, i.e. all values
	 * of self can be
	 * used as a value of other.
	 * 
	 * <p><b> UN POINT COLORÉ EST COMPATIBLE AVEC UN POINT </b></p>
	 * 
	 * @param other The other type
	 * @return True if the types are compatibles, False otherwise.
	 */
	public boolean compatibleWith(Type other);

	/**
	 * Builds a new type that results from the merging of self and other according
	 * to the compatibleWith relation.
	 * Compute the least common type (least upper bound) of two types according to
	 * the compatibleWith relation.
	 * TA.merge(TB).compatibleWith(TA) and TA.merge(TB).compatibleWith(TB).
	 * 
	 * @param other The other type.
	 * @return A type that is the least upper bound of self and other according to
	 *         compatibleWith.
	 */
	public Type merge(Type other);

	/**
	 * Compute the size in TAM words needed to store a value of the self type.
	 * 
	 * @return Number of TAM words needed to store a value of the self type.
	 */
	public int length();

	/**
	 * Inherited Semantics attribute to check that all identifiers have been defined
	 * and
	 * associate all identifiers uses with their definitions.
	 * 
	 * @param scope Inherited Scope attribute that contains the defined
	 *               identifiers.
	 * @return Synthesized Semantics attribute that indicates if the identifier used
	 *         in the
	 *         type have been previously defined.
	 * 
	 */
	public boolean completeResolve(HierarchicalScope<Declaration> scope);

}
