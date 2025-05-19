package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

public enum Modifier {

    Public,
    Private,
    Static,
    Abstract;

    @Override
    public String toString() {
        switch (this) {
            case Public:
                return "public";
            case Private:
                return "private";
            case Static:
                return "static";
            default:
                throw new IllegalArgumentException("The default case should never be triggered.");
        }
    }
}
