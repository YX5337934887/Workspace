package org.calc.urlclassloader;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
	public static int num = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    JavaSource source = new JavaSource();
	    source.setClassName("org.calc.urlclassloader.CalcPrice");
	    source.setFileName("./bin/org/calc/urlclassloader/CalcPrice.java");
	    String var = null;
//	    HotSwapURLClassLoader loader = null;
	    try {
	    	/*
	    	Integer num=0;
			var = "(532/65-45+324/5)*645";
			do{
				num = Integer.valueOf(input.nextLine());
				HotSwapURLClassLoader[] loaders = new HotSwapURLClassLoader[num];
				for(int i = 0;i<num;i++) {
					loaders[i] = new HotSwapURLClassLoader();
					Test.num++;
					System.out.println("对象："+loaders[i]+"已创建，"+"剩余对象个数："+Test.num);
					source.setContent(var);
			    	source.createJavaFile();
			    	source.createClassFile();
			    	loaders[i].loadClass(source.getClassName());
//					Class<?> cla = loaders[i].loadClass(source.getClassName());
//					Object obj = cla.newInstance();
//					Method method = cla.getDeclaredMethod("getPrice");
//					System.out.println(method.invoke(obj));
					loaders[i] = null;
				}
				loaders = null;
//				System.out.println("通知Java虚拟机回收垃圾");
				System.gc();
//				System.out.println("垃圾回收操作已通知Java虚拟机");
			}
			while (num != null);
			*/
			
			HotSwapURLClassLoader loader = new HotSwapURLClassLoader();
//			do{
				var = input.nextLine();
				source.setContent(var);
//				System.out.println(source.getContent());
				
		    	source.createJavaFile();
		    	source.createClassFile();
//		    	loader = HotSwapURLClassLoader.getClassLoader();
				Class<?> cla = loader.loadClass(source.getClassName());
				Object obj = cla.newInstance();
				Method method = cla.getDeclaredMethod("getPrice");
				System.out.println(method.invoke(obj));
//			}
//			while (var != null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
