package fr.n7.stl.minijava.ast.scope;

public interface Scope<D extends Declaration> {

    public D get(String name);

    public boolean contains(String name);

    public boolean accepts(D declaration);

    public void register(D declaration);
}
