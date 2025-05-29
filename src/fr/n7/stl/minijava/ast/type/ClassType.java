package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ClassType implements Type {

	private String name;

	private ClassDeclaration declaration;

	

	public ClassType(String name) {
		this.name = name;
	}
	
	public void setDeclaration(ClassDeclaration declaration){
		this.declaration = declaration;
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
		if (!(other instanceof ClassType)){
			Logger.error("[ClassType] " + other.toString() +" is not a class");
		}
		ClassType otherClass = (ClassType) other;
		ClassDeclaration ancestor = this.declaration.getAncestor();
		boolean compatible = this.name.equals(otherClass.name);
		while (ancestor!= null && !compatible){
			compatible = ancestor.getName().equals(otherClass.name);
			ancestor = ancestor.getAncestor();
		}
		return compatible;
		//throw new SemanticsUndefinedException("Semantics merge is undefined in ClassType.");
		  

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
		if (!scope.knows(name)){
			Logger.error("[ClassType] " + name + " isn't registered in the scope");
			return false;
		}
		if (declaration == null){
			this.declaration = (ClassDeclaration) scope.get(name);
		}
		return true;
		//throw new SemanticsUndefinedException("Semantics resolve is undefined in ClassType.");
	}

	public String toString() {
		return this.name;
	}

}
