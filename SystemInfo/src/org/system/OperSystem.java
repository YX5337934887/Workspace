package org.system;
public class OperSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("os.arch"));
	}
}
