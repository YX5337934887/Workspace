package org.initclass3;

class InitClass {
	static {
		System.out.println("��ʼ��InitClass");
	}
	public static String a = null;
	public final static String b = "b";

	public static void method() {
	}
}

class SubInitClass extends InitClass {
	static {
		System.out.println("��ʼ��SubInitClass");
	}
}

public class Test {

	public static void main(String[] args) throws Exception {
		 String a = SubInitClass.a;// ���ø���ľ�̬�ֶΣ�ֻ���������ʼ������������������ĳ�ʼ��
		 String b = InitClass.b;// ʹ����ĳ�������������ĳ�ʼ��
		SubInitClass[] sc = new SubInitClass[10];// ���������鲻��������ĳ�ʼ��
	}
}