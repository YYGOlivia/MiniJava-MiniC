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

	protected RecordKind record;
	protected String name;
	protected FieldDeclaration field;

	/**
	 * Construction for the implementation of a record field access expression
	 * Abstract Syntax Tree node.
	 * 
	 * @param _record Abstract Syntax Tree for the record part in a record field
	 *                access expression.
	 * @param _name   Name of the field in the record field access expression.
	 */
	public AbstractField(RecordKind _record, String _name) {
		this.record = _record;
		this.name = _name;
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
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> _scope) {
		boolean okRecord = this.record.collectAndPartialResolve(_scope);
		boolean okRecordType = this.record.getType().completeResolve(_scope);
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
	public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
		Type recordTrueType = NamedType.getTrueType(record);
		if (!(recordTrueType instanceof RecordType)) {
			Logger.error("[AbstractField] " + this.record.toString() + " is not a record type.");
			return false;
		}

		boolean okRecord = this.record.completeResolve(_scope);
		boolean okRecordType = this.record.getType().completeResolve(_scope);

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