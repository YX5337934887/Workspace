package org.initclass2;

import org.initclass.Field1;
import org.initclass.Field2;

class InitClass2 {
	public static Field1 f1 = new Field1();
	public static Field1 f2;
	static {
		System.out.println("运行父类静态代码");
	}
}

class SubInitClass2 extends InitClass2 {
	public static Field2 f2 = new Field2();
	static {
		System.out.println("运行子类静态代码");
	}
}

public class Test {
	public static void main(String[] args) throws ClassNotFoundException {
		new SubInitClass2();
	}
}