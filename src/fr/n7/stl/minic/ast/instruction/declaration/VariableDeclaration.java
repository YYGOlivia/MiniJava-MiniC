/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.ArrayType;
import fr.n7.stl.minic.ast.type.NamedType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Abstract Syntax Tree node for a variable declaration instruction.
 * 
 * @author Marc Pantel
 *
 */
public class VariableDeclaration implements Declaration, Instruction {

	/**
	 * Name of the declared variable.
	 */
	protected String name;

	/**
	 * AST node for the type of the declared variable.
	 */
	protected Type type;

	/**
	 * AST node for the initial value of the declared variable.
	 */
	protected Expression value;

	/**
	 * Address register that contains the base address used to store the declared
	 * variable.
	 */
	protected Register register;

	/**
	 * Offset from the base address used to store the declared variable
	 * i.e. the size of the memory allocated to the previous declared variables
	 */
	protected int offset;

	/**
	 * Creates a variable declaration instruction node for the Abstract Syntax Tree.
	 * 
	 * @param name  Name of the declared variable.
	 * @param type  AST node for the type of the declared variable.
	 * @param value AST node for the initial value of the declared variable.
	 */
	public VariableDeclaration(String name, Type type, Expression value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type + " " + this.name + " = " + this.value + ";\n";
	}

	/**
	 * Synthesized semantics attribute for the type of the declared variable.
	 * 
	 * @return Type of the declared variable.
	 */
	public Type getType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.block.ast.VariableDeclaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Synthesized semantics attribute for the register used to compute the address
	 * of the variable.
	 * 
	 * @return Register used to compute the address where the declared variable will
	 *         be stored.
	 */
	public Register getRegister() {
		return this.register;
	}

	/**
	 * Synthesized semantics attribute for the offset used to compute the address of
	 * the variable.
	 * 
	 * @return Offset used to compute the address where the declared variable will
	 *         be stored.
	 */
	public int getOffset() {
		return this.offset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.accepts(this)) {
			Logger.error("[VariableDeclaration] The variable " + name + " is already declared");
			return false;
		}
		scope.register(this);
		boolean okValue = value.collectAndPartialResolve(scope);
		boolean okType = type.completeResolve(scope);
		return okValue && okType;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		if (!scope.accepts(this)) {
			Logger.error("[VariableDeclaration] The variable " + name + " is already declared");
			return false;
		}
		scope.register(this);
		boolean okValue = value.collectAndPartialResolve(scope);
		boolean okType = type.completeResolve(scope);
		return okValue && okType;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.accepts(this)) {
			Logger.error("[VariableDeclaration] The variable " + name + " is already declared");
			return false;
		}
		scope.register(this);
		boolean okValue = value.completeResolve(scope);
		boolean okType = type.completeResolve(scope);
		return okValue && okType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		// Type valueType = value.getType();
		Type valueTrueType = NamedType.getTrueType(value);
		Type thisTrueType = NamedType.getTrueType(this);
		if (!valueTrueType.compatibleWith(thisTrueType)) {
			Logger.error(
					"[VariableDeclaration] The type " + valueTrueType
							+ " is not compatible with the declared type of " + name + " ("
							+ thisTrueType + ").");
			return false;
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register,
	 * int)
	 */
	@Override
	public int allocateMemory(Register register, int offset) {
		this.register = register;
		this.offset = offset;
		return type.length();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment result = factory.createFragment();
		result.add(factory.createPush(type.length()));
		if (type instanceof ArrayType){
			//On alloue d'abord de la place au tableau
			result.add(factory.createLoadL(value.getType().length()));
			result.add(Library.MAlloc);
			result.add(factory.createStore(register, offset, type.length()));
			//On recupère le code de la valeur
			result.append(this.value.getCode(factory));
			// On récupere l'adresse du tableau
			result.add(factory.createLoad(register, offset, type.length()));
			result.add(factory.createStoreI(value.getType().length()));
		}else{
			result.append(this.value.getCode(factory));
			result.add(factory.createStore(register, offset, type.length()));
		}
		//result.addComment(this.toString());
		return result;
	}

}
