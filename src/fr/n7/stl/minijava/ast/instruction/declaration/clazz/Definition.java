package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

import java.util.List;

import fr.n7.stl.minijava.ast.scope.Declaration;

public interface Definition extends Declaration {

    public List<Modifier> getModifiers();

}