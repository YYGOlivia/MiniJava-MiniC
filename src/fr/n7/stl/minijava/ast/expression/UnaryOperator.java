package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMInstruction;
import fr.n7.stl.util.SemanticsUndefinedException;

public enum UnaryOperator {

    Negate,
    Opposite;

    @Override
    public String toString() {
        switch (this) {
            case Negate:
                return "!";
            case Opposite:
                return "-";
            default:
                throw new IllegalArgumentException("The default case should never be triggered.");
        }
    }

    public TAMInstruction toTAM() {
        switch (this) {
            case Negate:
                return Library.BNeg;
            case Opposite:
                return Library.INeg;
            default:
                throw new SemanticsUndefinedException("Unexpected binary operator: " + this);
        }
    }
}