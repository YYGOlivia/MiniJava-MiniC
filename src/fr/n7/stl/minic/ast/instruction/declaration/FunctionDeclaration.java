/**
 * 
 */
package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract Syntax Tree node for a function declaration.
 * 
 * @author Marc Pantel
 */
public class FunctionDeclaration implements Instruction, Declaration {

	/**
	 * Name of the function
	 */
	private String name;

	/**
	 * AST node for the returned type of the function
	 */
	private Type type;

	/**
	 * List of AST nodes for the formal parameters of the function
	 */
	private List<ParameterDeclaration> parameters;

	/**
	 * @return the parameters
	 */
	public List<ParameterDeclaration> getParameters() {
		return parameters;
	}

	/**
	 * AST node for the body of the function
	 */
	private Block body;

	/**
	 * Builds an AST node for a function declaration
	 * 
	 * @param name       : Name of the function
	 * @param type       : AST node for the returned type of the function
	 * @param parameters : List of AST nodes for the formal parameters of the
	 *                    function
	 * @param body       : AST node for the body of the function
	 */
	public FunctionDeclaration(String name, Type type, List<ParameterDeclaration> parameters, Block body) {
		this.name = name;
		this.type = type;
		this.parameters = parameters;
		this.body = body;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = this.type + " " + this.name + "(";
		Iterator<ParameterDeclaration> iter = this.parameters.iterator();
		if (iter.hasNext()) {
			result += iter.next();
			while (iter.hasNext()) {
				result += " ," + iter.next();
			}
		}
		return result + ")" + this.body;
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
			Logger.error("[FunctionDeclaration] The function " + name + " is already declared");
			return false;
		}
		scope.register(this);
		SymbolTable functionScope = new SymbolTable(scope);
		for (ParameterDeclaration paramDecl : this.parameters) {
			if (!functionScope.accepts(paramDecl)) {
				Logger.error("[FunctionDeclaration] The parameter " + paramDecl.getName()
						+ " is already declared in the function " + name);
				return false;
			}
			functionScope.register(paramDecl);
		}
		boolean okBody = body.collectAndPartialResolve(functionScope, this);
		boolean okType = type.completeResolve(scope);
		return okBody && okType;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		if (!scope.accepts(this)) {
			Logger.error("[FunctionDeclaration] The function " + name + " is already declared");
			return false;
		}
		scope.register(this);
		SymbolTable functionScope = new SymbolTable(scope);
		for (ParameterDeclaration paramDecl : this.parameters) {
			if (!functionScope.accepts(paramDecl)) {
				Logger.error("[FunctionDeclaration] The parameter " + paramDecl.getName()
						+ " is already declared in the function " + name);
				return false;
			}
			functionScope.register(paramDecl);
		}
		boolean okBody = body.collectAndPartialResolve(functionScope, this);
		boolean okType = type.completeResolve(scope);
		return okBody && okType;
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
		scope.register(this);
		SymbolTable functionScope = new SymbolTable(scope);
		boolean okParams = true;
		for (ParameterDeclaration paramDecl : this.parameters) {
			okParams = okParams && paramDecl.getType().completeResolve(scope);
			if (!functionScope.accepts(paramDecl)) {
				Logger.error("[FunctionDeclaration] The parameter " + paramDecl.getName()
						+ " is already declared in the function " + name);
				return false;
			}
			functionScope.register(paramDecl);
		}
		boolean okBody = body.completeResolve(functionScope);
		boolean okType = type.completeResolve(scope);
		return okParams && okBody && okType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.instruction.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return body.checkType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#allocateMemory(fr.n7.stl.tam.ast.
	 * Register, int)
	 */
	@Override
	public int allocateMemory(Register register, int offset) {
		int off = 0;
		for (ParameterDeclaration paramDecl : this.parameters) {
			off -= paramDecl.getType().length(); //ATENTION possible pb pour this -> size=1 car adresse mais peut être ClassType.length !=1
			paramDecl.setOffset(off);
		}
		body.allocateMemory(Register.LB, 0);
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.instruction.Instruction#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		
		fragment.append(body.getCode(factory));
		fragment.addPrefix(name);
		// fragment.addComment(toString());
		return fragment;
	}

}
