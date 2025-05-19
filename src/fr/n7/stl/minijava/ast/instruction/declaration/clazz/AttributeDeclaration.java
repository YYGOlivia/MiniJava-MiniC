package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.type.Type;

public class AttributeDeclaration implements Declaration {

    private String name;
    private Type type;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }
}