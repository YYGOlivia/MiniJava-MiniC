package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

import java.util.List;

import fr.n7.stl.minijava.ast.type.Type;

public class ConstructorDeclaration implements Definition {

    private String name;
    private Type type;
    /**
     * Un seul modificateur à la fois (cf syntaxe)
     */
    private Modifier modifier;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public List<Modifier> getModifiers() {
        return List.of(modifier);
    }
}