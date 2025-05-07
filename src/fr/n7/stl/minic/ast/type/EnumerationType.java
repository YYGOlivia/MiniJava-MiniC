/**
 * 
 */
package fr.n7.stl.minic.ast.type;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.n7.stl.minic.ast.SemanticsUndefinedException;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.declaration.LabelDeclaration;

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
    public EnumerationType(String _name, List<LabelDeclaration> _labels) {
        this.name = _name;
        this.labels = _labels;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String _result = "enum" + this.name + " { ";
        Iterator<LabelDeclaration> _iter = this.labels.iterator();
        if (_iter.hasNext()) {
            _result += _iter.next();
            while (_iter.hasNext()) {
                _result += " ," + _iter.next();
            }
        }
        return _result + " }";
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#equalsTo(fr.n7.stl.block.ast.type.Type)
     */
    @Override
    public boolean equalsTo(Type _other) {
        if (!(_other instanceof EnumerationType)) {
            return false;
        }
        EnumerationType otherEnum = (EnumerationType) _other;

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
    public boolean compatibleWith(Type _other) {
        if (!(_other instanceof EnumerationType)) {
            return false;
        }
        EnumerationType otherEnum = (EnumerationType) _other;

        // il faut plus ou autant de label que l'autre
        if (this.labels.size() < otherEnum.labels.size()) {
            return false;
        }

        // il faut que j'ai au moins tous ses labels
        Set<String> thisLabels = new HashSet<>();
        for (LabelDeclaration labelDecl : this.labels) {
            thisLabels.add(labelDecl.getName());
        }

        boolean okLabels = true;
        for (LabelDeclaration labelDecl : otherEnum.labels) {
            okLabels = okLabels && thisLabels.contains(labelDecl.getName());
        }
        return okLabels;
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#merge(fr.n7.stl.block.ast.type.Type)
     */
    @Override
    public Type merge(Type _other) {
        throw new SemanticsUndefinedException("Semantics merge is not implemented in EnumerationType.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#length()
     */
    @Override
    public int length() {
        throw new SemanticsUndefinedException("Semantics length is not implemented in EnumerationType.");
    }

    /*
     * (non-Javadoc)
     * 
     * @see fr.n7.stl.block.ast.type.Type#resolve(fr.n7.stl.block.ast.scope.Scope)
     */
    @Override
    public boolean completeResolve(HierarchicalScope<Declaration> _scope) {
        // pas sûr
        for (LabelDeclaration labelDeclaration : labels) {
            _scope.register(labelDeclaration);
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
