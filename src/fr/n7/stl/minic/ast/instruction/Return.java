/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.security.InvalidParameterException;

/**
 * Implementation of the Abstract Syntax Tree node for a return instruction.
 * 
 * @author Marc Pantel
 *
 */
public class Return implements Instruction {

	protected Expression value;

	protected FunctionDeclaration function;

	public Return(Expression _value) {
		this.value = _value;
		this.function = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ((this.function != null) ? ("// Return in function : " + this.function.getName() + "\n") : "")
				+ "return " + this.value + ";\n";
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
		return value.collectAndPartialResolve(_scope);
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
		return value.completeResolve(_scope);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope, FunctionDeclaration _container) {
		if (this.function == null) {
			this.function = _container;
		} else {
			throw new InvalidParameterException(
					"Trying to set a function declaration to a return instruction when one has already been set.");
		}
		return this.collectAndPartialResolve(_scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean okType = value.getType().compatibleWith(function.getType());
		if (!okType) {
			Logger.error("[Return] Type " + value.getType() + " is not compatible with expected return type " +
					function.getType() + " in function " + function.getName());
		}
		return okType;
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
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		fragment.append(value.getCode(_factory));

		int keep = value.getType().length(); // taille de ce qu'on écrit dans la pile
		int remove = function.getParameters().stream()
				.map(param -> param.getType().length())
				.reduce(0, Integer::sum); // taille à remplacer (on oublie les paramètres)
		fragment.add(_factory.createReturn(keep, remove));

		fragment.addComment(toString());
		return fragment;
	}
}
