/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.util.Logger;

/**
 * Elementary types in the Bloc language.
 * 
 * @author Marc Pantel
 *
 */
public enum AtomicType implements Type {
	BooleanType,
	CharacterType,
	FloatingType,
	IntegerType,
	StringType,
	VoidType,
	NullType,
	ErrorType;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type other) {
		return this == other;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type other) {
		if (this.equalsTo(other)) {
			return true;
		} else {
			switch (this) {
				case NullType:
					return ((other != ErrorType) && (other != VoidType));
				case IntegerType:
					return (other == FloatingType) || (other instanceof EnumerationType);
				default:
					return false;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type other) {
		if (this.compatibleWith(other)) {
			return other;
		} else {
			if (other.compatibleWith(this)) {
				return this;
			} else {
				return ErrorType;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#length()
	 */
	@Override
	public int length() {
		switch (this) {
			case NullType:
			case BooleanType:
			case CharacterType:
			case FloatingType:
			case IntegerType:
			case StringType:
				return 1;
			case VoidType:
				return 0;
			default:
				throw new IllegalArgumentException("Must not call length on the Error type.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		switch (this) {
			case BooleanType:
				return "boolean";
			case CharacterType:
				return "char";
			case ErrorType:
				return "error";
			case FloatingType:
				return "float";
			case IntegerType:
				return "int";
			case StringType:
				return "String";
			case VoidType:
				return "void";
			case NullType:
				return "unit";
			default:
				throw new IllegalArgumentException("The default case should never be triggered.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		return true;
	}

}
