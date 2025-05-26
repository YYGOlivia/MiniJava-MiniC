package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ClassType implements Type {

	protected String name;

	public ClassType(String name) {
		this.name = name;
	}

	@Override
	public boolean equalsTo(Type other) {
		throw new SemanticsUndefinedException("Semantics equalsTo is undefined in ClassType.");
	}

	@Override
	public boolean compatibleWith(Type other) {
		throw new SemanticsUndefinedException("Semantics compatibleWith is undefined in ClassType.");
	}

	@Override
	public Type merge(Type other) {
		throw new SemanticsUndefinedException("Semantics merge is undefined in ClassType.");
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
		return " " + this.name + " ";
	}

}
