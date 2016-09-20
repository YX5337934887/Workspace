package org.initclass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class InitClass {
	static {
		System.out.println("��ʼ��InitClass");
	}
	public static String a = null;

	public static void method() {
		System.out.println("��ʼ��method");
	}
}

class SubInitClass extends InitClass {
}

public class Test {

	/**
	 * ��������������ĳ�ʼ���ĵ����������������Test1��main����ʱ ����Test1��ʼ������һ��ܺ���⣬�Ͳ��ر���ʾ�ˡ�
	 * ��������ʾ��ǰ������������´��붼������InitClass�ĳ�ʼ���� �����ڳ�ʼ��ֻ�����һ�Σ�����ʱ�뽫ע��ȥ�����������в鿴�����
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// ��������������ĳ�ʼ��һ: new���󡢶�ȡ��������ľ�̬������������ľ�̬������
		new InitClass();
		InitClass.a = "";
		String a = InitClass.a;
		InitClass.method();

		// ��������������ĳ�ʼ������ͨ������ʵ�������󡢶�ȡ��������ľ�̬������������ľ�̬������
		Class<InitClass> cls = InitClass.class;
		cls.newInstance();

		Field f = cls.getDeclaredField("a");
		f.get(null);
		f.set(null, "s");

		Method md = cls.getDeclaredMethod("method");
		md.invoke(null);

		// ��������������ĳ�ʼ������ʵ�������࣬�������ʼ����
		new SubInitClass();
	}
}