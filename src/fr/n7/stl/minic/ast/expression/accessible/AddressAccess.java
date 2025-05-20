/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.assignable.ArrayAssignment;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.expression.assignable.VariableAssignment;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.PointerType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.lang.reflect.Array;

/**
 * Implementation of the Abstract Syntax Tree node for accessing an expression
 * address.
 * 
 * @author Marc Pantel
 *
 */
public class AddressAccess implements AccessibleExpression {

	protected AssignableExpression assignable;

	public AddressAccess(AssignableExpression assignable) {
		this.assignable = assignable;
	}

	@Override
	public String toString() {
		return "& " + this.assignable.toString();
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
		return assignable.collectAndPartialResolve(scope);
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
		boolean okAssign = assignable.completeResolve(scope);
		if (assignable instanceof VariableAssignment){
			return okAssign;
		}else if (assignable instanceof ArrayAssignment){
			return okAssign;
		}else{
			Logger.error("[AddressAccess] " + assignable.toString() + " should be a VariableAssignement");
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return new PointerType(assignable.getType());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();

		if (assignable instanceof VariableAssignment){
			VariableAssignment elem = (VariableAssignment) assignable;
			VariableDeclaration declaration  = (VariableDeclaration) elem.getDeclaration();
			fragment.add(factory.createLoadA(declaration.getRegister(), declaration.getOffset()));
		}else if (assignable instanceof ArrayAssignment){
			ArrayAssignment array = (ArrayAssignment) assignable;
			fragment.append(array.getAccessCode(factory));
		}
		return fragment;
	}

}
