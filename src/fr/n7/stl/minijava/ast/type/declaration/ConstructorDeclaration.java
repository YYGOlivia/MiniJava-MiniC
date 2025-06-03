package fr.n7.stl.minijava.ast.type.declaration;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.SymbolTable;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ConstructorDeclaration extends ClassElement {

	private List<ParameterDeclaration> parameters;

	private Block body;

	// added
	// public Block getBody(){
	// return body;
	// }

	public ConstructorDeclaration(String name, List<ParameterDeclaration> parameter, Block body) {
		super(name);
		this.parameters = parameter;
		this.body = body;
	}

	public List<ParameterDeclaration> getParams() {
		return this.parameters;
	}

	public String getSignature() {
		String paramstring = this.parameters.stream()
				.map(p -> p.getType().toString())
				.collect(Collectors.joining(","));
		return this.getName() + "(" + paramstring + ")";
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		SymbolTable constructorScope = new SymbolTable(scope);
		for (ParameterDeclaration paramDecl : this.parameters) {
			if (!constructorScope.accepts(paramDecl)) {
				Logger.error("[ConstructorDeclaration] The parameter " + paramDecl.getName()
						+ " is already declared in the constructor " + this.getName());
			}
			constructorScope.register(paramDecl);
		}
		boolean okBody = body.collectAndPartialResolve(constructorScope);
		return okBody;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in ConstructorDeclaration.");
	}

	@Override
	public boolean checkType() {
		throw new SemanticsUndefinedException("Semantics checkType is undefined in ConstructorDeclaration.");
	}

	@Override
	public String toString() {
		String image = this.getAccessRight() + " " + this.getName() + "(";
		Iterator<ParameterDeclaration> iterator = this.parameters.iterator();
		if (iterator.hasNext()) {
			ParameterDeclaration parameter = iterator.next();
			image += parameter;
			while (iterator.hasNext()) {
				parameter = iterator.next();
				image += " ," + parameter;
			}
		}
		image += ")" + this.body;
		return image;
	}

	@Override
	public Type getType() {
		if (!super.getElementKind().equals(ElementKind.OBJECT)) {
			Logger.error("[ConstructorDeclaration] Constructor" + this.getName()
					+ "(" + parameters.size() + ") cannot be static");
		}
		Logger.warning("[ConstructorDeclaration] AUCUNE IDEE DE CE QU'IL SE PASSE APRES CE POINT");
		return AtomicType.VoidType;
	}
}
