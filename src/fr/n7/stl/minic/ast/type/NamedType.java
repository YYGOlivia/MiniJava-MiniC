/**
 *
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.TypeDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a named type.
 *
 * @author Marc Pantel
 *
 */
public class NamedType implements Type {

	private TypeDeclaration declaration;

	public String name;

	public NamedType(String name) {
		this.name = name;
		this.declaration = null;
	}

	public NamedType(TypeDeclaration declaration) {
		this.declaration = declaration;
		this.name = declaration.getName();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type other) {
		if (other instanceof NamedType) {
			return (this.declaration.getName().equals(((NamedType) other).declaration.getName()));
		} else {
			return (this.declaration.getType().equalsTo(other));
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
			NamedType otherNamedType = (NamedType) other;
			return this.getType().compatibleWith(otherNamedType.getType());
		} else {
			return this.getType().compatibleWith(other);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type other) {
		if (other instanceof NamedType) {
			NamedType otherNamedType = (NamedType) other;
			if (this.declaration.getName().equals(otherNamedType.declaration.getName())) {
				return this;
			} else {
				return AtomicType.ErrorType;
			}
		} else {
			return (this.declaration.getType().merge(other));
		}
	}

	/**
	 * Provide the target type of the named type (i.e. type associated to the name).
	 *
	 * @return Type associated to the name.
	 */
	public Type getType() {
		Type result = this.declaration.getType();
		if (result instanceof NamedType) {
			NamedType namedType = (NamedType) result;
			return namedType.getType();
		} else {
			return result;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		return this.declaration.getType().length();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		if (this.declaration == null) {
			if (scope.knows(this.name)) {
				try {
					TypeDeclaration declaration = (TypeDeclaration) scope.get(this.name);
					this.declaration = declaration;
					return true;
				} catch (ClassCastException e) {
					Logger.error("[NamedType] The declaration for " + this.name + " is of the wrong kind.");
					return false;
				}
			} else {
				Logger.error("[NamedType] The identifier " + this.name + " has not been found.");
				return false;
			}
		} else {
			return true;
		}
	}

	/**
	 * Méthode statique pour factoriser la logique de récupération de type sur les
	 * NamedType
	 *
	 * @param expr
	 * @return le "vrai" type de l'expression
	 */
	public static Type getTrueType(Expression expr) {
		Type exprType = expr.getType();
		Type exprTrueType = exprType instanceof NamedType ? ((NamedType) exprType).getType() : exprType;
		return exprTrueType;
	}

	/**
	 * Méthode statique pour factoriser la logique de récupération de type sur les
	 * NamedType
	 *
	 * @param decl
	 * @return le "vrai" type de la déclaration
	 */
	public static Type getTrueType(Declaration decl) {
		Type exprType = decl.getType();
		Type exprTrueType = exprType instanceof NamedType ? ((NamedType) exprType).getType() : exprType;
		return exprTrueType;
	}

	/**
	 * Méthode statique pour récupérer plus efficacement le type de base d'un
	 * NamedType.
	 * 
	 * @param type
	 * @return le type de base
	 */
	public static Type toBaseType(Type type) {
		if (type instanceof NamedType) {
			return ((NamedType) type).getType();
		} else {
			return type;
		}
	}
}
