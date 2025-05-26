/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.Expression;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.SequenceType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract Syntax Tree node for an expression building a sequence of values.
 * 
 * @author Marc Pantel
 *
 */
public class Sequence implements AccessibleExpression {

	/**
	 * List of AST nodes of the expressions computing the values in the sequence.
	 */
	private List<AccessibleExpression> values;

	/**
	 * Builds an Abstract Syntax Tree node for an expression building a sequence of
	 * values.
	 * 
	 * @param values : List of AST nodes of the expressions computing the values in
	 *                the sequence.
	 */
	public Sequence(List<AccessibleExpression> values) {
		this.values = values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "{ ";
		Iterator<AccessibleExpression> iter = this.values.iterator();
		if (iter.hasNext()) {
			result += iter.next();
			while (iter.hasNext()) {
				result += " ," + iter.next();
			}
		}
		return result + " }";
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
		boolean result = true;
		for (Expression value : this.values) {
			result = result && value.collectAndPartialResolve(scope);
		}
		return result;
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
		boolean result = true;
		for (Expression value : this.values) {
			result = result && value.completeResolve(scope);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		SequenceType result = new SequenceType();
		for (Expression value : this.values) {
			result.add(value.getType());
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory factory) {
		Fragment fragment = factory.createFragment();
		for (Expression value : this.values) {
			fragment.append(value.getCode(factory));
		}
		return fragment;
	}

}
