/**
 * 
 */
package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract Syntax Tree node for a function call expression.
 * 
 * @author Marc Pantel
 *
 */
public class FunctionCall implements AccessibleExpression {

	/**
	 * Name of the called function.
	 * TODO : Should be an expression.
	 */
	protected String name;

	/**
	 * Declaration of the called function after name resolution.
	 * TODO : Should rely on the VariableUse class.
	 */
	protected FunctionDeclaration function;

	/**
	 * List of AST nodes that computes the values of the parameters for the function
	 * call.
	 */
	protected List<AccessibleExpression> arguments;

	/**
	 * @param name      : Name of the called function.
	 * @param arguments : List of AST nodes that computes the values of the
	 *                   parameters for the function call.
	 */
	public FunctionCall(String name, List<AccessibleExpression> arguments) {
		this.name = name;
		this.function = null;
		this.arguments = arguments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = ((this.function == null) ? this.name : this.function) + "( ";
		Iterator<AccessibleExpression> iter = this.arguments.iterator();
		if (iter.hasNext()) {
			result += iter.next();
		}
		while (iter.hasNext()) {
			result += " ," + iter.next();
		}
		return result + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (this.function == null) {
			Declaration varDec = scope.get(name);
			if (varDec instanceof FunctionDeclaration) {
				FunctionDeclaration funcDec = ((FunctionDeclaration) varDec);
				this.function = funcDec;
			} else {
				Logger.error("[FunctionCall] The variable " + name + " is not a function");
				return false;
			}
		}

		boolean ok = true;
		for (AccessibleExpression arg : arguments) {
			ok = ok && arg.collectAndPartialResolve(scope);
		}
		return ok && (function != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {

		List<ParameterDeclaration> funcParams = function.getParameters();
		boolean argLenOk = arguments.size() == funcParams.size();
		if (!argLenOk) {
			Logger.error("[FunctionCall] Wrong number of arguments for " + name +
					" (expected " + funcParams.size() +
					" got " + arguments.size() + ")");
			return false;
		}

		boolean ok = true;
		for (AccessibleExpression arg : arguments) {
			ok = ok && arg.completeResolve(scope);
		}
		for (int i = 0; i < arguments.size(); i++) {
			Type funcParamType = funcParams.get(i).getType();
			Type argType = arguments.get(i).getType();
			ok = ok && argType.compatibleWith(funcParamType);
		}
		if (!ok) {
			List<String> funcParamString = funcParams.stream().map(x -> x.getType().toString()).collect(Collectors.toList());
			List<String> argString = arguments.stream().map(x -> x.getType().toString()).collect(Collectors.toList());
			Logger.error("[FunctionCall] Wrong type of arguments for " + name +
					" (expected " + funcParamString +
					" got " + argString + ")");
			return false;
		}

		return ok && (function != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return function.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		//fragment.addComment(toString());
		// charge chaque argument
		for (AccessibleExpression arg : arguments) {
			fragment.append(arg.getCode(factory));
		}
		// CALL (SB) name
		fragment.add(factory.createCall(name, Register.SB));
		return fragment;
	}

}
