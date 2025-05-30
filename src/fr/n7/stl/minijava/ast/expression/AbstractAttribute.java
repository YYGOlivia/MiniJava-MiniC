package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.accessible.IdentifierAccess;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassElement;
import fr.n7.stl.util.Logger;

public abstract class AbstractAttribute<ObjectKind extends Expression> implements Expression {

	private ObjectKind object;
	private String name;
	private AttributeDeclaration attribute;

	public AbstractAttribute(ObjectKind object, String name) {
		this.object = object;
		this.name = name;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		object.collectAndPartialResolve(scope);
		if (!(object instanceof IdentifierAccess)){
			Logger.error("[AbstracAttribute] The object " + object.toString() + " is not an identifier");
		}
		IdentifierAccess id = (IdentifierAccess) object;
		Declaration decl = id.getExpression().getDeclaration();
		Declaration cDecl = scope.get(decl.getType().toString());
		if (!(cDecl instanceof ClassDeclaration)){
			Logger.error("[AbstracAttribute] The object " + object.toString() + " is not an instance of a class");
		}
		ClassDeclaration classDecl = (ClassDeclaration) cDecl;	
		ClassElement elem = classDecl.getElement(name);
		if (elem==null){
			Logger.error("[AbstracAttribute] The attribute " + name + " is not declared in class "+ classDecl.getName());
		}
		this.attribute = (AttributeDeclaration) elem;

		//TODO : verifier les acces 
		// comment savoir si on est dans le main, ou dans une classe lors de l'appel ?

		return true;
		//throw new SemanticsUndefinedException("Semantics collect is undefined in AbstractAttribute.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO verifier acces
		return true;
		//throw new SemanticsUndefinedException("Semantics resolve is undefined in AbstractAttribute.");
	}

	@Override
	public Type getType() {
		return attribute.getType();
		//throw new SemanticsUndefinedException("Semantics getType is undefined in AbstractAttribute.");
	}

	@Override
	public String toString() {
		return this.object + "." + this.name;
	}

}
