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
public class Iteration implements Instruction {

	protected Expression condition;
	protected Block body;

	public Iteration(Expression _condition, Block _body) {
		this.condition = _condition;
		this.body = _body;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "while (" + this.condition + " )" + this.body;
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
		SymbolTable bodyScope = new SymbolTable(_scope);
		boolean okCond = condition.collectAndPartialResolve(_scope);
		boolean okBody = body.collectAndPartialResolve(bodyScope);
		return okCond && okBody;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		SymbolTable bodyScope = new SymbolTable(_scope);
		boolean okCond = condition.collectAndPartialResolve(_scope);
		boolean okBody = body.collectAndPartialResolve(bodyScope, _container);
		return okCond && okBody;
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
		SymbolTable bodyScope = new SymbolTable(_scope);
		boolean okCond = condition.completeResolve(_scope);
		boolean okBody = body.completeResolve(bodyScope);
		return okCond && okBody;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		Type condType = this.condition.getType();
		boolean okBody = this.body.checkType();
		if (condType.equals(AtomicType.BooleanType)) {
			return okBody;
		}
		Logger.error("[Iteration] Wrong condition type");
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
		throw new SemanticsUndefinedException("Semantics allocateMemory is undefined in Iteration.");
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
		_fragment.addPrefix("debut_boucle" + num);
		_fragment.append(condition.getCode(_factory));
		_fragment.add(_factory.createJumpIf("fin_boucle" + num, 0));
		Fragment bodyCode = body.getCode(_factory);
		_fragment.append(bodyCode);
		_fragment.add(_factory.createJump("debut_boucle" + num));
		_fragment.addSuffix("fin_boucle" + num);
		return _fragment;
	}

}
