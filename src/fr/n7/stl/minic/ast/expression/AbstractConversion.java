/**
 * 
 */
package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.declaration.TypeDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractConversion<TargetType> implements Expression {

	private TargetType target;
	private Type type;
	private String name;

	public AbstractConversion(TargetType target, String type) {
		this.target = target;
		this.name = type;
		this.type = null;
	}

	public AbstractConversion(TargetType target, Type type) {
		this.target = target;
		this.name = null;
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (this.type == null) {
			return "(" + this.name + ") " + this.target;
		} else {
			return "(" + this.type + ") " + this.target;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {

		Declaration decl = scope.get(this.name);
		if (!(decl instanceof TypeDeclaration)) {
			Logger.error("[AbstractConversion] Type " + this.name + " is not declared.");
			return false;
		}
		TypeDeclaration typeDecl = ((TypeDeclaration) decl);

		typeDecl.collectAndPartialResolve(scope);
		this.type = typeDecl.getType();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		if (this.target instanceof AccessibleExpression) {
			AccessibleExpression targetAcc = (AccessibleExpression) target;
			boolean okTarget = targetAcc.completeResolve(scope);
			if (!type.compatibleWith(targetAcc.getType())) {
				Logger.error("[AbstractConversion] " + type + " is not compatible with " + targetAcc.getType());
				return false;
			}
			return okTarget;
		} else if (this.target instanceof Expression) {
			Expression targetExp = (Expression) target;
			boolean okTarget = targetExp.completeResolve(scope);
			if (!type.compatibleWith(targetExp.getType())) {
				Logger.error("[AbstractConversion] " + type + " is not compatible with " + targetExp.getType());
				return false;
			}
			return okTarget;
		}
		Logger.error("[AbstractConversion] " + target + " is not an Expression or an AccessibleExpression");
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode undefined in TypeConversion.");
	}

}
