/**
 * 
 */
package fr.n7.stl.tam.ast.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMInstruction;

/**
 * Abstract class that gathers the common attributes for all TAM instructions.
 * 
 * @author Marc Pantel
 *
 */
class TAMInstructionImpl implements TAMInstruction {

	/**
	 * Each TAM instruction has a unique kind, i.e. the name of the instruction.
	 */
	private TAMInstructionKind kind;

	/**
	 * Each TAM instruction can have prefix comments used for relating this
	 * instruction
	 * to the block source code.
	 */
	protected List<String> comments;

	/**
	 * Each TAM instruction can have prefix labels used for computing locations to
	 * that instruction
	 * for JUMP and CALL instructions.
	 */
	protected List<String> prefixes;

	/**
	 * Each TAM instruction can have suffix labels used for computing locations
	 * following that instruction
	 * for JUMP and CALL instructions.
	 */
	protected List<String> suffixes;

	/**
	 * Some TAM instructions manipulate explicitly the memory (LOAD and STORE
	 * instructions).
	 * This is the register of the manipulated memory.
	 */
	protected Optional<Register> register;

	/**
	 * Some TAM instructions manipulate explicitly the memory (LOAD and STORE
	 * instructions).
	 * This is the offset of the register of the manipulated memory.
	 */
	protected Optional<Integer> offset;

	/**
	 * Some TAM instructions use labels that are resolved by the TAM assembler tool
	 * (JUMP,
	 * JUMPIF, CALL).
	 * This is the target label for these instructions.
	 */
	protected Optional<String> target;

	/**
	 * Some TAM instructions manipulate explicitly the memory (LOAD and STORE
	 * instructions).
	 * This is the size the manipulated memory chunk.
	 * It is also used by other instructions like PUSH and POP that manipulates the
	 * stack.
	 */
	protected Optional<Integer> size;

	/**
	 * Some TAM instructions manipulate explicitly the call stack and the current
	 * frame (CALL, CALLI instructions).
	 * This is the frame of the caller function.
	 * It is stored in the size bitfield in the instructions.
	 */
	private Optional<Register> frame;

	/**
	 * Construction for a full TAM instruction with kind, label, location and size.
	 * 
	 * @param kind     Kind for the TAM instruction.
	 * @param label    Optional Label for the TAM instruction.
	 * @param register Optional Register for the TAM instruction.
	 * @param offset   Optional Integer offset for the TAM instruction.
	 * @param target   Optional Label target for the TAM instruction.
	 * @param size     Optional Integer size for the TAM instruction.
	 * @param frame    Optional Register frame for the TAM instruction.
	 */
	public TAMInstructionImpl(TAMInstructionKind kind, Optional<String> label,
			Optional<Register> register, Optional<Integer> offset,
			Optional<String> target, Optional<Integer> size, Optional<Register> frame) {
		this.kind = kind;
		this.comments = new LinkedList<String>();
		this.prefixes = new LinkedList<String>();
		this.suffixes = new LinkedList<String>();
		if (label.isPresent()) {
			this.prefixes.add(label.get());
		}
		this.register = register;
		this.offset = offset;
		this.target = target;
		this.size = size;
		this.frame = frame;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMInstruction#addPrefix(fr.n7.stl.tam.ast.Label)
	 */
	@Override
	public void addPrefix(String label) {
		this.prefixes.add(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMInstruction#addSuffix(fr.n7.stl.tam.ast.Label)
	 */
	@Override
	public void addSuffix(String label) {
		this.suffixes.add(label);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.tam.ast.TAMInstruction#addComment(java.lang.String)
	 */
	@Override
	public void addComment(String comment) {
		this.comments.add(comment.replaceAll("\n", "\n;"));
	}

	public String toString() {
		String result = "";
		for (String comment : this.comments) {
			result += ";" + comment + "\n";
		}
		for (String label : this.prefixes) {
			result += label + "\n";
		}
		result += this.kind;
		result += ((this.size.isPresent()) ? (" (" + this.size.get() + ")")
				: ((this.frame.isPresent()) ? (" (" + this.frame.get() + ")") : ""));
		result += ((this.offset.isPresent()) ? (" " + this.offset.get()) : "");
		result += ((this.register.isPresent()) ? ("[" + this.register.get() + "]") : "");
		result += ((this.target.isPresent()) ? (" " + this.target.get()) : "");
		result += "\n";
		for (String label : this.suffixes) {
			result += label + "\n";
		}
		return result;
	}

}
