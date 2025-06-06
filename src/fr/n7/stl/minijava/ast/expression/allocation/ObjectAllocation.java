package fr.n7.stl.minijava.ast.expression.allocation;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ObjectAllocation implements AccessibleExpression, AssignableExpression {

	private String name;

	private List<AccessibleExpression> arguments;
	
	private ConstructorDeclaration constructor;

	private ClassType type;

	private ConstructorDeclaration constructor;

	public ObjectAllocation(String name, List<AccessibleExpression> arguments) {
		this.name = name;
		this.arguments = arguments;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.knows(this.name)) {
			Logger.error("[ObjectAllocation] Class " + this.name + " is not known in scope.");
		}

		if (!(scope.get(this.name) instanceof ClassDeclaration)) {
			Logger.error("[ObjectAllocation] " + this.name + " is not a class.");
		}

		ClassDeclaration classDecl = (ClassDeclaration) scope.get(this.name);
		if (!classDecl.isConcrete()) {
			Logger.error("[ObjectAllocation] Class " + this.name + " is abstract and cannot be instantiated.");
		}
		if (this.type == null) {
			ClassType newType = new ClassType(name);
			newType.setDeclaration(classDecl);
			this.type = newType;
		}

		boolean okArgs = this.arguments.stream().allMatch(arg -> arg.collectAndPartialResolve(scope));

		// trouver un constructeur compatible
		ConstructorDeclaration equalConstr = null; // méthode avec les mêmes types de paramètres
		ConstructorDeclaration compatibleConstr = null; // méthode avec des types compatibles
		for (ConstructorDeclaration c : classDecl.getConstructors()) {
			if (c.getParams().size() != this.arguments.size()) {
				continue; // le nombre de paramètres ne correspond pas
			}
			boolean equalTypes = true;
			boolean compatibleTypes = true;
			for (int i = 0; i < this.arguments.size(); i++) {
				Type funcParamType = c.getParams().get(i).getType();
				Type argType = this.arguments.get(i).getType();
				equalTypes = equalTypes && argType.equalsTo(funcParamType);
				compatibleTypes = compatibleTypes && argType.compatibleWith(funcParamType);
			}
			if (equalTypes) {
				equalConstr = c;
			}
			if (compatibleTypes) {
				compatibleConstr = c;
			}
		}
		if (equalConstr == null && compatibleConstr == null) {
			List<String> argString = this.arguments.stream()
					.map(x -> x.getType().toString()).collect(Collectors.toList());
			Logger.error("[ObjectAllocation] The class " + classDecl.getName() +
					" does not have a constructor compatible with the arguments " + argString);
		}
		this.constructor = equalConstr != null ? equalConstr : compatibleConstr;

		return okArgs;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {

		boolean okArgs = this.arguments.stream().allMatch(arg -> arg.completeResolve(scope));
		return okArgs;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragObjAll = factory.createFragment();
		for (AccessibleExpression arg : this.arguments) {
			fragObjAll.append(arg.getCode(factory));
		}
		fragObjAll.add(factory.createLoadL(((ClassType) this.type).getDeclaration().getObjectSize()));
		fragObjAll.add(Library.MAlloc);
		fragObjAll.add(factory.createCall(this.getConstructorSignature(), Register.SB));
		return fragObjAll;
//		throw new SemanticsUndefinedException("Semantics getCode is undefined in ObjectAllocation.");
	}

	private String getConstructorSignature() {
		if (this.constructor == null) {
		String paramstring = this.arguments.stream()
				.map(p -> p.getType().toString())
				.collect(Collectors.joining(","));
		return this.name + "(" + paramstring + ")";
		}
		return this.constructor.getSignature();
	}
	
	@Override
	public String toString() {
		String image = "";
		image += "new " + this.name + "(";
		Iterator<AccessibleExpression> iterator = this.arguments.iterator();
		if (iterator.hasNext()) {
			AccessibleExpression argument = iterator.next();
			image += argument;
			while (iterator.hasNext()) {
				argument = iterator.next();
				image += " ," + argument;
			}
		}
		image += ")";
		return image;
	}

}
