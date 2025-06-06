package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.expression.FunctionCall;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.accessible.IdentifierAccess;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
import fr.n7.stl.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractMethodCall<ObjectKind extends Expression> implements Expression {

	private String name;

	protected MethodDeclaration declaration;

	protected ObjectKind target;

	private List<AccessibleExpression> arguments;

	private FunctionCall function;

	public AbstractMethodCall(ObjectKind target, String name, List<AccessibleExpression> arguments) {
		this.target = target;
		this.name = name;
		this.arguments = arguments;
	}

	public AbstractMethodCall(String name, List<AccessibleExpression> arguments) {
		this(null, name, arguments);
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean okArgs = arguments.stream().allMatch(a -> a.collectAndPartialResolve(scope));
		if (target == null) {
			// methode statique
			if (!scope.knows(name)) {
				Logger.error("[MethodCall] The method " + name + " is not defined");
			}
			if (scope.get(name) instanceof FunctionDeclaration) {
				// Appel sur une fonction du Main, c'est pas une FunctionDeclaration
				this.function = new FunctionCall(name, arguments);
				this.function.collectAndPartialResolve(scope);
			} else {
				this.declaration = (MethodDeclaration) scope.get(name);
			}
			// Pas besoin vérifier statique car si dans le scope elle est soit statique soit
			// on est dans la classe
			return okArgs;
		}

		target.collectAndPartialResolve(scope);
		if (!(target instanceof IdentifierAccess)) {
			Logger.error("[MethodCall] The object " + target.toString() + " is not an identifier");
		}

		IdentifierAccess id = (IdentifierAccess) target;
		boolean isStatic = id.getExpression() == null;
		Declaration cDecl;
		if (isStatic) {
			cDecl = scope.get(id.getName());
		} else {
			cDecl = scope.get(id.getExpression().getDeclaration().getType().toString());
		}
		if (!(cDecl instanceof ClassDeclaration)) {
			Logger.error("[MethodCall] The object " + target.toString() + " is not an instance of a class");
		}

		ClassDeclaration classDecl = (ClassDeclaration) cDecl;
		List<MethodDeclaration> methods = classDecl.getMethods(name, this.arguments.size());

		MethodDeclaration equalMethod = null; // méthode avec les mêmes types de paramètres
		MethodDeclaration compatibleMethod = null; // méthode avec des types compatibles
		for (MethodDeclaration m : methods) {
			if (m.getParams().size() != this.arguments.size()) {
				continue; // le nombre de paramètres ne correspond pas
			}
			boolean equalTypes = true;
			boolean compatibleTypes = true;
			for (int i = 0; i < this.arguments.size(); i++) {
				Type funcParamType = m.getParams().get(i).getType();
				Type argType = this.arguments.get(i).getType();
				equalTypes = equalTypes && argType.equalsTo(funcParamType);
				compatibleTypes = compatibleTypes && argType.compatibleWith(funcParamType);
			}
			if (equalTypes) {
				equalMethod = m;
			}
			if (compatibleTypes) {
				compatibleMethod = m;
			}
		}
		// Erreur si aucune méthode trouvée
		if (equalMethod == null && compatibleMethod == null) {
			List<String> argString = this.arguments.stream()
					.map(x -> x.getType().toString()).collect(Collectors.toList());
			Logger.error("[MethodCall] The class " + classDecl.getName() + " does not have a declaration named "
					+ name + " compatible with the arguments " + argString);
		}
		this.declaration = equalMethod != null ? equalMethod : compatibleMethod;

		if (isStatic && !declaration.isStatic()) {
			Logger.error("[MethodCall] The method " + name + " is not static (cannot be called on a class)");
		} else if (!isStatic && declaration.isStatic()) {
			Logger.error("[MethodCall] The method " + name + " is static (cannot be called on an object)");
		}
		// TODO vérifier les acces
		FunctionDeclaration fDecl = declaration.getFunction();
		scope.register(fDecl);
		List<AccessibleExpression> params = new ArrayList<>(
				arguments);
		params.add(0, (AccessibleExpression) target);
		this.function = new FunctionCall(fDecl.getName(), arguments);
		function.collectAndPartialResolve(scope);

		return okArgs;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean targetOk = target == null ? true : target.completeResolve(scope);

		String forType = target == null ? "" : (" for class " + target.getType());
		if (!scope.knows(name)) {
			Logger.error("[AbstractMethodCall] The method " + name + " is not declared" + forType);
		}

		if (scope.get(name) instanceof FunctionDeclaration) {
			FunctionDeclaration funDecl = ((FunctionDeclaration) scope.get(name));
		}

		this.declaration = (MethodDeclaration) scope.get(name);
		boolean argsOk = arguments.stream().allMatch(arg -> arg.completeResolve(scope));
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

}
