package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.NamedType;
import fr.n7.stl.minic.ast.type.PointerType;
import fr.n7.stl.minic.ast.type.Type;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractPointer<PointerKind extends Expression> implements Expression {

	/**
	 * AST node that represents an expression whose value is a pointer.
	 */
	protected PointerKind pointer;

	/**
	 * Construction for the implementation of a pointer content access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param pointer Abstract Syntax Tree for the pointer expression in a pointer
	 *                 content access expression.
	 */
	public AbstractPointer(PointerKind pointer) {
		this.pointer = pointer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(*" + this.pointer + ")";
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
		return pointer.collectAndPartialResolve(scope);
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
		return pointer.completeResolve(scope);
	}

	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	@Override
	public Type getType() {
		Type ptrTrueType = NamedType.getTrueType(pointer);
		if (!(ptrTrueType instanceof PointerType)) {
			return AtomicType.ErrorType;
		}
		PointerType ptrType = ((PointerType) ptrTrueType);
		return ptrType.getPointedType();
	}

}