package fr.n7.stl.minijava.ast.type.declaration;

public enum AccessRight {

	/**
	 * Pour une méthode ou un attribut public.
	 */
	PUBLIC,
	/**
	 * Pour une méthode ou un attribut package-private (par défaut).
	 */
	PACKAGE,
	/**
	 * Pour une méthode ou un attribut protégé.
	 */
	PROTECTED,
	/**
	 * Pour une méthode ou un attribut privé.
	 */
	PRIVATE;

	@Override
	public String toString() {
		switch (this) {
			case PUBLIC:
				return "public";
			case PACKAGE:
				return "";
			case PROTECTED:
				return "protected";
			case PRIVATE:
				return "private";
			default:
				throw new IllegalArgumentException("The default case should never be triggered.");
		}
	}

}
