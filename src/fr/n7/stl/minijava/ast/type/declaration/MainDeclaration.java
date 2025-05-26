package fr.n7.stl.minijava.ast.type.declaration;

import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class MainDeclaration implements Instruction {

	private String name;

	private List<Declaration> declarations;

	private Block main;

	/**
	 * Déclaration de la classe principale.
	 */
	public MainDeclaration(String name, List<Declaration> declarations, Block main) {
		this.name = name;
		this.declarations = declarations;
		this.main = main;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics collect is undefined in MainDeclaration.");
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		throw new SemanticsUndefinedException("Semantics collect is undefined in MainDeclaration.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in MainDeclaration.");
	}

	@Override
	public boolean checkType() {
		throw new SemanticsUndefinedException("Semantics checkType is undefined in MainDeclaration.");
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		throw new SemanticsUndefinedException("Semantics allocateMemory is undefined in MainDeclaration.");
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in MainDeclaration.");
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		String image = "public class " + this.name + " {\n\n";
		for (Declaration uneDeclaration : this.declarations) {
			image += uneDeclaration + "\n";
		}
		image += "public static void Main(String[] args) " + this.main + "\n}\n";
		return image;
	}

}
