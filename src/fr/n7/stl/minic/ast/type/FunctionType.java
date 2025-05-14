/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;

/**
 * Implementation of the Abstract Syntax Tree node for a function type.
 * 
 * @author Marc Pantel
 *
 */
public class FunctionType implements Type {

	private Type result;
	private List<Type> parameters;

	public FunctionType(Type _result, Iterable<Type> _parameters) {
		this.result = _result;
		this.parameters = new LinkedList<Type>();
		for (Type _type : _parameters) {
			this.parameters.add(_type);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (!(_other instanceof FunctionType)) {
			return false;
		}

		FunctionType _function = (FunctionType) _other;
		if (!this.result.equalsTo(_function.result)) {
			return false;
		}
		if (this.parameters.size() != _function.parameters.size()) {
			return false;
		}

		boolean okParamTypes = true;
		for (int i = 0; i < this.parameters.size(); i++) {
			okParamTypes = okParamTypes && this.parameters.get(i).equalsTo(_function.parameters.get(i));
		}
		return okParamTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (!(_other instanceof FunctionType)) {
			return false;
		}
		FunctionType _function = (FunctionType) _other;

		// type retour covariant
		if (!this.result.compatibleWith(_function.result)) {
			return false;
		}

		if (this.parameters.size() != _function.parameters.size()) {
			return false;
		}

		// type paramètres contravariant
		boolean okParamTypes = true;
		for (int i = 0; i < this.parameters.size(); i++) {
			okParamTypes = okParamTypes && _function.parameters.get(i).compatibleWith(this.parameters.get(i));
		}
		return okParamTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		throw new SemanticsUndefinedException("Semantics merge is undefined in FunctionType.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = "(";
		Iterator<Type> _iter = this.parameters.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
			while (_iter.hasNext()) {
				_result += " ," + _iter.next();
			}
		}
		return _result + ") -> " + this.result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		boolean ok = this.result.completeResolve(_scope);
		for (Type _type : this.parameters) {
			ok = ok && _type.completeResolve(_scope);
		}
		return ok;
	}

}
