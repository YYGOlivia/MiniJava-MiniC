package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

import java.util.List;

import fr.n7.stl.minijava.ast.type.Type;

public class MethodDeclaration implements Definition {

    private String name;
    private Type type;
    private List<Modifier> modifiers;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public List<Modifier> getModifiers() {
        return this.modifiers;
    }
}