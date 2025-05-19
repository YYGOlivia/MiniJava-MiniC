
package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

import java.util.List;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ClassDeclaration implements Type, Declaration {

    private String name;
    private List<AttributeDeclaration> attributes;
    private List<MethodDeclaration> methods;
    private List<ConstructorDeclaration> constructors;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return this;
    }

    @Override
    public boolean equalsTo(Type other) {
        if (!(other instanceof ClassDeclaration)) {
            return false;
        }
        ClassDeclaration otherClassDeclaration = (ClassDeclaration) other;
        return this.name.equals(otherClassDeclaration.getName());
    }

    public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
        throw new SemanticsUndefinedException("Semantics collect is undefined in ClassDeclaration.");
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        throw new SemanticsUndefinedException("Semantics resolve is undefined in ClassDeclaration.");
    }

    public boolean checkType() {
        throw new SemanticsUndefinedException("Semantics checkType is undefined in ClassDeclaration.");
    }

    @Override
    public boolean compatibleWith(Type other) {
        throw new SemanticsUndefinedException("Semantics compatibleWith is undefined in ClassDeclaration.");
    }

    @Override
    public Type merge(Type other) {
        throw new SemanticsUndefinedException("Semantics merge is undefined in ClassDeclaration.");
    }

    @Override
    public int length() {
        throw new SemanticsUndefinedException("Semantics length is undefined in ClassDeclaration.");
    }

    public Fragment getCode(TAMFactory factory) {
        throw new SemanticsUndefinedException("Semantics getCode is undefined in ClassDeclaration.");
    }
}