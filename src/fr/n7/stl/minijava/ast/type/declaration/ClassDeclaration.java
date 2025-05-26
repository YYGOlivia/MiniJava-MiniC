/**
 * 
 */
package fr.n7.stl.minijava.ast.type.declaration;

import java.util.List;

import fr.n7.stl.util.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * 
 */
public class ClassDeclaration implements Instruction, Declaration {

	protected List<ClassElement> elements;

	protected boolean concrete;

	protected String name;

	protected String ancestor;

	/**
	 * 
	 */
	public ClassDeclaration(boolean concrete, String name, String ancestor, List<ClassElement> elements) {
		this.concrete = concrete;
		this.name = name;
		this.ancestor = ancestor;
		this.elements = elements;
	}

	/**
	 * 
	 */
	public ClassDeclaration(boolean concrete, String name, List<ClassElement> elements) {
		this(concrete, name, null, elements);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics collect is undefined in ClassDeclaration.");
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in ClassDeclaration.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in ClassDeclaration.");
	}

	@Override
	public boolean checkType() {
		throw new SemanticsUndefinedException("Semantics check type is undefined in ClassDeclaration.");
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		throw new SemanticsUndefinedException("Semantics allocation memory is undefined in ClassDeclaration.");
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics get code is undefined in ClassDeclaration.");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String image = "";
		if (!this.concrete) {
			image += "abstract ";
		}
		image += "class " + this.name + " ";
		if (this.ancestor != null) {
			image += "extends " + this.ancestor + " ";
		}
		image += "{\n";
		for (ClassElement e : this.elements) {
			image += e;
		}
		image += "}\n";
		return image;
	}

}
