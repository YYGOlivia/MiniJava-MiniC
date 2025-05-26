package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;

public class ClassType implements Type {

	protected String name;

	public ClassType(String name) {
		this.name = name;
	}

	@Override
	public boolean equalsTo(Type other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean compatibleWith(Type other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type merge(Type other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		return false;
	}

	public String toString() {
		return " " + this.name + " ";
	}

}
