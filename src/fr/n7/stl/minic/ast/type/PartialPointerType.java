/**
 * 
 */
package fr.n7.stl.minic.ast.type;

/**
 * @author Marc Pantel
 *
 */
public class PartialPointerType extends PointerType implements PartialType {

	/**
	 * @param element
	 */
	public PartialPointerType() {
		super(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.n7.stl.block.ast.type.PartialType#complete(fr.n7.stl.block.ast.type.Type)
	 */
	@Override
	public Type complete(Type type) {
		if (this.getElement() == null) {
			return new PointerType(type);
		} else {
			return new PointerType(((PartialType) this.getElement()).complete(type));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.n7.stl.block.ast.type.PartialType#enrich(fr.n7.stl.block.ast.type.
	 * PartialType)
	 */
	@Override
	public void enrich(PartialType type) {
		if (this.getElement() == null) {
			this.setElement(type);
		} else {
			((PartialType) this.getElement()).enrich(type);
		}
	}

}
