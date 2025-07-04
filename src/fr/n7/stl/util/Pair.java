/**
 * 
 */
package fr.n7.stl.util;

/**
 * @author Marc Pantel
 *
 */
public class Pair<L, R> {

	private L left;
	private R right;

	/**
	 * 
	 */
	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return this.left;
	}

	public R getRight() {
		return this.right;
	}

	public void setLeft(L left) {
		this.left = left;
	}

	public void setRight(R right) {
		this.right = right;
	}

}
