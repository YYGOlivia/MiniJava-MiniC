package fr.n7.stl.minijava.ast.scope;

public interface HierarchicalScope<D extends Declaration> extends Scope<D> {

    public boolean knows(String name);
}