package fr.n7.stl.minijava;

import fr.n7.stl.minijava.ast.Block;
import fr.n7.stl.minijava.ast.scope.SymbolTable;
import fr.n7.stl.minijava.parser.MiniJavaParserBaseListener;

public class ASTBuilder extends MiniJavaParserBaseListener {

    private String output_path;
    private Block mainBlock;
    private String name;

    public ASTBuilder(String output) {
        this.output_path = output;
    }

    public void startCompilation(boolean generateCode) {
        System.out.println(this.name + " " + this.mainBlock);
        SymbolTable tds = new SymbolTable();

        // if (!this.mainBlock.collectAndPartialResolve(tds)) {
        // System.out.println("Collect failed : " + tds);
        // return;
        // }
        // System.out.println("Collect succeeded.");

        // if (!this.mainBlock.completeResolve(tds)) {
        // System.out.println("Resolve failed : " + tds);
        // return;
        // }
        // System.out.println("Resolve Succeeded.");

        // if (!this.mainBlock.checkType()) {
        // System.out.println("Type verification failed.");
        // return;
        // }
        // System.out.println("Type verification succeeded.");

        // if (!generateCode) {
        // System.out.println("Skipping code generation.");
        // return;
        // }

        // System.out.println("Code generation ...");
        // this.mainBlock.allocateMemory(Register.SB, 0);
        // try {
        // PrintWriter writer = new PrintWriter(output_path);
        // TAMFactory factory = new TAMFactoryImpl();
        // Fragment f = this.mainBlock.getCode(factory);
        // f.add(factory.createHalt());
        // f.append(this.mainBlock.getFunctions(factory));
        // writer.println(f);
        // writer.close();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // System.out.println("Code generation finished.");
    }
}
