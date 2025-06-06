package fr.n7.stl.minic.ast.instruction.declaration;

import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.tam.ast.Register;

public interface VariableDeclarationI extends Declaration {

    @Override
    public String toString();

    @Override
    public Type getType();

    @Override
    public String getName();

    public int getOffset();

    public Register getRegister();
}