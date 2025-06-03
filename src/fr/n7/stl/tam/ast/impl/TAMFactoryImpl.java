/**
 * 
 */
package fr.n7.stl.tam.ast.impl;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.TAMInstruction;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the factory to build a TAM program AST.
 * It relies on a single implementation class TAMInstructionImpl.
 * 
 * @author Marc Pantel
 *
 */
public class TAMFactoryImpl implements TAMFactory {

	private static int labelNumber = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createFragment()
	 */
	@Override
	public Fragment createFragment() {
		return new FragmentImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createLoadL(int)
	 */
	@Override
	public TAMInstruction createLoadL(int value) {
		return new TAMInstructionImpl(
				TAMInstructionKind.LOADL,
				Optional.empty(),
				Optional.empty(),
				Optional.of(value),
				Optional.empty(),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createPush(int)
	 */
	@Override
	public TAMInstruction createPush(int size) {
		return new TAMInstructionImpl(
				TAMInstructionKind.PUSH,
				Optional.empty(),
				Optional.empty(),
				Optional.of(size),
				Optional.empty(),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createPop(int, int)
	 */
	@Override
	public TAMInstruction createPop(int keep, int remove) {
		return new TAMInstructionImpl(
				TAMInstructionKind.POP,
				Optional.empty(),
				Optional.empty(),
				Optional.of(remove),
				Optional.empty(),
				Optional.of(keep),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createLoad(fr.n7.stl.tam.ast.Register, int,
	 * int)
	 */
	@Override
	public TAMInstruction createLoad(Register register, int offset, int size) {
		return new TAMInstructionImpl(
				TAMInstructionKind.LOAD,
				Optional.empty(),
				Optional.of(register),
				Optional.of(offset),
				Optional.empty(),
				Optional.of(size),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createLoadA(fr.n7.stl.tam.ast.Register,
	 * int)
	 */
	@Override
	public TAMInstruction createLoadA(Register register, int offset) {
		return new TAMInstructionImpl(
				TAMInstructionKind.LOADA,
				Optional.empty(),
				Optional.of(register),
				Optional.of(offset),
				Optional.empty(),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createLoadA(java.lang.String)
	 */
	@Override
	public TAMInstruction createLoadA(String label) {
		return new TAMInstructionImpl(
				TAMInstructionKind.LOADA,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.of(label),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createLoadI(int)
	 */
	@Override
	public TAMInstruction createLoadI(int size) {
		return new TAMInstructionImpl(
				TAMInstructionKind.LOADI,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.of(size),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createStore(fr.n7.stl.tam.ast.Register,
	 * int, int)
	 */
	@Override
	public TAMInstruction createStore(Register register, int offset, int size) {
		return new TAMInstructionImpl(
				TAMInstructionKind.STORE,
				Optional.empty(),
				Optional.of(register),
				Optional.of(offset),
				Optional.empty(),
				Optional.of(size),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createStoreI(int)
	 */
	@Override
	public TAMInstruction createStoreI(int size) {
		return new TAMInstructionImpl(
				TAMInstructionKind.STOREI,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.of(size),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createJump(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public TAMInstruction createJump(Register register, int offset) {
		return new TAMInstructionImpl(
				TAMInstructionKind.JUMP,
				Optional.empty(),
				Optional.of(register),
				Optional.of(offset),
				Optional.empty(),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createJump(java.lang.String)
	 */
	@Override
	public TAMInstruction createJump(String label) {
		return new TAMInstructionImpl(
				TAMInstructionKind.JUMP,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.of(label),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createJumpIf(fr.n7.stl.tam.ast.Register,
	 * int, int)
	 */
	@Override
	public TAMInstruction createJumpIf(Register register, int offset, int value) {
		return new TAMInstructionImpl(
				TAMInstructionKind.JUMPIF,
				Optional.empty(),
				Optional.of(register),
				Optional.of(offset),
				Optional.empty(),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createJumpIf(java.lang.String, int)
	 */
	@Override
	public TAMInstruction createJumpIf(String label, int value) {
		return new TAMInstructionImpl(
				TAMInstructionKind.JUMPIF,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.of(label),
				Optional.of(value),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createHalt()
	 */
	@Override
	public TAMInstruction createHalt() {
		return new TAMInstructionImpl(
				TAMInstructionKind.HALT,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createCall(fr.n7.stl.tam.ast.Register, int,
	 * int)
	 */
	@Override
	public TAMInstruction createCall(Register register, int offset, Register frame) {
		return new TAMInstructionImpl(
				TAMInstructionKind.CALL,
				Optional.empty(),
				Optional.of(register),
				Optional.of(offset),
				Optional.empty(),
				Optional.empty(),
				Optional.of(frame));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createCall(java.lang.String, int)
	 */
	@Override
	public TAMInstruction createCall(String label, Register frame) {
		return new TAMInstructionImpl(
				TAMInstructionKind.CALL,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.of(label),
				Optional.empty(),
				Optional.of(frame));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createCallI(int)
	 */
	@Override
	public TAMInstruction createCallI(Register frame) {
		return new TAMInstructionImpl(
				TAMInstructionKind.CALLI,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.of(frame));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createCallI(int)
	 */
	@Override
	public TAMInstruction createCallI() {
		return new TAMInstructionImpl(
				TAMInstructionKind.CALLI,
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty(),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createReturn(int, int)
	 */
	@Override
	public TAMInstruction createReturn(int keep, int remove) {
		return new TAMInstructionImpl(
				TAMInstructionKind.RETURN,
				Optional.empty(),
				Optional.empty(),
				Optional.of(remove),
				Optional.empty(),
				Optional.of(keep),
				Optional.empty());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMFactory#createFragment(java.util.List)
	 */
	@Override
	public Fragment createFragment(List<TAMInstruction> instructions) {
		Fragment local = new FragmentImpl();
		for (TAMInstruction instruction : instructions) {
			local.add(instruction);
		}
		return local;
	}

	@Override
	public int createLabelNumber() {
		labelNumber++;
		return labelNumber;
	}

	private int offset = 0;

	@Override
	public void setOffset(int off){
		this.offset = off;
	}

	@Override
	public int getOffset(){
		return offset;
	}

}
