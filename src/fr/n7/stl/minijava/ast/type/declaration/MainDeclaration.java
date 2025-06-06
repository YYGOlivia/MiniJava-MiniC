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

		// construire les functions associés aux méthodes de la classe principale
		for (Declaration d : declarations) {
			if (d instanceof MethodDeclaration) {
				((MethodDeclaration) d).setClassDeclaration(null);
			}
		}
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (scope.knows(name)) {
			Logger.error("[MainDeclaration] The class " + name + " already exists in the scope.");
		}
		SymbolTable mainScope = new SymbolTable(scope);
		boolean okDecl = true;
		for (Declaration decl : declarations) {
			if (decl instanceof MethodDeclaration) {
				MethodDeclaration m = (MethodDeclaration) decl;
				okDecl = okDecl && m.collectAndPartialResolve(mainScope);
			} else if (decl instanceof ConstantDeclaration) {
				ConstantDeclaration cons = (ConstantDeclaration) decl;
				okDecl = okDecl && cons.collectAndPartialResolve(mainScope);
			} else if (decl instanceof VariableDeclaration) {
				VariableDeclaration var = (VariableDeclaration) decl;
				okDecl = okDecl && var.collectAndPartialResolve(mainScope);
			} else {
				Logger.error("[MainDeclaration] " + decl.getName() + " is neither a method or an attribute");
			}
			scope.register(decl);
		}
		return okDecl && main.collectAndPartialResolve(mainScope);
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
			if (decl instanceof MethodDeclaration) {
				MethodDeclaration m = (MethodDeclaration) decl;
				okDecl = okDecl && m.completeResolve(mainScope);
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
		return okDecl && main.completeResolve(mainScope);
	}

	@Override
	public boolean checkType() {
		boolean okDecl = true;
		for (Declaration decl : declarations) {
			if (decl instanceof MethodDeclaration) {
				MethodDeclaration m = (MethodDeclaration) decl;
				okDecl = okDecl && m.checkType();
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
		int off = offset;
		for (Declaration d : declarations) {
			if (d instanceof MethodDeclaration) {
				MethodDeclaration fonct = (MethodDeclaration) d;
				off += fonct.allocateMemory(register, off);
			} else if (d instanceof ConstantDeclaration) {
				ConstantDeclaration cons = (ConstantDeclaration) d;
				off += cons.allocateMemory(register, off);
			} else if (d instanceof VariableDeclaration) {
				VariableDeclaration var = (VariableDeclaration) d;
				off += var.allocateMemory(register, off);
			} else {
				// Ne devrait pas arriver
				Logger.error("[MainDeclaration] " + d.getName() + " is neither a method or an attribute");
			}
		}
		main.allocateMemory(register, off);
		return off; // Pas très utile puisque rien apres main
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragMain = factory.createFragment();
		Fragment fragFunAux = factory.createFragment();
		for (Declaration decl : this.declarations) {
			if (decl instanceof MethodDeclaration) {
				fragFunAux = ((MethodDeclaration) decl).getFunction().getCode(factory);
				if (fragFunAux.getSize()<=0){
					fragFunAux.add(factory.createPush(0));
				}
				fragFunAux.addPrefix(((MethodDeclaration) decl).getFunction().getName());
				fragMain.append(fragFunAux);
			}else if (decl instanceof ConstantDeclaration) {
				ConstantDeclaration cons = (ConstantDeclaration) decl;
				fragMain.append(cons.getCode(factory));
			} else if (decl instanceof VariableDeclaration) {
				VariableDeclaration var = (VariableDeclaration) decl;
				fragMain.append(var.getCode(factory));
			}
		}
		if (fragMain.getSize()<=0){
			fragMain.add(factory.createPush(0));
		}
		fragMain.addComment("main_function");
		Fragment fragMainBody = this.main.getCode(factory);
		fragMainBody.addPrefix("main_body");
		fragMain.append(fragMainBody);
		return fragMain;
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
