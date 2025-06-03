package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.accessible.IdentifierAccess;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.expression.accessible.ThisAccess;
import fr.n7.stl.minijava.ast.expression.assignable.ThisAssignment;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ElementKind;
import fr.n7.stl.util.Logger;

public abstract class AbstractAttribute<ObjectKind extends Expression> implements Expression {

	private ObjectKind object;
	private String name;
	protected AttributeDeclaration attribute;

	public AbstractAttribute(ObjectKind object, String name) {
		this.object = object;
		this.name = name;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (object == null) {
			// attribut statique
			if (!scope.knows(name)) {
				Logger.error("[AbstractAttribute] The attribute " + name + " is not defined");
			}
			this.attribute = (AttributeDeclaration) scope.get(name);
			// Pas besoin vérifier statique car si dans le scope il est soit statique soit
			// on est dans la classe
			return true;
		}

		object.collectAndPartialResolve(scope);
		if (object instanceof IdentifierAccess) {
			IdentifierAccess id = (IdentifierAccess) object;
			boolean isStatic = id.getExpression() == null;
			Declaration cDecl;
			if (isStatic) {
				cDecl = scope.get(id.getName());
			} else {
				cDecl = scope.get(id.getExpression().getDeclaration().getType().toString());
			}
			if (!(cDecl instanceof ClassDeclaration)) {
				Logger.error("[AbstractAttribute] The object " + object.toString() + " is not an instance of a class");
			}
			ClassDeclaration classDecl = (ClassDeclaration) cDecl;
			this.attribute = classDecl.getAttribute(name);
			if (this.attribute == null) {
				Logger.error("[AbstractAttribute] The attribute " + name +
						" is not declared in class " + classDecl.getName());
			}

			boolean methodStatic = attribute.getElementKind() == ElementKind.CLASS;
			if (isStatic && !methodStatic) {
				Logger.error(
						"[AbstractAttribute] The attribute " + name + " is not static (cannot be called on a class)");
			} else if (!isStatic && methodStatic) {
				Logger.error(
						"[AbstractAttribute] The attribute " + name + " is static (cannot be called on an object)");
			}
			// TODO vérifier les acces

		} else if (object instanceof ThisAssignment) {
			ThisAssignment thisAssignment = (ThisAssignment) object;
			ClassDeclaration cDecl = thisAssignment.getClassDeclaration();
			this.attribute = cDecl.getAttribute(name);
			if (this.attribute == null) {
				Logger.error(
						"[AbstractAttribute] The attribute " + name + " is not declared in class " + cDecl.getName());
			}
			// pas besoin de vérifier les accès puisqu'on est dans la classe

			// TODO eventuellement vérifier final OU rajouter collect dans AttributeAccess
			// et Assignement

		} else if (object instanceof ThisAccess) {
			ThisAccess thisAccess = (ThisAccess) object;
			ClassDeclaration cDecl = thisAccess.getClassDeclaration();
			this.attribute = cDecl.getAttribute(name);
			if (this.attribute == null) {
				Logger.error(
						"[AbstractAttribute] The attribute " + name + " is not declared in class " + cDecl.getName());
			}
			// pas besoin de vérifier les accès puisqu'on est dans la classe

			// TODO eventuellement vérifier final OU rajouter collect dans AttributeAccess
			// et Assignement

		} else {
			Logger.warning(object.getClass().toString());
			Logger.error("[AbstractAttribute] The attribute " + object.toString() + " is not an identifier");
		}

		// TODO : verifier les acces
		// comment savoir si on est dans le main, ou dans une classe lors de l'appel ?

		return true;
		// throw new SemanticsUndefinedException("Semantics collect is undefined in
		// AbstractAttribute.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO verifier acces
		return true;
		// throw new SemanticsUndefinedException("Semantics resolve is undefined in
		// AbstractAttribute.");
	}

	@Override
	public Type getType() {
		return attribute.getType();
		// throw new SemanticsUndefinedException("Semantics getType is undefined in
		// AbstractAttribute.");
	}

	@Override
	public String toString() {
		return this.object + "." + this.name;
	}

}
