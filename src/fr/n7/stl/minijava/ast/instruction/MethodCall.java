package fr.n7.stl.minijava.ast.instruction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import fr.n7.stl.minic.ast.expression.FunctionCall;
import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.expression.accessible.IdentifierAccess;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ElementKind;
import fr.n7.stl.minijava.ast.type.declaration.MethodDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class MethodCall implements Instruction {

	private AccessibleExpression target;

	private String name;

	private MethodDeclaration method;

	private List<AccessibleExpression> arguments;

	private FunctionCall function;

	public MethodCall(AccessibleExpression target, String name, List<AccessibleExpression> arguments) {
		this.name = name;
		this.target = target;
		this.arguments = arguments;
	}

	public MethodCall(String name, List<AccessibleExpression> arguments) {
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
				this.method = (MethodDeclaration) scope.get(name);
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
		if (methods.isEmpty()) {
			Logger.error("[MethodCall] The class " + classDecl.getName() + " does not have a method named " + name
					+ " with " + this.arguments.size() + " parameters");
		}

		MethodDeclaration equalMethod = null; // méthode avec les mêmes types de paramètres
		MethodDeclaration compatibleMethod = null; // méthode avec des types compatibles
		for (MethodDeclaration m : methods) {
			boolean equalTypes = true;
			boolean compatibleTypes = true;
			for (int i = 0; i < this.arguments.size(); i++) {
				Type funcParamType = m.getParameters().get(i).getType();
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
			Logger.error("[MethodCall] The class " + classDecl.getName() + " does not have a method named "
					+ name + " compatible with the arguments " + argString);
		}
		this.method = equalMethod != null ? equalMethod : compatibleMethod;

		boolean methodStatic = method.getElementKind() == ElementKind.CLASS;
		if (isStatic && !methodStatic) {
			Logger.error("[MethodCall] The method " + name + " is not static (cannot be called on a class)");
		} else if (!isStatic && methodStatic) {
			Logger.error("[MethodCall] The method " + name + " is static (cannot be called on an object)");
		}
		// TODO vérifier les acces
		FunctionDeclaration fDecl = method.getFunction();
		scope.register(fDecl);
		List<AccessibleExpression> params = new ArrayList<>(
				arguments);
		params.add(0, target);
		this.function = new FunctionCall(fDecl.getName(), arguments);
		function.collectAndPartialResolve(scope);
		Logger.warning(scope.toString());

		return okArgs;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		throw new SemanticsUndefinedException("Semantics collect is undefined in MethodCall.");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in MethodCall.");
	}

	@Override
	public boolean checkType() {
		// vérifier le type de this.function si != null
		throw new SemanticsUndefinedException("Semantics checkType is undefined in MethodCall.");
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		//throw new SemanticsUndefinedException("Semantics allocateMemory is undefined in MethodCall.");
		// pas vraiment besoin d'allouer de la mémoire ? 
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		throw new SemanticsUndefinedException("Semantics getCode is undefined in MethodCall.");
	}

	@Override
	public String toString() {
		String image = "";
		if (this.target != null) {
			image += target + ".";
		}
		image += this.name + "(";
		Iterator<AccessibleExpression> iterator = this.arguments.iterator();
		if (iterator.hasNext()) {
			AccessibleExpression argument = iterator.next();
			image += argument;
			while (iterator.hasNext()) {
				argument = iterator.next();
				image += " ," + argument;
			}
		}
		image += ");\n";
		return image;
	}

}
