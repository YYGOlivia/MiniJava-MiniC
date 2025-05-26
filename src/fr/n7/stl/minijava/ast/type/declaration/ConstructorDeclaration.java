package fr.n7.stl.minijava.ast.type.declaration;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.type.Type;

public class ConstructorDeclaration extends ClassElement {

	protected List<ParameterDeclaration> parameters;

	protected Block body;

	public ConstructorDeclaration(String name, List<ParameterDeclaration> parameter, Block body) {
		super(name);
		this.parameters = parameter;
		this.body = body;
	}

	@Override
	public String toString() {
		String image = "";
		image += this.accessRight + " " + this.name + "( ";
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
		// TODO Auto-generated method stub
		return null;
	}
}
