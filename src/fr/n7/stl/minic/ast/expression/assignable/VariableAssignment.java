/**
 * 
 */
package fr.n7.stl.minic.ast.expression.assignable;

import fr.n7.stl.minic.ast.expression.AbstractIdentifier;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Abstract Syntax Tree node for an expression whose computation assigns a
 * variable.
 * 
 * @author Marc Pantel
 *
 */
public class VariableAssignment extends AbstractIdentifier implements AssignableExpression {

	private VariableDeclaration declaration;

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 * 
	 * @param name Name of the assigned variable.
	 */
	public VariableAssignment(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.AbstractIdentifier#collect(fr.n7.stl.block.ast
	 * .scope.HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (((HierarchicalScope<Declaration>) scope).knows(this.getName())) {
			Declaration declaration = scope.get(this.getName());
			if (declaration instanceof VariableDeclaration) {
				this.declaration = ((VariableDeclaration) declaration);
				return true;
			} else if (declaration instanceof ParameterDeclaration) {
				Logger.error("[VariableAssignement] The parameter " + this.getName() + " is is not assignable.");
				return false;
			} else {
				Logger.error("[VariableAssignement] The declaration for " + this.getName() + " is of the wrong kind.");
				return false;
			}
		} else {
			Logger.error("[VariableAssignement] The identifier " + this.getName() + " has not been found.");
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.AbstractIdentifier#resolve(fr.n7.stl.block.ast
	 * .scope.HierarchicalScope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getType()
	 */
	@Override
	public Type getType() {
		return this.declaration.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getCode(fr.n7.stl.tam.ast.
	 * TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment result = factory.createFragment();
		int off = declaration.getOffset();
		Register reg = declaration.getRegister();
		int size = getType().length();
		result.add(factory.createStore(reg, off, size));
		return result;
	}

	public Fragment getAccessCode(TAMFactory factory) {
		Fragment result = factory.createFragment();
		int off = declaration.getOffset();
		Register reg = declaration.getRegister();
		int size = getType().length();
		result.add(factory.createStore(reg, off, size));
		return result;
	}

	public Declaration getDeclaration() {
		return declaration;
	}

}
