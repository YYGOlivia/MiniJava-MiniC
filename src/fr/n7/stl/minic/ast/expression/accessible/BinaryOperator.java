/**
 * 
 */
package fr.n7.stl.minic.ast.expression.accessible;

import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMInstruction;
import fr.n7.stl.util.SemanticsUndefinedException;

/**
 * Binary operators in the Bloc language.
 * 
 * @author Marc Pantel
 *
 */
public enum BinaryOperator {

	/**
	 * Numeric addition and String concatenation
	 */
	Add,
	Substract,
	Multiply,
	Divide,
	Modulo,
	Equals,
	Different,
	Greater,
	Lesser,
	And,
	Or,
	LesserOrEqual,
	GreaterOrEqual;

	@Override
	public String toString() {
		switch (this) {
			case Add:
				return "+";
			case And:
				return "&&";
			case Different:
				return "!=";
			case Divide:
				return "/";
			case Equals:
				return "==";
			case Greater:
				return ">";
			case GreaterOrEqual:
				return ">=";
			case Lesser:
				return "<";
			case LesserOrEqual:
				return "<=";
			case Modulo:
				return "%";
			case Multiply:
				return "*";
			case Or:
				return "||";
			case Substract:
				return "-";
			default:
				throw new IllegalArgumentException("The default case should never be triggered.");
		}
	}

	public TAMInstruction toTAM() {
		switch (this) {
			case Add:
				return Library.IAdd;
			case And:
				return Library.BAnd;
			case Different:
				return Library.INeq;
			case Divide:
				return Library.IDiv;
			case Equals:
				return Library.IEq;
			case Greater:
				return Library.IGtr;
			case GreaterOrEqual:
				return Library.IGeq;
			case Lesser:
				return Library.ILss;
			case LesserOrEqual:
				return Library.ILeq;
			case Modulo:
				return Library.IMod;
			case Multiply:
				return Library.IMul;
			case Or:
				return Library.BOr;
			case Substract:
				return Library.ISub;
			default:
				throw new SemanticsUndefinedException("Unexpected unary operator: " + this);
		}
	}
}
