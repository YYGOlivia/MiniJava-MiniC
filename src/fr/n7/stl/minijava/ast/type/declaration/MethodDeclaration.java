package fr.n7.stl.minijava.ast.type.declaration;

import fr.n7.stl.minic.ast.Block;
import fr.n7.stl.minic.ast.instruction.declaration.ParameterDeclaration;
import fr.n7.stl.minic.ast.type.Type;
import java.util.Iterator;
import java.util.List;

public class MethodDeclaration extends ClassElement {

	private boolean concrete;

	private List<ParameterDeclaration> parameters;

	private Block body;

	private Type type;

	public MethodDeclaration(String name, Type type, List<ParameterDeclaration> parameter, Block body) {
		super(name);
		this.parameters = parameter;
		this.body = body;
		this.concrete = (body != null);
		this.type = type;
	}

	public MethodDeclaration(String name, Type type, List<ParameterDeclaration> parameter) {
		this(name, type, parameter, null);
	}

	public boolean isConcrete() {
		return this.concrete;
	}

	@Override
	public String toString() {
		String image = "";
		if (!this.concrete) {
			image += "abstract ";
		}
		image += this.getAccessRight() + " " + this.getElementKind() + " " + this.type + " " + this.getName() + "(";
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
		if (this.concrete) {
			image += " " + this.body + "\n";
		} else {
			image += ";\n";
		}
		return image;
	}

	@Override
	public Type getType() {
		return type;
	}

}
