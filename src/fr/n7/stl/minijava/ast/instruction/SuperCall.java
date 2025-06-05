package fr.n7.stl.minijava.ast.instruction;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.ClassType;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SuperCall implements Instruction {

	private ConstructorDeclaration constructor;

	private List<AccessibleExpression> arguments;

	private ClassDeclaration classDeclaration;

	public SuperCall(List<AccessibleExpression> arguments) {
		this.arguments = arguments;
	}

	public String getSignature(String className) {
		String paramstring = this.arguments.stream()
				.map(p -> p.getType().toString())
				.collect(Collectors.joining(","));
		return className + "(" + paramstring + ")";
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		Logger.error("[SuperCall] super constructor cannot be called outside a method or constructor.");
		return false;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		boolean okArgs = true;
		for (AccessibleExpression arg : this.arguments) {
			okArgs = okArgs && arg.collectAndPartialResolve(scope);
		}
		ParameterDeclaration obj = container.getParameters().get(0); //On récupère le this
		if (obj.getType() instanceof ClassType){
			Logger.error("[SuperCall] The first argument of " + container.getName() + " is not an instance of a class");
		}
		ClassType classType = (ClassType) obj.getType();
		//classDelaration -> la classe dans laquelle le constructeur est appelé
		classDeclaration = classType.getDeclaration();
		ClassDeclaration ancestor = classDeclaration.getAncestor();
		while (ancestor!=null && constructor==null){
			constructor = ancestor.findConstructor(getSignature(ancestor.getName()));
			ancestor = ancestor.getAncestor();
		}
		if (constructor==null){
			Logger.error("[SuperCall] The ancestors of class " + classDeclaration.getName() + " don't have any constructor matching the signature " + getSignature("super"));
		}
		return okArgs;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in SuperCall.");
	}

	@Override
	public boolean checkType() {
		boolean okLen = this.arguments.size() == this.constructor.getParams().size();
		if (!okLen) {
			Logger.error("[SuperCall] Wrong number of arguments for constructor "
					+ this.constructor.getName() + " call (expected " +
					this.constructor.getParams().size() + " got " +
					this.arguments.size() + ").");
		}

		boolean ok = true;
		for (int i = 0; i < arguments.size(); i++) {
			Type paramType = this.constructor.getParams().get(i).getType();
			Type argType = this.arguments.get(i).getType();
			ok = ok && argType.compatibleWith(paramType);
		}
		if (!ok) {
			List<String> paramString = this.constructor.getParams().stream()
					.map(x -> x.getType().toString()).collect(Collectors.toList());
			List<String> argString = this.arguments.stream().map(x -> x.getType().toString())
					.collect(Collectors.toList());
			Logger.error("[SuperCall] Wrong type of arguments for constructor " +
					this.constructor.getName() + " call (expected "
					+ paramString + " got " + argString + ").");
		}
		return ok && okLen;
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		//throw new SemanticsUndefinedException("Semantics allocateMemory is undefined in SuperCall.");
		// pas vraiment besoin d'allouer de la mémoire ? 
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		// appel constructeur 
		Fragment frag = factory.createFragment();
		frag.add(factory.createCall(constructor.getSignature(), Register.SB)); // Appel au constructeur
		return frag;
		//throw new SemanticsUndefinedException("Semantics getCode is undefined in SuperCall.");
	}

	@Override
	public String toString() {
		String image = "super(";
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
