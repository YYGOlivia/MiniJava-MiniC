/**
 * 
 */
package fr.n7.stl.util;

/**
 * @author Marc Pantel
 *
 */
public class Logger {

	public static void warning(String message) {
		System.err.println("Warning : " + message);
	}

	public static void error(String message) {
		System.err.println("Error : " + message);
		throw new BlockSemanticsError();
	}

}
