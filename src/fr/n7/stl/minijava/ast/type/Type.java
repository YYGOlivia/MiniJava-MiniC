package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;

public interface Type {

    public boolean equalsTo(Type other);

    public boolean compatibleWith(Type other);

    public Type merge(Type other);

    public int length();

    public boolean completeResolve(HierarchicalScope<Declaration> scope);
}