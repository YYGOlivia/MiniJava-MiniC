package fr.n7.stl.minijava.ast.expression.allocation;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.assignable.AssignableExpression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ObjectAllocation implements AccessibleExpression, AssignableExpression {

	private String name;

	private List<AccessibleExpression> arguments;

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
		ClassDeclaration classDeclaration = (ClassDeclaration) scope.get(this.name);
		if (!classDeclaration.isConcrete()) {
			Logger.error("[ObjectAllocation] Class " + this.name + " is abstract and cannot be instantiated.");
		}
		// TODO: vérifier qu'un constructeur compatible existe

		boolean okArgs = this.arguments.stream().allMatch(arg -> arg.collectAndPartialResolve(scope));

		return okArgs;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in ObjectAllocation.");
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is undefined in ObjectAllocation.");
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in ObjectAllocation.");
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
