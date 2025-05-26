package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.ArrayType;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.NamedType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.Logger;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractArray<ArrayKind extends Expression> implements Expression {

	/**
	 * AST node that represents the expression whose result is an array.
	 */
	private ArrayKind array;

	/**
	 * AST node that represents the expression whose result is an integer value used
	 * to index the array.
	 */
	private AccessibleExpression index;

	/**
	 * Construction for the implementation of an array element access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param array Abstract Syntax Tree for the array part in an array element
	 *               access expression.
	 * @param index Abstract Syntax Tree for the index part in an array element
	 *               access expression.
	 */
	public AbstractArray(ArrayKind array, AccessibleExpression index) {
		this.array = array;
		this.index = index;
	}

	public ArrayKind getArray() {
		return this.array;
	}

	public AccessibleExpression getIndex() {
		return this.index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (this.array + "[ " + this.index + " ]");
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
		boolean okArray = this.array.collectAndPartialResolve(scope);
		boolean okIndex = this.index.collectAndPartialResolve(scope);

		Type arrayTrueType =  NamedType.getTrueType(array);

		if (!(arrayTrueType instanceof ArrayType)) {
			Logger.error("[AbstractArray] " + array + " should be array type (is " + array.getType() + ").");
			return false;
		}
		return okArray && okIndex;
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
		boolean okArray = this.array.completeResolve(scope);
		boolean okIndex = this.index.completeResolve(scope);
		Type arrayTrueType = NamedType.getTrueType(array);

		if (!(arrayTrueType instanceof ArrayType)) {
			Logger.error("[AbstractArray] " + array + " should be array type (is " + array.getType() + ").");
			return false;
		}
		return okArray && okIndex;
	}

	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	public Type getType() {
		Type arrayTrueType = NamedType.getTrueType(array);
		if (!(arrayTrueType instanceof ArrayType)) {
			return AtomicType.ErrorType;
		}
		return ((ArrayType) arrayTrueType).getType();
	}

}