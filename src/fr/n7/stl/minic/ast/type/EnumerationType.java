/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import fr.n7.stl.minic.ast.expression.value.IntegerValue;
import fr.n7.stl.minic.ast.instruction.declaration.ConstantDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.declaration.LabelDeclaration;
import fr.n7.stl.util.Logger;
import fr.n7.stl.util.SemanticsUndefinedException;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Marc Pantel
 *
 */
public class EnumerationType implements Type, Declaration {

    private String name;

    private List<LabelDeclaration> labels;

    /**
     * 
     */
    public EnumerationType(String name, List<LabelDeclaration> labels) {
        this.name = name;
        this.labels = labels;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String result = "enum" + this.name + " { ";
        Iterator<LabelDeclaration> iter = this.labels.iterator();
        if (iter.hasNext()) {
            result += iter.next();
            while (iter.hasNext()) {
                result += " ," + iter.next();
            }
        }
        return result + " }";
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#equalsTo(fr.n7.stl.block.ast.type.Type)
     */
    @Override
    public boolean equalsTo(Type other) {
        if (!(other instanceof EnumerationType)) {
            return false;
        }
        EnumerationType otherEnum = (EnumerationType) other;

        // il faut le même nombre de label
        if (this.labels.size() != otherEnum.labels.size()) {
            return false;
        }

        // il faut que les noms des labels soient deux à deux les mêmes
        Set<String> otherLabels = new HashSet<>();
        for (LabelDeclaration labelDecl : otherEnum.labels) {
            otherLabels.add(labelDecl.getName());
        }

        boolean okLabels = true;
        for (LabelDeclaration labelDecl : this.labels) {
            okLabels = okLabels && otherLabels.contains(labelDecl.getName());
        }
        return okLabels;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * fr.n7.stl.block.ast.type.Type#compatibleWith(fr.n7.stl.block.ast.type.Type)
     */
    @Override
    public boolean compatibleWith(Type other) {
        if (other == AtomicType.IntegerType) {
            // compatible avec les ints
            return true;
        } else if (this.equalsTo(other)) {
            // compatible avec lui-même
            return true;
        } else if (other instanceof EnumerationType) {
            // compatible avec les enums
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#merge(fr.n7.stl.block.ast.type.Type)
     */
    @Override
    public Type merge(Type other) {
        throw new SemanticsUndefinedException("Semantics merge is not implemented in EnumerationType.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#length()
     */
    @Override
    public int length() {
        return labels.size() * AtomicType.IntegerType.length();
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
     */
    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> scope) {
        // pas sûr
        for (int i = 0; i < this.labels.size(); i++) {
            LabelDeclaration labelDecl = this.labels.get(i);
            ConstantDeclaration constDecl = new ConstantDeclaration(labelDecl.getName(), AtomicType.IntegerType,
                    new IntegerValue(String.valueOf(i)));
            if (!(scope.accepts(constDecl))) {
                Logger.error("[EnumerationType] The constant " + constDecl.getName() + " is already declared.");
                return false;
            }
            scope.register(constDecl);
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.scope.Declaration#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.scope.Declaration#getType()
     */
    @Override
    public Type getType() {
        return this;
    }

}
