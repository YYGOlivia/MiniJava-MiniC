/**
 * 
 */
package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.util.Iterator;
import java.util.List;

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
	 * @param _name      : Name of the called function.
	 * @param _arguments : List of AST nodes that computes the values of the
	 *                   parameters for the function call.
	 */
	public FunctionCall(String _name, List<AccessibleExpression> _arguments) {
		this.name = _name;
		this.function = null;
		this.arguments = _arguments;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = ((this.function == null) ? this.name : this.function) + "( ";
		Iterator<AccessibleExpression> _iter = this.arguments.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
		}
		while (_iter.hasNext()) {
			_result += " ," + _iter.next();
		}
		return _result + ")";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		if (this.function == null) {
			Declaration varDec = _scope.get(name);
			if (varDec instanceof FunctionDeclaration) {
				FunctionDeclaration funcDec = ((FunctionDeclaration) varDec);
				this.function = funcDec;
			} else {
				Logger.error("The variable " + name + " is not a function");
				return false;
			}
		}

		boolean ok = true;
		for (AccessibleExpression arg : arguments) {
			ok = ok && arg.collectAndPartialResolve(_scope);
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
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {

		List<ParameterDeclaration> funcParams = function.getParameters();
		boolean argLenOk = arguments.size() == funcParams.size();
		if (!argLenOk) {
			Logger.error("Wrong number of arguments for " + name +
					" (expected " + funcParams.size() +
					" got " + arguments.size() + ")");
			return false;
		}

		boolean ok = true;
		for (AccessibleExpression arg : arguments) {
			ok = ok && arg.completeResolve(_scope);
		}
		for (int i = 0; i < arguments.size(); i++) {
			Type funcParamType = funcParams.get(i).getType();
			Type argType = arguments.get(i).getType();
			ok = ok && argType.compatibleWith(funcParamType);
		}
		if (!ok) {
			List<String> funcParamString = funcParams.stream().map(x -> x.getType().toString()).toList();
			List<String> argString = arguments.stream().map(x -> x.getType().toString()).toList();
			Logger.error("Wrong type of arguments for " + name +
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
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in FunctionCall.");
	}

}
