package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclarationI;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

public class AttributeDeclaration extends ClassElement implements VariableDeclarationI {

	private Type type;
	private boolean isFinal;
	private Expression value;

	public AttributeDeclaration(String name, Type type, boolean isFinal, Expression value) {
		super(name);
		this.type = type;
		this.isFinal = isFinal;
		this.value = value;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean okType = this.type.completeResolve(scope);
		boolean okValue = (value == null) || value.collectAndPartialResolve(scope);
		return okType && okValue;
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		throw new SemanticsUndefinedException("Semantics resolve is undefined in AttributeDeclaration.");
	}

	@Override
	public boolean checkType() {
		if (this.value == null) {
			return true;
		}
		// check compatibility
		Type valueType = this.value.getType();
		if (!this.type.compatibleWith(valueType)) {
			Logger.error("[AttributeDeclaration] The type " + valueType +
					" is not compatible with the declared type of " +
					this.getName() + " (" + this.type + ").");
		}
		return true;

	}

	@Override
	public int allocateMemory(Register register, int offset) {
		// register utile uniquement si static (static -> dans classe)
		this.register = register;
		this.offset = offset;
		return type.length();
	}

	@Override
	public Type getType() {
		return this.type;
	}

	public boolean isFinal() {
		return this.isFinal;
	}

	public Expression getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return this.getAccessRight() + " " + this.getElementKind() + " " + type + " " + this.getName() + ";\n";
	}
}
