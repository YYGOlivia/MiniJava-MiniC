package fr.n7.stl.minijava.ast.instruction;

import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import fr.n7.stl.minijava.ast.Block;
import fr.n7.stl.minijava.ast.expression.Expression;
import fr.n7.stl.minijava.ast.instruction.declaration.clazz.MethodDeclaration;
import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.scope.SymbolTable;

public class Conditional implements Instruction {

    private Expression condition;
    private Block thenBranch;
    private Block elseBranch;

    @Override
    public String toString() {
        return "if (" + this.condition + " )" + this.thenBranch
                + ((this.elseBranch != null) ? (" else " + this.elseBranch) : "");
    }

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        SymbolTable thenScope = new SymbolTable(scope);
        SymbolTable elseScope = new SymbolTable(scope);
        boolean okCond = condition.collectAndPartialResolve(scope);
        boolean okThen = thenBranch.collectAndPartialResolve(thenScope);
        boolean okElse = (elseBranch == null) ? true : elseBranch.collectAndPartialResolve(elseScope);
        return okCond && okThen & okElse;
    }

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, MethodDeclaration container) {
        SymbolTable thenScope = new SymbolTable(scope);
        SymbolTable elseScope = new SymbolTable(scope);
        boolean okCond = condition.collectAndPartialResolve(scope);
        boolean okThen = thenBranch.collectAndPartialResolve(thenScope, container);
        boolean okElse = (elseBranch == null) ? true : elseBranch.collectAndPartialResolve(elseScope, container);
        return okCond && okThen & okElse;
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        boolean okCond = condition.completeResolve(scope);
        boolean okThen = thenBranch.completeResolve(scope);
        boolean okElse = (elseBranch == null) ? true : elseBranch.completeResolve(scope);
        return okCond && okThen & okElse;
    }

    @Override
    public boolean checkType() {
        Type condType = condition.getType();
        if (!(condType.equalsTo(AtomicType.BooleanType))) {
            Logger.error("[Conditional] Condition is of type " + condType
                    + "(expected BooleanType)");
        }
        boolean okThen = thenBranch.checkType();
        boolean okElse = (elseBranch == null) ? true : elseBranch.checkType();
        return okThen && okElse;
    }

    @Override
    public int allocateMemory(Register register, int offset) {
        thenBranch.allocateMemory(register, offset);
        if (elseBranch != null) {
            elseBranch.allocateMemory(register, offset);
        }
        return 0;
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        int num = factory.createLabelNumber();

        Fragment frag = factory.createFragment();
        frag.append(condition.getCode(factory));
        if (elseBranch != null) {
            // si cond fausse, on jump au else
            frag.add(factory.createJumpIf("sinon_conditionnelle" + num, 0));
        } else {
            // si pas de else, on saute à la fin
            frag.add(factory.createJumpIf("fin_conditionnelle_" + num, 0));
        }
        frag.append(thenBranch.getCode(factory));
        if (elseBranch != null) {
            frag.add(factory.createJump("fin_conditionnelle_" + num));
            Fragment elseCode = elseBranch.getCode(factory);
            elseCode.addPrefix("sinon_conditionnelle_" + num);
            frag.append(elseCode);
        }
        frag.addSuffix("fin_conditionnelle_" + num);
        return frag;
    }
}