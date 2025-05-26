/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a constant declaration
 * instruction.
 * 
 * @author Marc Pantel
 *
 */
public class ConstantDeclaration implements Instruction, Declaration {

	/**
	 * Name of the constant
	 */
	private String name;

	/**
	 * AST node for the type of the constant
	 */
	private Type type;

	/**
	 * AST node for the expression that computes the value of the constant
	 */
	private Expression value;

	/**
	 * Builds an AST node for a constant declaration
	 * 
	 * @param name  : Name of the constant
	 * @param type  : AST node for the type of the constant
	 * @param value : AST node for the expression that computes the value of the
	 *               constant
	 */
	public ConstantDeclaration(String name, Type type, Expression value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Declaration#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/**
	 * Provide the value associated to a name in constant declaration.
	 * 
	 * @return Value from the declaration.
	 */
	public Expression getValue() {
		return this.value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "const " + this.type + " " + this.name + " = " + this.value + ";\n";
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
		if (scope.accepts(this)) {
			boolean res = value.collectAndPartialResolve(scope);
			scope.register(this);
			return res;
		} else {
			Logger.error("[ConstantDeclaration] The constant " + name + " is already declared");
			return false;
		}
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		if (scope.accepts(this)) {
			boolean res = value.collectAndPartialResolve(scope);
			scope.register(this);
			return res;
		} else {
			Logger.error("[ConstantDeclaration] The constant " + name + " is already declared");
			return false;
		}

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
		boolean res = value.completeResolve(scope);
		if (scope.accepts(this)) {
			scope.register(this);
			return res;
		} else {
			Logger.error("[ConstantDeclaration] The constant " + name + " is already declared");
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		if (this.value.getType().compatibleWith(type)) {
			return true;
		}
		Logger.error("[ConstantDeclaration] The constant type is not compatible");
		return false;
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
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		fragment.append(value.getCode(factory));
		return fragment;
	}

}
