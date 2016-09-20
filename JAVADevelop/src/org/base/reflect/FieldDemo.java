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
			yesterday.set(obj, "昨日");
			today.set(obj, "今日");
			tomorrow.set(obj, "明日");
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
	private String yesterday = "昨天";
	private String today = "今天";
	private String tomorrow = "明天";
	public void output() {
		System.out.println(yesterday+"---->"+today+"---->"+tomorrow);
	}
}