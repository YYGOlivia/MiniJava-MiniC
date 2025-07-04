package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Common elements between identifier various use.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractAccess {

	/**
	 * Provide access to the declaration of the identifier.
	 * 
	 * @return Declaration of the identifier.
	 */
	public abstract Declaration getDeclaration();

	/**
	 * Synthesized Semantics attribute to compute the type of an identifier
	 * expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	public Type getType() {
		return this.getDeclaration().getType();
	}

	/**
	 * Synthesized Semantics attribute to generate the code of an identifier
	 * expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	public abstract Fragment getCode(TAMFactory factory);

}