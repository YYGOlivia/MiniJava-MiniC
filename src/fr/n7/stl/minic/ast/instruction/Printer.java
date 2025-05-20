/**
 * 
 */
package fr.n7.stl.minic.ast.instruction;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.TAMInstruction;

/**
 * Implementation of the Abstract Syntax Tree node for a printer instruction.
 * 
 * @author Marc Pantel
 *
 */
public class Printer implements Instruction {

	protected Expression parameter;

	public Printer(Expression value) {
		this.parameter = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "print " + this.parameter + ";\n";
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
		return this.parameter.collectAndPartialResolve(scope);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		return this.parameter.collectAndPartialResolve(scope);
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
		return parameter.completeResolve(scope);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
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

	private TAMInstruction getRightOut(AtomicType atomicType){
		switch (atomicType) {
		case BooleanType:
			return Library.BOut;
		case IntegerType:
			return Library.IOut;
		case CharacterType:
			return Library.COut;
		case StringType:
			return Library.SOut;
		default:
			// Aucune idee de ce qu'on fait là
			return Library.IOut;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		Type type = parameter.getType();
		if (type instanceof AtomicType){
			AtomicType atomicType = (AtomicType) type;
			fragment.append(parameter.getCode(factory));
			fragment.add(getRightOut(atomicType));
		}else{
			//Pour print toute les valeurs dans l'ordre inverse -> <2,3> sera affiché 3 2
			for (int i=0; i<type.length(); i++){
				fragment.add(Library.IOut); // Ici ca ne marche que pour les int
				fragment.add(factory.createLoadL(' '));
				fragment.add(Library.COut);
			}
		}
		
		//Pour avoir des espaces entre chaque valeur
		fragment.add(factory.createLoadL(' '));
		fragment.add(Library.COut);
		return fragment;
	}

}
