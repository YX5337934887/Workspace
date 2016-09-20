package org.base.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
	public void showNum() {
		System.out.println(200);
	}
	public void showNum(int num) {
		System.out.println(num);
	}
	public void showNum(int num1,int num2) {
		System.out.println(num1+","+num2);
	}
	public static void main(String[] args) {
		String methodName = "showNum";
		Class<MethodDemo> c = MethodDemo.class;
//		Class<Class> clazz = Class.class;
		try {
			Object obj = c.newInstance();
			Method m = c.getMethod(methodName);
			m.invoke(obj);
			m = c.getMethod(methodName, int.class);
			m.invoke(obj, 1);
			m = c.getMethod(methodName, int.class,int.class);
			System.out.println(m.invoke(obj, 10,62));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
