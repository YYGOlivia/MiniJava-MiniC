package fr.n7.stl.minijava.ast.type;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;

public enum AtomicType implements Type {
    BooleanType,
    CharacterType,
    FloatingType,
    IntegerType,
    StringType,
    VoidType,
    NullType,
    ErrorType;

    @Override
    public boolean equalsTo(Type other) {
        return this == other;
    }

    @Override
    public boolean compatibleWith(Type other) {
        if (this.equalsTo(other)) {
            return true;
        }

        switch (this) {
            case NullType:
                return (other != ErrorType && other != VoidType);
            case IntegerType:
                return (other == FloatingType);
            default:
                return false;
        }
    }

    @Override
    public Type merge(Type other) {
        if (this.compatibleWith(other)) {
            return other;
        } else if (other.compatibleWith(this)) {
            return this;
        } else {
            return ErrorType;
        }
    }

    @Override
    public int length() {
        switch (this) {
            case NullType:
            case BooleanType:
            case CharacterType:
            case FloatingType:
            case IntegerType:
            case StringType:
                return 1;
            case VoidType:
                return 0;
            default:
                throw new IllegalArgumentException("Must not call length on the Error type.");
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case BooleanType:
                return "boolean";
            case CharacterType:
                return "char";
            case ErrorType:
                return "error";
            case FloatingType:
                return "float";
            case IntegerType:
                return "int";
            case StringType:
                return "string";
            case VoidType:
                return "void";
            case NullType:
                return "unit";
            default:
                throw new IllegalArgumentException("The default case should never be triggered.");
        }
    }

    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        return true;
    }
}