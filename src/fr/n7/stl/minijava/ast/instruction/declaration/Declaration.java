package fr.n7.stl.minijava.ast.instruction.declaration;

import fr.n7.stl.minijava.ast.type.Type;

public interface Declaration {

    /**
     * Provide the identifier (i.e. name) given to the declaration.
     *
     * @return Name of the declaration.
     */
    public String getName();

    /**
     * Provide the type given to the declaration.
     *
     * @return Type of the declaration.
     */
    public Type getType();
}