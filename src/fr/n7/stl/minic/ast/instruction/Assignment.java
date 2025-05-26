/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.expression.assignable.FieldAssignment;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.NamedType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for an array type.
 * 
 * @author Marc Pantel
 *
 */
public class Assignment implements Instruction, Expression {

	private Expression value;
	private AssignableExpression assignable;

	/**
	 * Create an assignment instruction implementation from the assignable
	 * expression
	 * and the assigned value.
	 * 
	 * @param assignable Expression that can be assigned a value.
	 * @param value      Value assigned to the expression.
	 */
	public Assignment(AssignableExpression assignable, Expression value) {
		this.assignable = assignable;
		this.value = value;
		/*
		 * This attribute will be assigned to the appropriate value by the resolve
		 * action
		 */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.assignable + " = " + this.value.toString() + ";\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean valueOK = value.collectAndPartialResolve(scope);
		boolean assignableOK = assignable.collectAndPartialResolve(scope);
		return valueOK && assignableOK;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		boolean valueOK = value.collectAndPartialResolve(scope);
		boolean assignableOK = assignable.collectAndPartialResolve(scope);
		return valueOK && assignableOK;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope
	 * .HierarchicalScope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean valueOK = value.completeResolve(scope);
		boolean assignableOK = assignable.completeResolve(scope);
		return valueOK && assignableOK;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.expression.Expression#getType()
	 */
	@Override
	public Type getType() {
		return this.assignable.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		Type valueTrueType = NamedType.getTrueType(value);
		Type assTrueType = NamedType.getTrueType(assignable);
		if (!valueTrueType.compatibleWith(assTrueType)) {
			Logger.error(
					"[Assignment] Type mismatch: cannot assign " + value.getType() + " to " + assignable.getType());
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register,
	 * int)
	 */
	@Override
	public int allocateMemory(Register register, int offset) {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		fragment.append(value.getCode(factory));
		fragment.append(assignable.getCode(factory));
		if (assignable instanceof FieldAssignment){
			fragment.add(factory.createStoreI(value.getType().length()));
		}
		//fragment.addComment(toString());
		return fragment;
	}

}
