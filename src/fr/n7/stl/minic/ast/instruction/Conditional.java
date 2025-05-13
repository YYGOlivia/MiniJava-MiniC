/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.SemanticsUndefinedException;
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

	public Conditional(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = _else;
	}

	public Conditional(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
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
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		SymbolTable thenScope = new SymbolTable(_scope);
		SymbolTable elseScope = new SymbolTable(_scope);
		boolean okCond = condition.collectAndPartialResolve(_scope);
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
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		SymbolTable thenScope = new SymbolTable(_scope);
		SymbolTable elseScope = new SymbolTable(_scope);
		boolean okCond = condition.collectAndPartialResolve(_scope);
		boolean okThen = thenBranch.collectAndPartialResolve(thenScope, _container);
		boolean okElse = (elseBranch == null) ? true : elseBranch.collectAndPartialResolve(elseScope, _container);
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
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		SymbolTable thenScope = new SymbolTable(_scope);
		SymbolTable elseScope = new SymbolTable(_scope);
		boolean okCond = condition.completeResolve(_scope);
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
		Logger.error("[Conditional] Condition not of Boolean type");
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
	public int allocateMemory(Register _register, int _offset) {
		throw new SemanticsUndefinedException("Semantics allocateMemory is undefined in Conditional.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		int num = _factory.createLabelNumber();

		Fragment _fragment = _factory.createFragment();
		_fragment.append(condition.getCode(_factory));
		_fragment.add(_factory.createJumpIf("sinon_conditionnelle" + num, 0));

		_fragment.append(thenBranch.getCode(_factory));
		_fragment.add(_factory.createJump("fin_conditionnelle" + num));

		Fragment elseCode = elseBranch.getCode(_factory);
		elseCode.addPrefix("sinon_conditionnelle" + num);
		_fragment.append(elseCode);
		_fragment.addSuffix("fin_conditionnelle" + num);
		return _fragment;
	}

}
