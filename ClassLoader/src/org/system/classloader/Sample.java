package org.system.classloader;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Class c;
		ClassLoader c1,c11;
		c1 = ClassLoader.getSystemClassLoader();
		System.out.println(c1);
		while(c1 != null) {
			c11 = c1;
			c1 = c1.getParent();
			System.out.println(c11 + ":" +c1);
		}
		/*
		try {
			c = Class.forName
		}
		*/
	}

}
