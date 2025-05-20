/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional
 * instruction.
 * 
 * @author Marc Pantel
 *
 */
public class Conditional implements Instruction {

	protected Expression condition;
	protected Block thenBranch;
	protected Block elseBranch;

	public Conditional(Expression condition, Block thenBlock, Block elseBlock) {
		this.condition = condition;
		this.thenBranch = thenBlock;
		this.elseBranch = elseBlock;
	}

	public Conditional(Expression condition, Block thenBlock) {
		this.condition = condition;
		this.thenBranch = thenBlock;
		this.elseBranch = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch
				+ ((this.elseBranch != null) ? (" else " + this.elseBranch) : "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		SymbolTable thenScope = new SymbolTable(scope);
		SymbolTable elseScope = new SymbolTable(scope);
		boolean okCond = condition.collectAndPartialResolve(scope);
		boolean okThen = thenBranch.collectAndPartialResolve(thenScope);
		boolean okElse = (elseBranch == null) ? true : elseBranch.collectAndPartialResolve(elseScope);
		return okCond && okThen & okElse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		SymbolTable thenScope = new SymbolTable(scope);
		SymbolTable elseScope = new SymbolTable(scope);
		boolean okCond = condition.collectAndPartialResolve(scope);
		boolean okThen = thenBranch.collectAndPartialResolve(thenScope, container);
		boolean okElse = (elseBranch == null) ? true : elseBranch.collectAndPartialResolve(elseScope, container);
		return okCond && okThen & okElse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope
	 * .Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		SymbolTable thenScope = new SymbolTable(scope);
		SymbolTable elseScope = new SymbolTable(scope);
		boolean okCond = condition.completeResolve(scope);
		boolean okThen = thenBranch.completeResolve(thenScope);
		boolean okElse = (elseBranch == null) ? true : elseBranch.completeResolve(elseScope);
		return okCond && okThen & okElse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean ok1 = thenBranch.checkType();
		Type okCond = condition.getType();
		if (okCond.equals(AtomicType.BooleanType)) {
			if (elseBranch != null) {
				boolean ok2 = elseBranch.checkType();
				return ok1 && ok2;
			}
			return ok1;
		}
		Logger.error("[Conditional] Condition is of type " + condition.getType()
				+ "(exepected BooleanType)");
		return false;
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
		thenBranch.allocateMemory(register, offset);
		if (elseBranch != null) {
			elseBranch.allocateMemory(register, offset);
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		int num = factory.createLabelNumber();

		Fragment fragment = factory.createFragment();
		fragment.append(condition.getCode(factory));
		if (elseBranch != null) {
			// si la condition est fausse on jump au sinon
			fragment.add(factory.createJumpIf("sinon_conditionnelle_" + num, 0));
		} else {
			// si pas de else, on saute à la fin
			fragment.add(factory.createJumpIf("fin_conditionnelle_" + num, 0));
		}
		fragment.append(thenBranch.getCode(factory));
		if (elseBranch != null) {
			fragment.add(factory.createJump("fin_conditionnelle_" + num));
			Fragment elseCode = elseBranch.getCode(factory);
			elseCode.addPrefix("sinon_conditionnelle_" + num);
			fragment.append(elseCode);

		}
		fragment.addSuffix("fin_conditionnelle_" + num);
		// fragment.addComment(toString());
		return fragment;
	}

}
