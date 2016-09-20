package org.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class TestReflectField {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		TestReflectField test = new TestReflectField();
		String className = "org.reflect.entity.DefaultEntity";
		System.out.println("-------------------");
		System.out.println(className);
		test.entityTest(className);
		className = "org.reflect.entity.PublicEntity";
		System.out.println("-------------------");
		System.out.println(className);
		test.entityTest(className);
		System.out.println(System.currentTimeMillis()-time);
	}
	
	void entityTest(String className) {
		Class<?> cla = null;
		Object obj = null;
		try {
			cla = Class.forName(className);
//			Constructor<?> publicConstructor = cla.getConstructor();//只能获得公有的构造方法
			Constructor<?> defaultConstructor = cla.getDeclaredConstructor();
//			publicConstructor.setAccessible(true);
			defaultConstructor.setAccessible(true);
			System.out.println(cla.getModifiers());
//			obj = cla.newInstance();//只有public修饰符的类才能调用
//			obj = publicConstructor.newInstance();//使用默认构造方法创建对象
			obj = defaultConstructor.newInstance();
			Field []fields = cla.getDeclaredFields();
			for(Field field:fields) {
				System.out.println(field);
				field.setAccessible(true);
				field.set(obj, field.getName());
				System.out.println("field name:"+field.getName()+",field value:"+field.get(obj));
//				field.setAccessible(false);
			}
			System.out.println("------------------------------");
			for(Field field:fields) {
//				if(field.getModifiers()==Modifier.PUBLIC)
				field.set(obj, field.getName());
//				if(Modifier.isPublic(field.getModifiers()))
					System.out.println(field.get(obj));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
