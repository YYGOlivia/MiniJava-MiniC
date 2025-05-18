package fr.n7.stl.minijava.ast.expression;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public interface Expression {

    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope);

    public boolean completeResolve(HierarchicalScope<Declaration> scope);

    public Type getType();

    public Fragment getCode(TAMFactory factory);
}