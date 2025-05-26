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

public class MainDeclaration implements Instruction {

	protected String name;

	protected List<Declaration> declarations;

	protected Block main;

	public MainDeclaration(String name, List<Declaration> declarations, Block main) {
		this.name = name;
		this.declarations = declarations;
		this.main = main;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		String image = "";
		image += "public class " + this.name + " ";
		image += "{\n";
		image += "\n";
		for (Declaration uneDeclaration : this.declarations) {
			image += uneDeclaration;
			image += "\n";
		}
		image += "\tpublic static void Main( String[] args) ";
		image += this.main;
		image += "\n";
		image += "}\n";
		return image;
	}

}
