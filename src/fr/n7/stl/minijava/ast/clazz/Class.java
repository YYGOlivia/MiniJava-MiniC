
package fr.n7.stl.minijava.ast.clazz;

import java.util.List;

import fr.n7.stl.minijava.ast.SemanticsUndefinedException;
import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class Class implements Type {

    private String name;
    private List<Attribute> attributes;
    private List<Method> methods;
    private List<Constructor> constructors;

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equalsTo(Type other) {
        if (!(other instanceof Class)) {
            return false;
        }
        Class otherClass = (Class) other;
        return this.name.equals(otherClass.getName());
    }

    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        throw new SemanticsUndefinedException("Semantics collect is undefined in Class.");
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        throw new SemanticsUndefinedException("Semantics resolve is undefined in Class.");
    }

    public boolean checkType() {
        throw new SemanticsUndefinedException("Semantics checkType is undefined in Class.");
    }

    @Override
    public boolean compatibleWith(Type other) {
        throw new SemanticsUndefinedException("Semantics compatibleWith is undefined in Class.");
    }

    @Override
    public Type merge(Type other) {
        throw new SemanticsUndefinedException("Semantics merge is undefined in Class.");
    }

    @Override
    public int length() {
        throw new SemanticsUndefinedException("Semantics length is undefined in Class.");
    }

    public Fragment getCode(TAMFactory factory) {
        throw new SemanticsUndefinedException("Semantics getCode is undefined in Class.");
    }
}