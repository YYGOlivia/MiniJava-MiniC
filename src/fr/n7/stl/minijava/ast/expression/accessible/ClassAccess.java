package fr.n7.stl.minijava.ast.expression.accessible;

import fr.n7.stl.minic.ast.expression.AbstractAccess;
import fr.n7.stl.minic.ast.instruction.declaration.VariableDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minijava.ast.type.declaration.ClassDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ClassAccess extends AbstractAccess{

    private ClassDeclaration declaration;

    public ClassAccess(ClassDeclaration declaration) {
		this.declaration = declaration;
	}

    @Override
    public Declaration getDeclaration() {
        return declaration;
    }

    @Override
    public Fragment getCode(TAMFactory factory) {
        Fragment frag = factory.createFragment();
        frag.add(factory.createLoad(Register.LB, declaration.getOffset(), 1));
        return frag;
    }

}
