package fr.n7.stl.minijava.ast;

public class SemanticsUndefinedException extends RuntimeException {

    private static final long serialVersionUID = -2755104271931162101L;

    public SemanticsUndefinedException(String message) {
        super(message);
    }
}