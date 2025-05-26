package fr.n7.stl.minic.ast.expression;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.NamedType;
import fr.n7.stl.minic.ast.type.RecordType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.minic.ast.type.declaration.FieldDeclaration;
import fr.n7.stl.util.Logger;

/**
 * Common elements between left (Assignable) and right (Expression) end sides of
 * assignments. These elements
 * share attributes, toString and getType methods.
 * 
 * @author Marc Pantel
 *
 */
public abstract class AbstractField<RecordKind extends Expression> implements Expression {

	private RecordKind record;
	private String name;
	private FieldDeclaration field;

	/**
	 * Construction for the implementation of a record field access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param record Abstract Syntax Tree for the record part in a record field
	 *                access expression.
	 * @param name   Name of the field in the record field access expression.
	 */
	public AbstractField(RecordKind record, String name) {
		this.record = record;
		this.name = name;
	}

	public RecordKind getRecord() {
		return this.record;
	}

	public FieldDeclaration getField() {
		return this.field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.record + "." + this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#collect(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		boolean okRecord = this.record.collectAndPartialResolve(scope);
		boolean okRecordType = this.record.getType().completeResolve(scope);
		Type recordTrueType = NamedType.getTrueType(record);

		if (!(recordTrueType instanceof RecordType)) {
			Logger.error("[AbstractField] " + this.record.toString() + " is not a record type.");
			return false;
		}

		RecordType recordType = (RecordType) recordTrueType;
		field = recordType.get(this.name);
		if (field == null) {
			Logger.error("[AbstractField] " + this.name + " is not a field of record type " + recordType.getName());
			return false;
		}
		return okRecord && okRecordType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.expression.Expression#resolve(fr.n7.stl.block.ast.scope.
	 * HierarchicalScope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		Type recordTrueType = NamedType.getTrueType(record);
		if (!(recordTrueType instanceof RecordType)) {
			Logger.error("[AbstractField] " + this.record.toString() + " is not a record type.");
			return false;
		}

		boolean okRecord = this.record.completeResolve(scope);
		boolean okRecordType = this.record.getType().completeResolve(scope);

		RecordType recordType = (RecordType) recordTrueType;
		field = recordType.get(this.name);
		if (field == null) {
			Logger.error("[AbstractField] " + this.name + " is not a field of record type " + recordType.getName());
			return false;
		}
		return okRecord && okRecordType;
	}

	/**
	 * Synthesized Semantics attribute to compute the type of an expression.
	 * 
	 * @return Synthesized Type of the expression.
	 */
	public Type getType() {
		return this.field.getType();
	}

}