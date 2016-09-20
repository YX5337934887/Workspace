package org.reflect.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflectMethod {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
//		for(long i=100;i>0;i--) {
			TestReflectMethod test = new TestReflectMethod();
			String className = "org.reflect.entity.DefaultEntity";
			test.entityTest(className);
			className = "org.reflect.entity.PublicEntity";
			test.entityTest(className);
//		}
		System.out.println(System.currentTimeMillis()-time);
	}
	
	void entityTest(String className) {
		Class<?> cla = null;
		Object obj = null;
		try {
			cla = Class.forName(className);
			Constructor<?> constructor = cla.getDeclaredConstructor();
			constructor.setAccessible(true);
			obj = constructor.newInstance();
			Field []fields = cla.getDeclaredFields();
			Method []setMethods = new Method[fields.length];
			Method []getMethods = new Method[fields.length];
			for(int i = 0;i<fields.length;i++) {
//				char []fieldName = fields[i].getName().toCharArray();
//				fieldName[0] -= 32;
//				String methodName = String.valueOf(fieldName);
//				String methodName = fields[0].getName().substring(0,1).toUpperCase()+fields[0].getName().substring(1);
//				String methodName = String.valueOf(fields[0].getName().charAt(0)).toUpperCase()+fields[0].getName().substring(1);
				String methodName = String.valueOf((char)(fields[0].getName().charAt(0)-32))+fields[0].getName().substring(1);
				Method method = cla.getDeclaredMethod("set"+methodName, Object.class);
//				Method method = cla.getDeclaredMethod("set".concat(methodName), Object.class);
				method.setAccessible(true);
				setMethods[i] = method;
				method.invoke(obj, fields[i]);
				method = cla.getDeclaredMethod("get"+methodName);
				method.setAccessible(true);
				getMethods[i] = method;
			}
			for(Method method:getMethods) {
				System.out.println(method.invoke(obj));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
