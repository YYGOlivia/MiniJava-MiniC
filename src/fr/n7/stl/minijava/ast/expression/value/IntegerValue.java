package fr.n7.stl.minijava.ast.expression.value;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class IntegerValue implements Value {

    private int value;

    public IntegerValue(String text) {
        this.value = Integer.parseInt(text);
    }

    @Override
    public String toString() {
        return "" + this.value;
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
        return AtomicType.IntegerType;
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        Fragment frag = factory.createFragment();
        frag.add(factory.createLoadL(this.value));
        return frag;
    }
}