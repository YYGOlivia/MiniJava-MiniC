/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;

/**
 * Implementation of the Abstract Syntax Tree node for a couple type.
 * 
 * @author Marc Pantel
 *
 */
public class CoupleType implements Type {

	private Type first;
	private Type second;

	/**
	 * Builds a couple type.
	 * 
	 * @param first  Type of the first part of the couple.
	 * @param second Type of the second part of the couple.
	 */
	public CoupleType(Type first, Type second) {
		this.first = first;
		this.second = second;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.block.ast.Type#equalsTo(fr.n7.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type other) {
		if (other instanceof CoupleType) {
			return this.first.equalsTo(((CoupleType) other).first)
					&& this.second.equalsTo(((CoupleType) other).second);
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.block.ast.Type#compatibleWith(fr.n7.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type other) {
		if (other instanceof CoupleType) {
			return this.first.compatibleWith(((CoupleType) other).first)
					&& this.second.compatibleWith(((CoupleType) other).second);
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.block.ast.Type#merge(fr.n7.block.ast.Type)
	 */
	@Override
	public Type merge(Type other) {
		if (other instanceof CoupleType) {
			return new CoupleType(
					this.first.merge(((CoupleType) other).first),
					this.second.merge(((CoupleType) other).second));
		} else {
			return AtomicType.ErrorType;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#length()
	 */
	@Override
	public int length() {
		return this.first.length() + this.second.length();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "< " + this.first + ", " + this.second + ">";
	}

	/**
	 * Provide the type of the first element in the couple.
	 * 
	 * @return Type of the first element.
	 */
	public Type getFirst() {
		return this.first;
	}

	/**
	 * Provide the type of the second element in the couple.
	 * 
	 * @return Type of the second element.
	 */
	public Type getSecond() {
		return this.second;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean okFirst = this.first.completeResolve(scope);
		boolean okSecond = this.second.completeResolve(scope);
		this.first = NamedType.toBaseType(this.first);
		this.second = NamedType.toBaseType(this.second);
		return okFirst && okSecond;
	}

}
