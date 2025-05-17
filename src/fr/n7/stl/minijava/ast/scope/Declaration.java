package fr.n7.stl.minijava.ast.scope;

import fr.n7.stl.minijava.ast.type.Type;

public interface Declaration {

    public String getName();

    public Type getType();
}