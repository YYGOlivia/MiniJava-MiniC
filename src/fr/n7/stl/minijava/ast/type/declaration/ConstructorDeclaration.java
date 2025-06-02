package fr.n7.stl.minijava.ast.type.declaration;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.scope.Declaration;
import fr.n7.stl.minic.ast.scope.HierarchicalScope;
import fr.n7.stl.minic.ast.type.AtomicType;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.Logger;

public class ConstructorDeclaration extends ClassElement {

	private List<ParameterDeclaration> parameters;

	private Block body;

	// added
	// public Block getBody(){
	// return body;
	// }

	public ConstructorDeclaration(String name, List<ParameterDeclaration> parameter, Block body) {
		super(name);
		this.parameters = parameter;
		this.body = body;
	}

	public List<ParameterDeclaration> getParams() {
		return this.parameters;
	}

	@Override
	public boolean collectAndPartialResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'collectAndPartialResolve'");
	}

	@Override
	public boolean completeResolve(HierarchicalScope<Declaration> scope) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'completeResolve'");
	}

	@Override
	public String toString() {
		String image = this.getAccessRight() + " " + this.getName() + "(";
		Iterator<ParameterDeclaration> iterator = this.parameters.iterator();
		if (iterator.hasNext()) {
			ParameterDeclaration parameter = iterator.next();
			image += parameter;
			while (iterator.hasNext()) {
				parameter = iterator.next();
				image += " ," + parameter;
			}
		}
		image += ")" + this.body;
		return image;
	}

	@Override
	public Type getType() {
		if (!super.getElementKind().equals(ElementKind.OBJECT)) {
			Logger.error("[ConstructorDeclaration] Constructor" + this.getName()
					+ "(" + parameters.size() + ") cannot be static");
		}
		Logger.warning("[ConstructorDeclaration] AUCUNE IDEE DE CE QU'IL SE PASSE APRES CE POINT");
		return AtomicType.VoidType;
	}
}
