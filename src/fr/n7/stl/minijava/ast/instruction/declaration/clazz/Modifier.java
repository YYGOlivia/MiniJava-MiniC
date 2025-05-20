package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

public enum Modifier {

    PUBLIC,
    ABSTRACT,
    STATIC,
    FINAL,
    PROTECTED,
    PRIVATE;

    @Override
    public String toString() {
        switch (this) {
            case PUBLIC:
                return "public";
            case ABSTRACT:
                return "abstract";
            case STATIC:
                return "static";
            case FINAL:
                return "final";
            case PROTECTED:
                return "protected";
            case PRIVATE:
                return "private";
            default:
                throw new IllegalArgumentException("The default case should never be triggered.");
        }
    }
}
