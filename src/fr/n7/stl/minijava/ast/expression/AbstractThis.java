package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public abstract class AbstractThis<ObjectKind extends Expression> implements Expression {

	//added
	private ObjectKind object; // pour mettre l'instance de la classe ?

	private ClassDeclaration classDeclaration;

	public AbstractThis() {
		// rien à faire
		// throw new SemanticsUndefinedException("Semantics constructor is undefined in
		// AbstractThis.");
	}

	public ClassDeclaration getClassDeclaration(){
		return classDeclaration;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		Declaration classDecl = scope.get("this");
		if (classDecl instanceof ClassDeclaration){
			this.classDeclaration = (ClassDeclaration) classDecl;
		}else{
			Logger.error("[AbstractThis] Tried to call \"this\" outside a class");
		}
		return true;
		//throw new SemanticsUndefinedException("Semantics collect is undefined in AbstractThis.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in AbstractThis.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is undefined in AbstractThis.");
	}

	@Override
	public String toString() {
		return "this";
	}
}
