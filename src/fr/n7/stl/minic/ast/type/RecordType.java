/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.scope.Scope;
import fr.n7.stl.minic.ast.type.declaration.FieldDeclaration;
import fr.n7.stl.util.SemanticsUndefinedException;

/**
 * Implementation of the Abstract Syntax Tree node for a record type.
 * This one is a scope to allow an easy access to the fields.
 * 
 * @author Marc Pantel
 *
 */
public class RecordType implements Type, Declaration, Scope<FieldDeclaration> {

	private List<FieldDeclaration> fields;
	private String name;

	/**
	 * Constructor for a record type including fields.
	 * 
	 * @param name   Name of the record type.
	 * @param fields Sequence of fields to initialize the content of the record
	 *                type.
	 */
	public RecordType(String name, Iterable<FieldDeclaration> fields) {
		this.name = name;
		this.fields = new LinkedList<FieldDeclaration>();
		for (FieldDeclaration field : fields) {
			this.fields.add(field);
		}
	}

	/**
	 * Constructor for an empty record type (i.e. without fields).
	 * 
	 * @param name Name of the record type.
	 */
	public RecordType(String name) {
		this.name = name;
		this.fields = new LinkedList<FieldDeclaration>();
	}

	/**
	 * Add a field to a record type.
	 * 
	 * @paramfield The added field.
	 */
	public void add(FieldDeclaration field) {
		this.fields.add(field);
	}

	/**
	 * Add a sequence of fields to a record type.
	 * 
	 * @param fields : Sequence of fields to be added.
	 */
	public void addAll(Iterable<FieldDeclaration> fields) {
		for (FieldDeclaration field : fields) {
			this.fields.add(field);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type other) {
		if (!(other instanceof RecordType)) {
			return false;
		}
		RecordType otherRecord = ((RecordType) other);

		// il faut le même nombre de champs
		if (this.fields.size() != otherRecord.fields.size()) {
			return false;
		}
		Map<String, FieldDeclaration> otherFields = new HashMap<>();
		for (FieldDeclaration field : otherRecord.fields) {
			otherFields.put(field.getName(), field);
		}

		// il faut que tous les champs soient égaux 2 à 2
		boolean okFields = true;
		for (FieldDeclaration field : this.fields) {
			FieldDeclaration otherField = otherFields.get(field.getName());
			boolean okField = otherField != null
					&& field.getType().equalsTo(otherField.getType());
			okFields = okFields && okField;
		}
		return okFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type other) {
		if (!(other instanceof RecordType)) {
			return false;
		}
		RecordType otherRecord = ((RecordType) other);

		// il faut plus ou autant de champs que l'autre
		if (this.fields.size() < otherRecord.fields.size()) {
			return false;
		}

		// il faut que j'ai tous ses champs ET que mes champs soient compatibles avec
		// les siens du même nom
		Map<String, FieldDeclaration> thisFiedls = new HashMap<>();
		for (FieldDeclaration field : this.fields) {
			thisFiedls.put(field.getName(), field);
		}

		boolean okFields = true;
		for (FieldDeclaration field : otherRecord.fields) {
			FieldDeclaration thisField = thisFiedls.get(field.getName());
			boolean okField = thisField != null
					&& thisField.getType().compatibleWith(field.getType());
			okFields = okFields && okField;
		}
		return okFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type other) {
		throw new SemanticsUndefinedException("Semantics merge is undefined in RecordType.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Scope#get(java.lang.String)
	 */
	@Override
	public FieldDeclaration get(String name) {
		boolean found = false;
		Iterator<FieldDeclaration> iter = this.fields.iterator();
		FieldDeclaration current = null;
		while (iter.hasNext() && (!found)) {
			current = iter.next();
			found = found || current.getName().contentEquals(name);
		}
		if (found) {
			return current;
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Scope#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String name) {
		boolean result = false;
		Iterator<FieldDeclaration> iter = this.fields.iterator();
		while (iter.hasNext() && (!result)) {
			result = result || iter.next().getName().contentEquals(name);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Scope#accepts(fr.n7.stl.block.ast.Declaration)
	 */
	@Override
	public boolean accepts(FieldDeclaration declaration) {
		return !this.contains(declaration.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Scope#register(fr.n7.stl.block.ast.Declaration)
	 */
	@Override
	public void register(FieldDeclaration declaration) {
		if (this.accepts(declaration)) {
			this.fields.add(declaration);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Build a sequence type by erasing the names of the fields.
	 * 
	 * @return Sequence type extracted from record fields.
	 */
	public SequenceType erase() {
		SequenceType local = new SequenceType();
		for (FieldDeclaration field : this.fields) {
			local.add(field.getType());
		}
		return local;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Type#length()
	 */
	@Override
	public int length() {
		int length = 0;
		for (FieldDeclaration f : this.fields) {
			length += f.getType().length();
		}
		return length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "struct " + this.name + " { ";
		Iterator<FieldDeclaration> iter = this.fields.iterator();
		if (iter.hasNext()) {
			result += iter.next();
			while (iter.hasNext()) {
				result += " " + iter.next();
			}
		}
		return result + "}";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		boolean result = true;
		int off = 0;
		for (FieldDeclaration f : this.fields) {
			result = result && f.getType().completeResolve(scope);
			off += f.computeOffset(off);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.scope.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.scope.Declaration#getType()
	 */
	@Override
	public Type getType() {
		return this;
	}
}
