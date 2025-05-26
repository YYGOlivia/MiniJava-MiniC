/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * 
 * @author Marc Pantel
 *
 */
public class PointerType implements Type {

	private Type element;

	public PointerType(Type element) {
		this.element = element;
	}

	public Type getElement() {
		Type elementTrueType = NamedType.toBaseType(this.element);
		return elementTrueType;
	}

	public void setElement(Type element) {
		this.element = element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type other) {
		if (other instanceof PointerType) {
			PointerType otherPointerType = (PointerType) other;
			return element.equals(otherPointerType.getElement());
		}
		Logger.error("[PointerType] " + other.toString() + " is not a PointerType");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type other) {
		if (other instanceof PointerType) {
			PointerType otherPointerType = (PointerType) other;
			return element.compatibleWith(otherPointerType.getElement());
		}
		Logger.error("[PointerType] " + other.toString() + " is not a PointerType");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type other) {
		if (other instanceof PointerType) {
			return new PointerType(this.element.merge(((PointerType) other).element));
		} else {
			return AtomicType.ErrorType;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.element + " *)";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		return this.element.completeResolve(scope);
	}

}
