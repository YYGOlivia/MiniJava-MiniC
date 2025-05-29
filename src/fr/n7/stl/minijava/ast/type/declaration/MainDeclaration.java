package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;
import java.util.List;

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
		if (scope.knows(name)) {
			Logger.error("[MainDeclaration] The class " + name + " already exists in the scope.");
		}
		SymbolTable mainScope = new SymbolTable(scope);
		boolean okDecl = true;
		for (Declaration decl : declarations) {
			if (decl instanceof FunctionDeclaration) {
				FunctionDeclaration fonct = (FunctionDeclaration) decl;
				okDecl = okDecl && fonct.collectAndPartialResolve(mainScope);
			} else if (decl instanceof ConstantDeclaration) {
				ConstantDeclaration cons = (ConstantDeclaration) decl;
				okDecl = okDecl && cons.collectAndPartialResolve(mainScope);
			} else if (decl instanceof VariableDeclaration) {
				VariableDeclaration var = (VariableDeclaration) decl;
				okDecl = okDecl && var.collectAndPartialResolve(mainScope);
			} else {
				Logger.error("[MainDeclaration] " + decl.getName() + " is neither a method or an attribute");
			}
		}
		return okDecl && main.collectAndPartialResolve(scope);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		Logger.error("[MainDeclaration] The main class " + this.name + " cannot be declared inside a function.");
		return false;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		if (scope.knows(name)) {
			Logger.error("[MainDeclaration] The class " + name + " already exists in the scope.");
		}
		SymbolTable mainScope = new SymbolTable(scope);
		boolean okDecl = true;
		for (Declaration decl : declarations) {
			if (decl instanceof FunctionDeclaration) {
				FunctionDeclaration fonct = (FunctionDeclaration) decl;
				okDecl = okDecl && fonct.completeResolve(mainScope);
			} else if (decl instanceof ConstantDeclaration) {
				ConstantDeclaration cons = (ConstantDeclaration) decl;
				okDecl = okDecl && cons.completeResolve(mainScope);
			} else if (decl instanceof VariableDeclaration) {
				VariableDeclaration var = (VariableDeclaration) decl;
				okDecl = okDecl && var.completeResolve(mainScope);
			} else {
				Logger.error("[MainDeclaration] " + decl.getName() + " is neither a method or an attribute");
			}
		}
		return okDecl && main.completeResolve(scope);
	}

	@Override
	public boolean checkType() {
		boolean okDecl = true;
		for (Declaration decl : declarations) {
			if (decl instanceof FunctionDeclaration) {
				FunctionDeclaration fonct = (FunctionDeclaration) decl;
				okDecl = okDecl && fonct.checkType();
			} else if (decl instanceof ConstantDeclaration) {
				ConstantDeclaration cons = (ConstantDeclaration) decl;
				okDecl = okDecl && cons.checkType();
			} else if (decl instanceof VariableDeclaration) {
				VariableDeclaration var = (VariableDeclaration) decl;
				okDecl = okDecl && var.checkType();
			} else {
				Logger.error("[MainDeclaration] " + decl.getName() + " is neither a method or an attribute");
			}
		}
		return okDecl && main.checkType();
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
