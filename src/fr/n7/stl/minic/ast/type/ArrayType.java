/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;

/**
 * @author Marc Pantel
 *
 */
public class ArrayType implements Type {

	private Type element;

	public ArrayType(Type element) {
		this.element = element;
	}

	public Type getElement() {
		return this.element;
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
		if (other instanceof ArrayType) {
			return this.element.equalsTo(((ArrayType) other).element);
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type other) {
		if (other instanceof ArrayType) {
			return this.element.compatibleWith(((ArrayType) other).element);
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type other) {
		if (other instanceof ArrayType) {
			return new ArrayType(this.element.merge(((ArrayType) other).element));
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
		return "(" + this.element + " [])";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean okElement = this.element.completeResolve(scope);
		if (element instanceof NamedType) {
			NamedType namedType = (NamedType) element;
			this.element = namedType.getType();
		}
		return okElement;
	}

	/**
	 * @return Type of the elements in the array.
	 */
	public Type getType() {
		return this.element;
	}

}
