package fr.n7.stl.minijava;

import fr.n7.stl.minijava.ast.Block;

public class ASTBuilder {

    private String output_path;
    private Block mainBlock;
    private String name;

    public ASTBuilder(String output) {
        this.output_path = output;
    }
}
