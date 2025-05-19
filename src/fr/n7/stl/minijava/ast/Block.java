package fr.n7.stl.minijava.ast;

import java.util.List;

import fr.n7.stl.minijava.ast.instruction.Instruction;
import fr.n7.stl.minijava.ast.instruction.declaration.clazz.MethodDeclaration;
import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.scope.SymbolTable;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class Block {

    private List<Instruction> instructions;

    private int offset;

    @Override
    public String toString() {
        String local = "";
        for (Instruction instruction : this.instructions) {
            local += instruction;
        }
        return "{\n" + local + "}\n";
    }

    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        boolean ok = true;
        SymbolTable newScope = new SymbolTable(scope);
        for (Instruction instruction : instructions) {
            ok = ok && instruction.collectAndPartialResolve(newScope);
        }
        return ok;
    }

    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, MethodDeclaration container) {
        boolean ok = true;
        SymbolTable newScope = new SymbolTable(scope);
        for (Instruction instruction : instructions) {
            ok = ok && instruction.collectAndPartialResolve(newScope, container);
        }
        return ok;
    }

    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        boolean ok = true;
        SymbolTable newScope = new SymbolTable(scope);
        for (Instruction instruction : instructions) {
            ok = ok && instruction.completeResolve(newScope);
        }
        return ok;
    }

    public boolean checkType() {
        boolean ok = true;
        for (Instruction instruction : instructions) {
            ok = ok && instruction.checkType();
        }
        return ok;
    }

    public void allocateMemory(Register register, int offset) {
        int off = offset;
        for (Instruction instruction : instructions) {
            instruction.allocateMemory(register, offset);
        }
        this.offset = off;
    }

    public Fragment getCode(TAMFactory factory) {
        Fragment fragment = factory.createFragment();
        for (Instruction instruction : instructions) {
            fragment.append(instruction.getCode(factory));
        }
        return fragment;
    }
}