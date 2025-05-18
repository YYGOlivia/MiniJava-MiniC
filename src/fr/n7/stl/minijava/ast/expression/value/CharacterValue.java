package fr.n7.stl.minijava.ast.expression.value;

import org.apache.commons.text.StringEscapeUtils;

import fr.n7.stl.minijava.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.scope.HierarchicalScope;
import fr.n7.stl.minijava.ast.type.AtomicType;
import fr.n7.stl.minijava.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class CharacterValue implements Value {

    private char value;

    public CharacterValue(String text) {
        this.value = StringEscapeUtils.ESCAPE_JAVA.translate(text).charAt(value);
    }

    @Override
    public String toString() {
        return "'" + this.value + "'";
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
        return AtomicType.CharacterType;
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        Fragment frag = factory.createFragment();
        frag.add(factory.createLoadL(this.value));
        return frag;
    }
}