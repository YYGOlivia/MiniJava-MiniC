package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

import fr.n7.stl.minijava.ast.SemanticsUndefinedException;
import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.type.Type;

public class MethodDeclaration implements Declaration {

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        throw new SemanticsUndefinedException("Semantics getType is undefined in MethodDeclaration.");
    }
}