package fr.n7.stl.minijava.ast.instruction;

import fr.n7.stl.minijava.ast.instruction.declaration.clazz.MethodDeclaration;
import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface Instruction {

    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope);

    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope, MethodDeclaration container);

    public boolean completeResolve(HierarchicalScope<Declaration> scope);

    public boolean checkType();

    public int allocateMemory(Register register, int offset);

    public Fragment getCode(TAMFactory factory);
}