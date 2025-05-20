package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.RecordType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a type declaration.
 * 
 * @author Marc Pantel
 *
 */
public class TypeDeclaration implements Declaration, Instruction {

	/**
	 * Name of the declared type
	 */
	private String name;

	/**
	 * AST node for the type associated to the name
	 */
	private Type type;

	/**
	 * Builds an AST node for a type declaration
	 * 
	 * @param name : Name of the declared type
	 * @param type : AST node for the type associated to the name
	 */
	public TypeDeclaration(String name, Type type) {
		this.name = name;
		this.type = type;
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
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (scope.accepts(this)) {
			scope.register(this);
			return type.completeResolve(scope);
		} else {
			Logger.error("[TypeDeclaration] The type " + name + " is already declared.");
			return false;
		}
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		if (scope.accepts(this)) {
			scope.register(this);
			return type.completeResolve(scope);
		} else {
			Logger.error("[TypeDeclaration] The type " + name + " is already declared.");
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
		if (scope.accepts(this)) {
			scope.register(this);
			return type.completeResolve(scope);
		} else {
			Logger.error("[TypeDeclaration] The type " + name + " is already declared.");
			return false;
		}
	}

	/**
	 * Provide the type associated to a name in a type declaration.
	 * 
	 * @return Type from the declaration.
	 */
	public Type getType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "typedef " + this.type + " " + this.name + ";\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
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
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		return factory.createFragment();
	}

}
