package fr.n7.stl.minijava.ast.expression.value;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public enum BooleanValue implements Value {

    True,
    False;

    public String toString() {
        switch (this) {
            case False:
                return "false";
            case True:
                return "true";
            default:
                throw new IllegalArgumentException("The default case should never be triggered.");
        }
    }

    @Override
    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        return true;
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        return true;
    }

    @Override
    public Type getType() {
        return AtomicType.BooleanType;
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        Fragment frag = factory.createFragment();
        switch (this) {
            case True:
                frag.add(factory.createLoadL(1));
                break;
            case False:
                frag.add(factory.createLoadL(0));
                break;
        }
        return frag;
    }
}