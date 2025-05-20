/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;

/**
 * Implementation of the Abstract Syntax Tree node for a sequence type.
 * 
 * @author Marc Pantel
 *
 */
public class SequenceType implements Type {

	private List<Type> types;

	public SequenceType() {
		this.types = new LinkedList<Type>();
	}

	public void add(Type type) {
		this.types.add(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type other) {
		if (other instanceof SequenceType) {
			SequenceType local = (SequenceType) other;
			if (this.types.size() == local.types.size()) {
				Iterator<Type> i1 = this.types.iterator();
				Iterator<Type> i2 = local.types.iterator();
				boolean result = true;
				while (i1.hasNext() && i2.hasNext() && result) {
					result = result && (i1.next().equalsTo(i2.next()));
				}
				return result;
			} else {
				return false;
			}
		} else {
			if (other instanceof ArrayType) {
				boolean result = true;
				Type element = ((ArrayType) other).getType();
				Iterator<Type> iter = this.types.iterator();
				while (iter.hasNext() && result) {
					result = result && iter.next().equalsTo(element);
				}
				return result;
			} else {
				if (other instanceof RecordType) {
					return this.equalsTo(((RecordType) other).erase());
				} else {
					if (other instanceof CoupleType) {
						if (this.types.size() == 2) {
							return this.types.get(0).equalsTo(((CoupleType) other).getFirst()) &&
									this.types.get(1).equalsTo(((CoupleType) other).getSecond());
						} else {
							return false;
						}
					} else {
						return false;
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type other) {
		if (other instanceof NamedType) {
			return this.compatibleWith(((NamedType) other).getType());
		} else {
			if (other instanceof SequenceType) {
				SequenceType local = (SequenceType) other;
				if (this.types.size() == local.types.size()) {
					Iterator<Type> i1 = this.types.iterator();
					Iterator<Type> i2 = local.types.iterator();
					boolean result = true;
					while (i1.hasNext() && i2.hasNext() && result) {
						result = result && (i1.next().compatibleWith(i2.next()));
					}
					return result;
				} else {
					return false;
				}
			} else {
				if (other instanceof ArrayType) {
					boolean result = true;
					Type element = ((ArrayType) other).getType();
					Iterator<Type> iter = this.types.iterator();
					while (iter.hasNext() && result) {
						result = result && iter.next().equalsTo(element);
					}
					return result;
				} else {
					if (other instanceof RecordType) {
						return this.compatibleWith(((RecordType) other).erase());
					} else {
						if (other instanceof CoupleType) {
							if (this.types.size() == 2) {
								return this.types.get(0).compatibleWith(((CoupleType) other).getFirst()) &&
										this.types.get(1).compatibleWith(((CoupleType) other).getSecond());
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
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
		if (other instanceof SequenceType) {
			SequenceType local = (SequenceType) other;
			SequenceType result = new SequenceType();
			if (this.types.size() == local.types.size()) {
				Iterator<Type> i1 = this.types.iterator();
				Iterator<Type> i2 = local.types.iterator();
				while (i1.hasNext() && i2.hasNext()) {
					result.add(i1.next().merge(i2.next()));
				}
				return result;
			} else {
				return AtomicType.ErrorType;
			}
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
		int result = 0;
		for (Type type : this.types) {
			result += type.length();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean result = true;
		for (Type t : this.types) {
			result = result && t.completeResolve(scope);
		}
		return result;
	}
}
