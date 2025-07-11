/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents an Instruction node in the Abstract Syntax Tree node for the Bloc
 * language.
 * Declares the various semantics attributes for the node.
 * 
 * @author Marc Pantel
 *
 */
public interface Instruction {

	/**
	 * Inherited Semantics attribute to collect all the identifiers declaration and
	 * check
	 * that the declaration are allowed.
	 * 
	 * @param scope Inherited Scope attribute that contains the identifiers defined
	 *               previously
	 *               in the context.
	 * @return Synthesized Semantics attribute that indicates if the identifier
	 *         declaration are
	 *         allowed.
	 */
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope);

	/**
	 * Inherited Semantics attribute to collect all the identifiers declaration and
	 * check
	 * that the declaration are allowed.
	 * 
	 * @param scope     Inherited Scope attribute that contains the identifiers
	 *                   defined previously
	 *                   in the context.
	 * @param container Inherited Container attribute that allows to link the
	 *                   return instructions
	 *                   with the function declaration.
	 * @return Synthesized Semantics attribute that indicates if the identifier
	 *         declaration are
	 *         allowed.
	 */
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container);

	/**
	 * Inherited Semantics attribute to check that all identifiers have been defined
	 * and
	 * associate all identifiers uses with their definitions.
	 * 
	 * @param scope Inherited Scope attribute that contains the defined
	 *               identifiers.
	 * @return Synthesized Semantics attribute that indicates if the identifier used
	 *         in the
	 *         instruction have been previously defined.
	 */
	public boolean completeResolve(HierarchicalScope<Declaration> scope);

	/**
	 * Synthesized Semantics attribute to check that an instruction if well typed.
	 * 
	 * @return Synthesized True if the instruction is well typed, False if not.
	 */
	public boolean checkType();

	/**
	 * Inherited Semantics attribute to allocate memory for the variables declared
	 * in the instruction.
	 * Synthesized Semantics attribute that compute the size of the allocated
	 * memory.
	 * 
	 * @param register Inherited Register associated to the address of the
	 *                  variables.
	 * @param offset   Inherited Current offset for the address of the variables.
	 * @return Synthesized Size of the memory allocated to the variables.
	 */
	public int allocateMemory(Register register, int offset);

	/**
	 * Inherited Semantics attribute to build the nodes of the abstract syntax tree
	 * for the generated TAM code.
	 * Synthesized Semantics attribute that provide the generated TAM code.
	 * 
	 * @param factory Inherited Factory to build AST nodes for TAM code.
	 * @return Synthesized AST for the generated TAM code.
	 */
	public Fragment getCode(TAMFactory factory);

}
