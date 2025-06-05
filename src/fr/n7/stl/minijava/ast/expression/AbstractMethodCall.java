package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
import fr.n7.stl.util.Logger;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractMethodCall<ObjectKind extends Expression> implements Expression {

	private String name;

	protected MethodDeclaration declaration;

	protected ObjectKind target;

	private List<AccessibleExpression> arguments;

	public AbstractMethodCall(ObjectKind target, String name, List<AccessibleExpression> arguments) {
		this.target = target;
		this.name = name;
		this.setArguments(arguments);
	}

	public AbstractMethodCall(String name, List<AccessibleExpression> arguments) {
		this(null, name, arguments);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.knows(name)) {
			Logger.error("[AbstractMethodCall] The method " + name + " is not declared");
		}

		this.declaration = (MethodDeclaration) scope.get(name);
		boolean argsOk = getArguments().stream().allMatch(arg -> arg.collectAndPartialResolve(scope));
		if (target == null) {
			// Appel methode statique
			return argsOk;
		}
		boolean targetOk = target.collectAndPartialResolve(scope);
		return targetOk && argsOk;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		if (!scope.knows(name)) {
			Logger.error("[AbstractMethodCall] The method " + name + " is not declared");
		}

		if (scope.get(name) instanceof FunctionDeclaration) {
			FunctionDeclaration funDecl = ((FunctionDeclaration) scope.get(name));

		}

		this.declaration = (MethodDeclaration) scope.get(name);
		boolean argsOk = getArguments().stream().allMatch(arg -> arg.completeResolve(scope));
		if (target == null) {
			// Appel methode statique
			return argsOk;
		}
		boolean targetOk = target.completeResolve(scope);
		return targetOk && argsOk;
	}

	@Override
	public Type getType() {
		return declaration.getType();
	}

	@Override
	public String toString() {
		String image = "";
		if (this.target != null) {
			image += this.target + ".";
		}
		image += this.name + "(";
		Iterator<AccessibleExpression> iterator = this.getArguments().iterator();
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

	/**
	 * @return the arguments
	 */
	public List<AccessibleExpression> getArguments() {
		return arguments;
	}

	/**
	 * @param arguments the arguments to set
	 */
	public void setArguments(List<AccessibleExpression> arguments) {
		this.arguments = arguments;
	}

}
