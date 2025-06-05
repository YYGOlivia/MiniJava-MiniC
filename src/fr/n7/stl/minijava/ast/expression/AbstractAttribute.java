package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.AttributeDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.util.Logger;

public abstract class AbstractAttribute<ObjectKind extends Expression> implements Expression {

	private ObjectKind object;
	private String name;
	private AttributeDeclaration attribute;

	public AbstractAttribute(ObjectKind object, String name) {
		this.object = object;
		this.name = name;
	}

	public ObjectKind getObject() {
		return object;
	}

	public String getName() {
		return name;
	}

	public AttributeDeclaration getAttribute() {
		return attribute;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		object.collectAndPartialResolve(scope);
		if (!(object.getType() instanceof ClassType)) {
			Logger.error("[AbstractAttribute] The object " + object.toString() +
					" is not an instance of a class, its attribute " + name + " cannot be resolved.");
		}
		ClassType objType = (ClassType) object.getType();
		objType.completeResolve(scope);
		ClassDeclaration classDecl = objType.getDeclaration();

		// vérif que l'attribut existe
		this.attribute = classDecl.getAttribute(name);
		if (this.attribute == null) {
			Logger.error("[AbstractAttribute] The class " + classDecl.getName() +
					" has no attribute named " + name);
		}

		if (object instanceof AbstractThis && attribute.isStatic()) {
			Logger.error("[AbstractAttribute] Attribute " + name + "of class " +
					classDecl.getName() + " is static and cannot be accessed through \"this\".");
		}

		if (object instanceof AssignableExpression && attribute.isFinal()) {
			Logger.error("[AbstractAttribute] Attribute " + name + " of class " +
					classDecl.getName() + " is final and cannot be assigned.");
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
