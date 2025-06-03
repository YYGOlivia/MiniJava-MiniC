package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;

public class AttributeDeclaration extends ClassElement {

	private Type type;
	private boolean isFinal;


	public AttributeDeclaration(String name, Type type) {
		super(name);
		this.type = type;
		//TODO ajouter isFinal
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'collectAndPartialResolve'");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'completeResolve'");
	}

	@Override
	public Type getType() {
		return this.type;
	}

	public boolean isFinal(){
		return isFinal;
	}

	@Override
	public String toString() {
		return this.getAccessRight() + " " + this.getElementKind() + " " + type + " " + this.getName() + ";\n";
	}
}
