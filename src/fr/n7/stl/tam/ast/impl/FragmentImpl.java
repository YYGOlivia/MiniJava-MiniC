/**
 * 
 */
package fr.n7.stl.tam.ast.impl;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMInstruction;

/**
 * Implementation of a TAM fragment using a linked list of TAM Instruction.
 * 
 * @author Marc Pantel
 *
 */
public class FragmentImpl implements Fragment {

	/**
	 * The sequence of TAM Instruction in the Fragment.
	 */
	private List<TAMInstruction> instructions;

	/**
	 * Create an empty fragment.
	 */
	public FragmentImpl() {
		this.instructions = new LinkedList<TAMInstruction>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.Fragment#add(fr.n7.stl.tam.ast.TAMInstruction)
	 */
	@Override
	public void add(TAMInstruction instruction) {
		this.instructions.add(instruction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.Fragment#append(fr.n7.stl.tam.ast.Fragment)
	 */
	@Override
	public void append(Fragment fragment) {
		this.instructions.addAll(((FragmentImpl) fragment).instructions);
	}

	@Override
	public String toString() {
		String result = "";
		for (TAMInstruction instruction : this.instructions) {
			result += instruction;
		}
		return result;
	}

	public void addComment(String comment) {
		if (this.instructions.size() > 0) {
			this.instructions.get(0).addComment(comment);
		} else {
			throw new IllegalArgumentException("Fragment size is 0. No comment can be added.");
		}
	}

	@Override
	public void addPrefix(String label) {
		if (this.instructions.size() > 0) {
			this.instructions.get(0).addPrefix(label);
		} else {
			throw new IllegalArgumentException("Fragment size is 0. No prefix label can be added.");
		}
	}

	@Override
	public void addSuffix(String label) {
		if (this.instructions.size() > 0) {
			this.instructions.get(this.instructions.size() - 1).addSuffix(label);
		} else {
			throw new IllegalArgumentException("Fragment size is 0. No suffix label can be added.");
		}
	}

}
