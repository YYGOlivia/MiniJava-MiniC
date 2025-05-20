package fr.n7.stl.minijava.ast.instruction;

import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.expression.Expression;
import fr.n7.stl.minijava.ast.instruction.declaration.clazz.MethodDeclaration;
import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.TAMInstruction;

public class Printer implements Instruction {

    private Expression parameter;

    public Printer(Expression value) {
        this.parameter = value;
    }

    @Override
    public String toString() {
        return "print " + this.parameter + ";\n";
    }

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        return this.parameter.collectAndPartialResolve(scope);
    }

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, MethodDeclaration container) {
        return this.parameter.collectAndPartialResolve(scope);
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        return this.parameter.completeResolve(scope);
    }

    @Override
    public boolean checkType() {
        return true;
    }

    @Override
    public int allocateMemory(Register resgister, int offset) {
        return 0;
    }

    private TAMInstruction getRightOut(AtomicType atomicType) {
        switch (atomicType) {
            case BooleanType:
                return Library.BOut;
            case IntegerType:
                return Library.IOut;
            case CharacterType:
                return Library.COut;
            case StringType:
                return Library.SOut;
            default:
                // Aucune idee de ce qu'on fait là
                return Library.IOut;
        }
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        Fragment frag = factory.createFragment();
        Type type = parameter.getType();
        if (type instanceof AtomicType) {
            AtomicType atomicType = (AtomicType) type;
            frag.append(parameter.getCode(factory));
            frag.add(getRightOut(atomicType));
        } else {
            // pour print toutes les valeurs dans l'ordre inverse -> <2,3> sera affiché 3 2
            for (int i = 0; i < type.length(); i++) {
                frag.add(Library.IOut);
                frag.add(factory.createLoadL(' '));
                frag.add(Library.COut);
            }
        }

        frag.add(factory.createLoadL(' '));
        frag.add(Library.COut);
        return frag;
    }
}
