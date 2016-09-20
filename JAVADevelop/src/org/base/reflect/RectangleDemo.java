package org.base.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RectangleDemo {
	private Integer width;
	private Integer height;
	public RectangleDemo(){
		width=20;
		height=10;
	}
	public RectangleDemo(Integer width,Integer height) {
		this.width=width;
		this.height=height;
	}
	public static void main(String[] args) {
		Class<RectangleDemo> c = RectangleDemo.class;
		try {
			Constructor<RectangleDemo> constructor1 = c.getConstructor();
			RectangleDemo obj = c.newInstance();
			System.out.println(obj.width+","+obj.height);
			obj = constructor1.newInstance();
			System.out.println(obj.width+","+obj.height);
			Constructor<RectangleDemo> constructor2=c.getConstructor(Integer.class,Integer.class);
			obj = constructor2.newInstance(20,50);
			System.out.println(obj.width+","+obj.height);

			Method m = c.getDeclaredMethod("getArea");
			System.out.println(m.invoke(obj));
			
			Field w = c.getDeclaredField("width");
			Field h = c.getDeclaredField("height");
			w.set(obj, 1000);
			h.set(obj, 2000);
			
			System.out.println(m.invoke(obj));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	public Integer getArea() {
		return width*height;
	}
}
