/**
 * 
 */
package fr.n7.stl.tam.ast;

import java.util.List;

/**
 * Factory to build abstract syntax tree nodes for the TAM language.
 * 
 * @author Marc Pantel
 *
 */
public interface TAMFactory {

	/**
	 * Build a TAM Push instruction AST node.
	 * 
	 * @param size Size of the memory chunk that is added on top of the stack.
	 * @return A TAM Push instruction AST node.
	 */
	public TAMInstruction createPush(int size);

	/**
	 * Build a TAM Pop instruction AST node.
	 * 
	 * @param keep   Size of the memory chunk that is preserved on top of the
	 *                stack.
	 * @param remove Size of the memory chunk that is removed from the top of the
	 *                stack.
	 * @return A TAM Pop instruction AST node.
	 */
	public TAMInstruction createPop(int keep, int remove);

	/**
	 * Build a TAM Load instruction AST node.
	 * 
	 * @param register Register for the memory chunk that is copied on the stack.
	 * @param offset   Offset for the memory chunk that is copied on the stack.
	 * @param size     Size of the memory chunk that is copied on the stack.
	 * @return A TAM Load instruction AST node.
	 */
	public TAMInstruction createLoad(Register register, int offset, int size);

	/**
	 * Build a TAM integer constant Load instruction AST node.
	 * 
	 * @param value Value of the integer constant that is copied on the stack.
	 * @return A TAM integer constant Load instruction AST node.
	 */
	public TAMInstruction createLoadL(int value);

	/**
	 * Build a TAM address Load instruction AST node whose execution
	 * loads an address on the stack.
	 * 
	 * @param register Register for the address whose value is loaded on the stack.
	 * @param offset   Offset for the address whose value is loaded on the stack.
	 * @return A TAM address Load instruction AST node.
	 */
	public TAMInstruction createLoadA(Register register, int offset);

	/**
	 * Build a TAM address Load address instruction AST node whose execution
	 * loads an address on the stack.
	 * 
	 * @param label Label that will be translated to an address whose
	 *               value is loaded on the stack.
	 * @return A TAM address Load instruction AST node.
	 */
	public TAMInstruction createLoadA(String label);

	/**
	 * Build a TAM Load Immediate instruction AST node whose execution will pop
	 * an address from the stack and copy on the stack a memory chunk located at
	 * that address of a provided size.
	 * 
	 * @param size Size of the memory chunk copied on the stack after popping the
	 *              address.
	 * @return A TAM Load Immediate instruction AST node.
	 */
	public TAMInstruction createLoadI(int size);

	/**
	 * Build a TAM Store instruction AST node whose execution will copy from the
	 * stack
	 * a memory chunk of the provided size to the provided location.
	 * 
	 * @param register Register for the address of the memory chunk.
	 * @param offset   Offset for the address of the memory chunk.
	 * @param size     : Size of the memory chunk that is copied.
	 * @return A TAM Store instruction AST node.
	 */
	public TAMInstruction createStore(Register register, int offset, int size);

	/**
	 * Build a TAM Store Immediate instruction AST node whose execution will pop a
	 * memory
	 * address from the stack and then copy a memory chunk of the provided size to
	 * that
	 * address.
	 * 
	 * @param size : Size of the memory chunk that is copied.
	 * @return A TAM Store Immediate instruction AST node.
	 */
	public TAMInstruction createStoreI(int size);

	/**
	 * Build a TAM Jump instruction AST node whose execution will transfer the
	 * control
	 * (register CP - Code Pointer) to the provided location.
	 * 
	 * @param register Register for the address where the control is transfered to.
	 * @param offset   Offset for the address where the control is transfered to.
	 * @return A TAM Jump instruction AST node.
	 */
	public TAMInstruction createJump(Register register, int offset);

	/**
	 * Build a TAM Jump instruction AST node whose execution will transfer the
	 * control
	 * (register CP - Code Pointer) to the address resolved from the provided label.
	 * 
	 * @param label Label that will be resolved to an address.
	 * @return A TAM Jump instruction AST node.
	 */
	public TAMInstruction createJump(String label);

	/**
	 * Build a TAM conditional Jump instruction AST node whose execution will
	 * transfer
	 * the control (register CP - Code Pointer) to the provided location if the top
	 * of
	 * the stack contains the provided value.
	 * 
	 * @param register Register for the address where the control is transfered to.
	 * @param offset   Offset for the address where the control is transfered to.
	 * @param value    : Integer whose value is compared with the top of the stack.
	 * @return A TAM conditional Jump instruction AST node.
	 */
	public TAMInstruction createJumpIf(Register register, int offset, int value);

	/**
	 * Build a TAM conditional Jump instruction AST node whose execution will
	 * transfer
	 * the control (register CP - Code Pointer) to the address resulting from the
	 * resolution of the provided label if the top of the stack contains the
	 * provided value.
	 * 
	 * @param label : Label which is resolved to the address assigned to the Code
	 *               Pointer.
	 * @param value : Integer whose value is compared with the top of the stack.
	 * @return A TAM conditional Jump instruction AST node.
	 */
	public TAMInstruction createJumpIf(String label, int value);

	/**
	 * Build a TAM Halt instruction AST node whose execution will halt the program.
	 * 
	 * @return A TAM Halt instruction AST node.
	 */
	public TAMInstruction createHalt();

	/**
	 * Build a TAM Call instruction AST node whose execution will build a call frame
	 * (current value of LB, current value of ST, current value of CP), push it
	 * on the stack and transfer the control to the provided location (assign the
	 * Control Pointer
	 * register to the address of the provided location).
	 * 
	 * @param register Register for the address where the control is transfered to.
	 * @param offset   Offset for the address where the control is transfered to.
	 * @param frame    The caller frame in the call stack.
	 * @return A TAM Call instruction AST node.
	 */
	public TAMInstruction createCall(Register register, int offset, Register frame);

	/**
	 * Build a TAM Call instruction AST node whose execution will build a call frame
	 * (current value of LB, current value of ST, current value of CP), push it
	 * on the stack and transfer the control to the address resolved from the
	 * provided
	 * label (assign the Control Pointer register to that address).
	 * 
	 * @param label : Label whose resolved address is where the control will be
	 *               transfered.
	 * @param frame The caller frame in the call stack.
	 * @return A TAM Call instruction AST node.
	 */
	public TAMInstruction createCall(String label, Register frame);

	/**
	 * Build a TAM Call Immediate instruction AST node whose execution will pop an
	 * address
	 * from the stack, build a call frame (current value of LB, current value of ST,
	 * current
	 * value of CP), push it on the stack and transfer the control to the popped
	 * address
	 * (assign the Control Pointer register to that address).
	 * 
	 * @param frame The caller frame in the call stack.
	 * @return A TAM Call Immediate instruction AST node.
	 */
	public TAMInstruction createCallI(Register frame);

	/**
	 * Build a TAM Call Immediate instruction AST node whose execution will pop an
	 * address
	 * from the stack, build a call frame (current value of LB, current value of ST,
	 * current
	 * value of CP), push it on the stack and transfer the control to the popped
	 * address
	 * (assign the Control Pointer register to that address).
	 * 
	 * @param frame The caller frame in the call stack.
	 * @return A TAM Call Immediate instruction AST node.
	 */
	public TAMInstruction createCallI();

	/**
	 * Build a TAM Return instruction AST node whose execution will pop a memory
	 * chunk of the
	 * provided keep size then will pop a call frame from the stack, then will pop
	 * a second memory
	 * chunk from the stack of the provided remove size, restore the various
	 * registers from the call
	 * frame and push the first chunk on the stack.
	 * 
	 * @param keep   : The size of the memory chunk that is copied from the top of
	 *                the stack
	 *                before removing the execution frame from the call stack, and
	 *                copied back to the top of the
	 *                stack after removing the execution frame.
	 * @param remove : The size of the memory chunk that is removed with the
	 *                execution frame.
	 * @return A TAM Return instruction AST node.
	 */
	public TAMInstruction createReturn(int keep, int remove);

	/**
	 * Build an empty TAM fragment AST node.
	 * 
	 * @return An empty TAM fragment AST node.
	 */
	public Fragment createFragment();

	/**
	 * Build a TAM fragment AST node that executes a sequence of TAMInstruction.
	 * 
	 * @param instructions The sequence of TAMInstruction that makes the fragment.
	 * @return A TAM fragment AST node containing a sequence of TAMInstruction.
	 */
	public Fragment createFragment(List<TAMInstruction> instructions);

	public int createLabelNumber();

	public void setOffset(int off);

	public int getOffset();

}
