package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.util.Logger;

public class ClassType implements Type {

	/**
	 * Nom du type de classe.
	 * Il identifie la classe dans le programme.
	 */
	private String name;

	private ClassDeclaration declaration;

	public ClassType(String name) {
		this.name = name;
	}

	public void setDeclaration(ClassDeclaration declaration) {
		this.declaration = declaration;
	}
	
	public ClassDeclaration getDeclaration() {
		return this.declaration;
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
		if (!(other instanceof ClassType)) {
			return false;
		}
		ClassType otherClass = (ClassType) other;
		ClassDeclaration ancestor = this.declaration.getAncestor();
		boolean compatible = this.name.equals(otherClass.name);
		while (ancestor != null && !compatible) {
			compatible = ancestor.getName().equals(otherClass.name);
			ancestor = ancestor.getAncestor();
		}
		return compatible;

	}

	@Override
	public Type merge(Type other) {
		if (this.compatibleWith(other)) {
			return other;
		} else if (other.compatibleWith(this)) {
			return this;
		} else {
			Logger.warning("[ClassType] merge is not quite implemented for ClassType, returning ErrorType.");
			return AtomicType.ErrorType;
		}
	}

	@Override
	public int length() {
		return 1; // size de l'adresse d'un objet
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.knows(name)) {
			Logger.error("[ClassType] " + name + " isn't registered in the scope");
			return false;
		}
		if (declaration == null) {
			this.declaration = (ClassDeclaration) scope.get(name);
		}
		return true;
	}

	public String toString() {
		return this.name;
	}

}
