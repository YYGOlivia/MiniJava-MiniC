
package fr.n7.stl.minijava.ast.instruction.declaration.clazz;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ClassDeclaration implements Type, Declaration {

    private String name;
    private Modifier mod;
    private String parentName;
    ClassDeclaration parentClass;

    /**
     * Attributes of the class
     */
    private List<AttributeDeclaration> attributes = new LinkedList<>();

    /**
     * <code>methods.get("foo")</code> is a list of methods with the same name "foo"
     */
    private Map<String, List<MethodDeclaration>> methods = new HashMap<>();

    /**
     * Constructors of the class
     */
    private List<ConstructorDeclaration> constructors = new LinkedList<>();

    public ClassDeclaration(String name, String parentName, Modifier mod, List<Definition> defs) {
        this.name = name;
        this.mod = mod;
        this.parentName = parentName;

        for (Definition def : defs) {
            if (def instanceof AttributeDeclaration) {
                this.attributes.add((AttributeDeclaration) def);
            } else if (def instanceof MethodDeclaration) {
                MethodDeclaration method = (MethodDeclaration) def;
                String methodName = method.getName();
                if (!this.methods.containsKey(methodName)) {
                    this.methods.put(methodName, new LinkedList<>());
                }
                this.methods.get(methodName).add(method);

            } else if (def instanceof ConstructorDeclaration) {
                this.constructors.add((ConstructorDeclaration) def);
            } else {
                throw new SemanticsUndefinedException(
                        "Unknown Definition type in ClassDeclaration: " + def.getClass().getName());
            }
        }
    }

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