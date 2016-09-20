package org.base.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FieldDemo {
	public static void main(String[] args) {
		Class<Day> c = Day.class;
		try {
			Object obj = c.newInstance();
			Field yesterday = c.getDeclaredField("yesterday");
			Field today = c.getDeclaredField("today");
			Field tomorrow = c.getDeclaredField("tomorrow");
			yesterday.setAccessible(true);
			today.setAccessible(true);
			tomorrow.setAccessible(true);
			System.out.println(yesterday.get(obj));
			System.out.println(today.get(obj));
			System.out.println(tomorrow.get(obj));
			yesterday.set(obj, "����");
			today.set(obj, "����");
			tomorrow.set(obj, "����");
			Method m = c.getDeclaredMethod("output");
			m.invoke(obj);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
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

class Day {
	private String yesterday = "����";
	private String today = "����";
	private String tomorrow = "����";
	public void output() {
		System.out.println(yesterday+"---->"+today+"---->"+tomorrow);
	}
}