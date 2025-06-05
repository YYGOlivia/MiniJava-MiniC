/**
 * 
 */
package fr.n7.stl.minic.ast.scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Implementation of a hierarchical scope using maps.
 * 
 * @author Marc Pantel
 *
 */
public class SymbolTable implements HierarchicalScope<Declaration> {

	private Map<String, Declaration> declarations;
	private Scope<Declaration> context;

	public SymbolTable() {
		this(null);
	}

	public SymbolTable(Scope<Declaration> context) {
		this.declarations = new HashMap<String, Declaration>();
		this.context = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.scope.Scope#get(java.lang.String)
	 */
	@Override
	public Declaration get(String name) {
		if (this.declarations.containsKey(name)) {
			return this.declarations.get(name);
		} else {
			if (this.context != null) {
				return this.context.get(name);
			} else {
				return null;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.scope.Scope#contains(java.lang.String)
	 */
	@Override
	public boolean contains(String name) {
		return (this.declarations.containsKey(name));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.scope.Scope#accepts(fr.n7.stl.block.ast.scope.
	 * Declaration)
	 */
	@Override
	public boolean accepts(Declaration declaration) {
		return (!this.contains(declaration.getName()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.scope.Scope#register(fr.n7.stl.block.ast.scope.
	 * Declaration)
	 */
	@Override
	public void register(Declaration declaration) {
		if (this.accepts(declaration)) {
			this.declarations.put(declaration.getName(), declaration);
		} else {
			throw new IllegalArgumentException("Cannot register declaration " + declaration.getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.scope.HierarchicalScope#knows(java.lang.String)
	 */
	@Override
	public boolean knows(String name) {
		if (this.contains(name)) {
			return true;
		} else {
			if (this.context != null) {
				if (this.context instanceof HierarchicalScope<?>) {
					return ((HierarchicalScope<?>) this.context).knows(name);
				} else {
					return this.context.contains(name);
				}
			} else {
				return false;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String local = "";
		if (this.context != null) {
			local += "Hierarchical definitions :\n" + this.context.toString();
		}
		local += "Local definitions : ";
		for (Entry<String, Declaration> entry : this.declarations.entrySet()) {
			local += entry.getKey() + " -> " + entry.getValue().toString() + "\n";
		}
		return local;
	}

}
