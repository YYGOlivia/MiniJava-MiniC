package fr.n7.stl.minijava.ast.instruction.declaration;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.type.Type;

public class ParameterDeclaration implements Declaration {

    private String name;

    private Type type;

    private int offset;

    public ParameterDeclaration(String name, Type type) {
        this.name = name;
        this.type = type;
        this.offset = -1; // This value should never occur...
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.type + " " + this.name;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    /**
     * Provide the offset of the formal parameter in the list of formal parameters
     * for the function
     *
     * @return Offset of the formal parameter
     */
    public int getOffset() {
        return this.offset;
    }

    /**
     * Set the offset of the formal parameter in the list of formal parameters for
     * the function
     *
     * @param offset Offset of the formal parameter
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }
}