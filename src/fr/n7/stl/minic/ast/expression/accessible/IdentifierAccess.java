/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractAccess;
import fr.n7.stl.minic.ast.expression.AbstractIdentifier;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for an identifier access
 * expression (can be a variable,
 * a parameter, a constant, a function, ...).
 * Will be connected to an appropriate object after resolving the identifier to
 * know to which kind of element
 * it is associated (variable, parameter, constant, function, ...).
 * 
 * @author Marc Pantel
 *         TODO : Should also hold a function and not only a variable.
 */
public class IdentifierAccess extends AbstractIdentifier implements AccessibleExpression {

	private AbstractAccess expression;

	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * 
	 * @param name Name of the used variable.
	 */
	public IdentifierAccess(String name) {
		super(name);
	}

	public AbstractAccess getExpression() {
		return this.expression;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.knows(this.getName())) {
			Logger.error("[IdentifierAccess] " + this.getName() + " is not known by scope.");
			return false;
		}

		Declaration declaration = scope.get(this.getName());
		if (declaration instanceof VariableDeclaration) {
			this.expression = new VariableAccess((VariableDeclaration) declaration);

		} else if (declaration instanceof ConstantDeclaration) {
			this.expression = new ConstantAccess((ConstantDeclaration) declaration);

		} else if (declaration instanceof ParameterDeclaration) {
			this.expression = new ParameterAccess((ParameterDeclaration) declaration);

		} else {
			Logger.error("[IdentifierAccess] Declaration of " + this.getName()
					+ " refers to neither variable, constant or parameter.");
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {

		if (!scope.knows(this.getName())) {
			Logger.error("[IdentifierAccess] " + this.getName() + " is not known by scope.");
			return false;
		}

		Declaration declaration = scope.get(this.getName());
		if (declaration instanceof VariableDeclaration) {
			this.expression = new VariableAccess((VariableDeclaration) declaration);

		} else if (declaration instanceof ConstantDeclaration) {
			this.expression = new ConstantAccess((ConstantDeclaration) declaration);

		} else if (declaration instanceof ParameterDeclaration) {
			this.expression = new ParameterAccess((ParameterDeclaration) declaration);

		} else {
			Logger.error("[IdentifierAccess] Declaration of " + this.getName()
					+ " refers to neither variable, constant or parameter.");
			return false;
		}
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return this.expression.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		return this.expression.getCode(factory);
	}

}
