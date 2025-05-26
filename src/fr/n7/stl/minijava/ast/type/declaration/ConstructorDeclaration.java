package fr.n7.stl.minijava.ast.type.declaration;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.type.Type;
import fr.n7.stl.util.SemanticsUndefinedException;

public class ConstructorDeclaration extends ClassElement {

	private List<ParameterDeclaration> parameters;

	private Block body;

	public ConstructorDeclaration(String name, List<ParameterDeclaration> parameter, Block body) {
		super(name);
		this.parameters = parameter;
		this.body = body;
	}

	@Override
	public String toString() {
		String image = "";
		image += this.getAccessRight() + " " + this.getName() + "( ";
		Iterator<ParameterDeclaration> iterator = this.parameters.iterator();
		if (iterator.hasNext()) {
			ParameterDeclaration parameter = iterator.next();
			image += parameter;
			while (iterator.hasNext()) {
				parameter = iterator.next();
				image += " ," + parameter;
			}
		}
		image += ")";
		image += this.body;
		return image;
	}

	@Override
	public Type getType() {
		throw new SemanticsUndefinedException("Semantics getType is undefined in ConstructorDeclaration.");
	}
}
