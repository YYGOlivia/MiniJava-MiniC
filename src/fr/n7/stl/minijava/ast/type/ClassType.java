package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ClassType implements Type {

	private String name;

	public ClassType(String name) {
		this.name = name;
	}

	@Override
	public boolean equalsTo(Type other) {
		if (!(other instanceof ClassType)) {
			return false;
		}
		ClassType otherClass = (ClassType) other;
		return this.name.equals(otherClass.name);
	}

	@Override
	public boolean compatibleWith(Type other) {
		// faut gérer l'héritage
		throw new SemanticsUndefinedException("Semantics merge is undefined in ClassType.");

	}

	@Override
	public Type merge(Type other) {
		if (this.compatibleWith(other)) {
			return other;
		} else if (other.compatibleWith(this)) {
			return this;
		} else {
			return AtomicType.ErrorType;
		}
	}

	@Override
	public int length() {
		throw new SemanticsUndefinedException("Semantics length is undefined in ClassType.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in ClassType.");
	}

	public String toString() {
		return this.name;
	}

}
