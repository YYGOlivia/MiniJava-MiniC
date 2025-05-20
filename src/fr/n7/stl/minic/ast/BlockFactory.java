/**
 * 
 */
package fr.n7.stl.minic.ast;

import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.accessible.ArrayAccess;
import fr.n7.stl.minic.ast.expression.accessible.BinaryExpression;
import fr.n7.stl.minic.ast.expression.accessible.BinaryOperator;
import fr.n7.stl.minic.ast.expression.accessible.IdentifierAccess;
import fr.n7.stl.minic.ast.expression.accessible.PointerAccess;
import fr.n7.stl.minic.ast.expression.accessible.UnaryExpression;
import fr.n7.stl.minic.ast.expression.accessible.UnaryOperator;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.expression.value.BooleanValue;
import fr.n7.stl.minic.ast.expression.value.IntegerValue;
import fr.n7.stl.minic.ast.expression.value.NullValue;
import fr.n7.stl.minic.ast.instruction.Assignment;
import fr.n7.stl.minic.ast.instruction.Conditional;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.Iteration;
import fr.n7.stl.minic.ast.instruction.Printer;

/**
 * @author Marc Pantel
 *
 */
public class BlockFactory {

	/**
	 * 
	 */
	public BlockFactory() {
		// TODO Auto-generated constructor stub
	}

	public Block createBlock(List<Instruction> instructions) {
		return new Block(instructions);
	}

	public Instruction createAssignment(AssignableExpression target, AccessibleExpression value) {
		return new Assignment(target, value);
	}

	public Instruction createConditional(AccessibleExpression condition, Block thenBlock) {
		return new Conditional(condition, thenBlock);
	}

	public Instruction createConditional(AccessibleExpression condition, Block thenBlock, Block elseBlock) {
		return new Conditional(condition, thenBlock, elseBlock);
	}

	public Instruction createIteration(AccessibleExpression condition, Block body) {
		return new Iteration(condition, body);
	}

	public Instruction createPrinter(AccessibleExpression value) {
		return new Printer(value);
	}

	public AccessibleExpression createTrueValue() {
		return BooleanValue.True;
	}

	public AccessibleExpression createFalseValue() {
		return BooleanValue.False;
	}

	public AccessibleExpression createNullValue() {
		return NullValue.Null;
	}

	public AccessibleExpression createIntegerValue(String value) {
		return new IntegerValue(value);
	}

	public AccessibleExpression createUnaryExpression(UnaryOperator operator, AccessibleExpression parameter) {
		return new UnaryExpression(operator, parameter);
	}

	public AccessibleExpression createBinaryExpression(AccessibleExpression left, BinaryOperator operator,
			AccessibleExpression right) {
		return new BinaryExpression(left, operator, right);
	}

	public AccessibleExpression createIdentifierAccess(String name) {
		return new IdentifierAccess(name);
	}

	public AccessibleExpression createArrayAccess(AccessibleExpression array, AccessibleExpression index) {
		return new ArrayAccess(array, index);
	}

	public AccessibleExpression createPointerAccess(AccessibleExpression pointer) {
		return new PointerAccess(pointer);
	}
}
