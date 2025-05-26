/**
 * 
 */
package fr.n7.stl.minic.ast;

import java.util.List;

import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Represents a Block node in the Abstract Syntax Tree node for the Bloc
 * language.
 * Declares the various semantics attributes for the node.
 * 
 * A block contains declarations. It is thus a Scope even if a separate
 * SymbolTable is used in
 * the attributed semantics in order to manage declarations.
 * 
 * @author Marc Pantel
 *
 */
public class Block {

	/**
	 * Sequence of instructions contained in a block.
	 */
	private List<Instruction> instructions;

	/**
	 * Constructor for a block.
	 */
	public Block(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String local = "";
		for (Instruction instruction : this.instructions) {
			local += instruction;
		}
		return "{\n" + local + "}\n";
	}

	/**
	 * Inherited Semantics attribute to collect all the identifiers declaration and
	 * check
	 * that the declaration are allowed.
	 * 
	 * @param scope Inherited Scope attribute that contains the identifiers defined
	 *              previously
	 *              in the context.
	 * @return Synthesized Semantics attribute that indicates if the identifier
	 *         declaration are
	 *         allowed.
	 */
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean ok = true;
		SymbolTable newScope = new SymbolTable(scope);
		for (Instruction i : instructions) {
			ok = ok && i.collectAndPartialResolve(newScope);
		}
		return ok;
	}

	/**
	 * Inherited Semantics attribute to collect all the identifiers declaration and
	 * check
	 * that the declaration are allowed.
	 * 
	 * @param scope     Inherited Scope attribute that contains the identifiers
	 *                  defined previously
	 *                  in the context.
	 * @param container Inherited Container attribute that allows to link the
	 *                  return instructions
	 *                  with the function declaration.
	 * @return Synthesized Semantics attribute that indicates if the identifier
	 *         declaration are
	 *         allowed.
	 */
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		boolean ok = true;
		SymbolTable newScope = new SymbolTable(scope);
		for (Instruction i : instructions) {
			ok = ok && i.collectAndPartialResolve(newScope, container);
		}
		return ok;
	}

	/**
	 * Inherited Semantics attribute to check that all identifiers have been defined
	 * and
	 * associate all identifiers uses with their definitions.
	 * 
	 * @param scope Inherited Scope attribute that contains the defined
	 *              identifiers.
	 * @return Synthesized Semantics attribute that indicates if the identifier used
	 *         in the
	 *         block have been previously defined.
	 */
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean ok = true;
		SymbolTable newScope = new SymbolTable(scope);
		for (Instruction i : instructions) {
			ok = ok && i.completeResolve(newScope);
		}
		return ok;
	}

	/**
	 * Synthesized Semantics attribute to check that an instruction if well typed.
	 * 
	 * @return Synthesized True if the instruction is well typed, False if not.
	 */
	public boolean checkType() {
		boolean ok = true;
		for (Instruction i : instructions) {
			ok = ok && i.checkType();
		}
		return ok;
	}

	/**
	 * Inherited Semantics attribute to allocate memory for the variables declared
	 * in the instruction.
	 * Synthesized Semantics attribute that compute the size of the allocated
	 * memory.
	 * 
	 * @param register Inherited Register associated to the address of the
	 *                 variables.
	 * @param offset   Inherited Current offset for the address of the variables.
	 */
	public void allocateMemory(Register register, int offset) {
		int off = offset;
		for (Instruction instr : instructions) {
			off += instr.allocateMemory(register, off);
		}
		// this.off = off;
	}

	// private int off;

	/**
	 * Inherited Semantics attribute to build the nodes of the abstract syntax tree
	 * for the generated TAM code.
	 * Synthesized Semantics attribute that provide the generated TAM code.
	 * 
	 * @param factory Inherited Factory to build AST nodes for TAM code.
	 * @return Synthesized AST for the generated TAM code.
	 */
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		for (Instruction instr : instructions) {
			if (!(instr instanceof FunctionDeclaration)) {
				// on ajoute seulement les instructions qui ne sont pas des fonctions
				fragment.append(instr.getCode(factory));
			}
		}
		// fragment.addComment(toString());
		return fragment;
	}

	public Fragment getFunctions(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		for (Instruction instr : instructions) {
			if (instr instanceof FunctionDeclaration) {
				// on ajoute seulement les instructions qui sont des déclarations de fonction
				fragment.append(instr.getCode(factory));
			}
		}
		// fragment.addComment(toString());
		return fragment;
	}
}
