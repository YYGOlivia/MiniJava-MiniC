package fr.n7.stl.minijava.ast.instruction;

import fr.n7.stl.minic.ast.expression.accessible.AccessibleExpression;
import fr.n7.stl.minic.ast.instruction.Instruction;
import fr.n7.stl.minic.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minijava.ast.type.declaration.ConstructorDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ThisCall implements Instruction {

	private ConstructorDeclaration constructor;

	private List<AccessibleExpression> arguments;

	public ThisCall(List<AccessibleExpression> arguments) {
		this.arguments = arguments;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean okArgs = true;
		for (AccessibleExpression arg : this.arguments) {
			okArgs = okArgs && arg.collectAndPartialResolve(scope);
		}
		return okArgs;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, FunctionDeclaration container) {
		boolean okArgs = true;
		for (AccessibleExpression arg : this.arguments) {
			okArgs = okArgs && arg.collectAndPartialResolve(scope);
		}
		return okArgs;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean okArgs = true;
		for (AccessibleExpression arg : this.arguments) {
			okArgs = okArgs && arg.completeResolve(scope);
		}
		return okArgs;
	}

	@Override
	public boolean checkType() {
		boolean okLen = this.arguments.size() == this.constructor.getParams().size();
		if (!okLen) {
			Logger.error("[ThisCall] Wrong number of arguments for constructor "
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
			Logger.error("[ThisCall] Wrong type of arguments for constructor " +
					this.constructor.getName() + " call (expected "
					+ paramString + " got " + argString + ").");
		}
		return ok && okLen;
	}

	@Override
	public int allocateMemory(Register register, int offset) {
		//throw new SemanticsUndefinedException("Semantics allocateMemory is undefined in ThisCall.");
		// pas vraiment besoin d'allouer de la mémoire ? 
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory factory) {
		// appel constructeur 
		Fragment frag = factory.createFragment();
		frag.add(factory.createCall(constructor.getSignature(), Register.SB)); // Appel au constructeur
		return frag;
		//throw new SemanticsUndefinedException("Semantics getCode is undefined in ThisCall.");
	}

	@Override
	public String toString() {
		String image = "this(";
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
