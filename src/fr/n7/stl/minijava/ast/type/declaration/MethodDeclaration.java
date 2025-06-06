package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class MethodDeclaration extends ClassElement {

	private boolean concrete;

	private List<ParameterDeclaration> parameters;

	private Block body;

	private FunctionDeclaration function;

	private Type type;

	public int tamAdress;

	public MethodDeclaration(String name, Type type, List<ParameterDeclaration> parameter, Block body) {
		super(name);
		this.parameters = parameter;
		this.body = body;
		this.concrete = (body != null);
		this.type = type;
	}

	public MethodDeclaration(String name, Type type, List<ParameterDeclaration> parameter) {
		this(name, type, parameter, null);
	}

	public Block getBody() {
		return body;
	}

	/**
	 * Définit la déclaration de la classe dans laquelle se trouve la méthode. Si
	 * classDecl est <code>null</code>, la méthode est une fonction globale (dans la
	 * "classe"
	 * principale).
	 */
	@Override
	public void setClassDeclaration(ClassDeclaration classDecl) {
		if (classDecl == null) {
			this.function = new FunctionDeclaration(this.getName(), type, this.parameters, this.body);
			return;
		}
		super.setClassDeclaration(classDecl);
		List<ParameterDeclaration> funcParams = new ArrayList<>(this.parameters);
		if (!this.isStatic()) {
			// paramètre "this" uniquement si méthode d'instance
			ParameterDeclaration self = new ParameterDeclaration("this", classDecl.getType());
			funcParams.add(0, self);
		}
		this.function = new FunctionDeclaration(this.getName(), type, funcParams, body);
	}

	/**
	 * Renvoie la signature de la méthode sous la forme nom(type1,type2,...)
	 */
	public String getSignature() {
		String paramString = this.parameters.stream()
				.map(p -> p.getType().toString())
				.collect(Collectors.joining("_"));
		return this.getName() + "_" + paramString + "_";
	}

	public FunctionDeclaration getFunction() {
		return this.function;
	}

	public List<ParameterDeclaration> getParams() {
		return this.parameters;
	}

	public boolean isConcrete() {
		return this.concrete;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		SymbolTable functionScope = new SymbolTable(scope);
		for (ParameterDeclaration paramDecl : this.parameters) {
			if (!functionScope.accepts(paramDecl)) {
				Logger.error("[MethodDeclaration] The parameter " + paramDecl.getName()
						+ " is already declared in the method " + this.getName());
			}
			functionScope.register(paramDecl);
		}
		boolean okType = type.completeResolve(scope);
		boolean okBody = body == null || body.collectAndPartialResolve(functionScope, this.function);
		return okBody && okType;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		SymbolTable functionScope = new SymbolTable(scope);
		for (ParameterDeclaration paramDecl : this.parameters) {
			if (!functionScope.accepts(paramDecl)) {
				Logger.error("[MethodDeclaration] The parameter " + paramDecl.getName()
						+ " is already declared in the method " + this.getName());
			}
			functionScope.register(paramDecl);
		}
		boolean okType = type.completeResolve(scope);
		boolean okBody = body == null || body.completeResolve(functionScope);
		return okBody && okType;
	}

	@Override
	public boolean checkType() {
		return this.body.checkType();
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		// register utile uniquement si static (static -> dans classe)
		this.register = register;
		this.offset = offset;
		return this.function.allocateMemory(register, offset); // return 0;
	}

	@Override
	public String toString() {
		String image = "";
		if (!this.concrete) {
			image += "abstract ";
		}
		image += this.getAccessRight() + " " + this.getElementKind() + " " + this.type + " " + this.getName() + "(";
		Iterator<ParameterDeclaration> iterator = this.parameters.iterator();
		if (iterator.hasNext()) {
			ParameterDeclaration parameter = iterator.next();
			image += parameter;
			while (iterator.hasNext()) {
				parameter = iterator.next();
				image += " ," + parameter;
			}
		}
		image += ")";
		if (this.concrete) {
			image += " " + this.body + "\n";
		} else {
			image += ";\n";
		}
		return image;
	}

	@Override
	public Type getType() {
		return type;
	}

}
