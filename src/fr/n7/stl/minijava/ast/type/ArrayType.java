package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;

public class ArrayType implements Type {

    protected Type element;

    public ArrayType(Type element) {
        this.element = element;
    }

    @Override
    public boolean equalsTo(Type other) {
        if (!(other instanceof ArrayType)) {
            return false;
        }
        ArrayType otherArrayType = (ArrayType) other;
        return this.element.equalsTo(otherArrayType.element);

    }

    @Override
    public boolean compatibleWith(Type other) {
        if (!(other instanceof ArrayType)) {
            return false;
        }
        ArrayType otherArrayType = (ArrayType) other;
        return this.element.compatibleWith(otherArrayType.element);
    }

    @Override
    public Type merge(Type other) {
        if (!(other instanceof ArrayType)) {
            return AtomicType.ErrorType;
        }
        ArrayType otherArrayType = (ArrayType) other;
        Type mergedElement = this.element.merge(otherArrayType.element);
        return new ArrayType(this.element.merge(mergedElement));
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        return this.element.completeResolve(scope);
    }

    /**
     * @return Type of the elements in the array.
     */
    public Type getType() {
        return this.element;
    }
}