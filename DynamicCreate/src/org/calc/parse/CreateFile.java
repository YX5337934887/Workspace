package org.calc.parse;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class CreateFile {
	public Double getResult(String formula) throws Exception {
		String source = 
		"package org.calc.parse;"+ 
			"public class CalcPrice implements Calc {"+
				"public double getPrice() {"+ 
					"return "+formula + ";"+ 
		"}}";

//		String fileName = System.getProperty("user.dir") + "/bin/org/calc/parse/CalcPrice.java";
//		String fileName = "/bin/org/calc/parse/CalcPrice.java";
		String fileName = "./bin/org/calc/parse/CalcPrice.java";
		File f = new File(fileName);
		System.out.println(f.isFile());
		System.out.println(f.isAbsolute());
		System.out.println(f.isDirectory());
		System.out.println(f.exists());
		System.out.println(f.getAbsolutePath());
		System.out.println(File.pathSeparatorChar);
		System.out.println(File.separatorChar);
		FileWriter fw = new FileWriter(f);
		fw.write(source);
		fw.flush();
		fw.close();// 这里只是产生一个JAVA文件,简单的IO操作

		// compile下面开始编译java文件
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
//		Iterable units = fileMgr.getJavaFileObjects(fileName);
//		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, fileMgr.getJavaFileObjects(fileName));
		t.call();
		fileMgr.close();
		
		URL[] urls = new URL[] { new URL("file:/" + System.getProperty("user.dir") + "/bin") };
		URLClassLoader ul = new URLClassLoader(urls);
		Class<?> c = ul.loadClass("org.calc.parse.CalcPrice");

//		Constructor<?> ctr = c.getConstructor();
//		Calc calc = (Calc) ctr.newInstance();
//		Double price = calc.getPrice();
//		Class<?> c = Class.forName("org.calc.parse.CalcPrice");
		Object obj=c.newInstance();
		Method method = c.getMethod("getPrice");
		Double price = (Double)method.invoke(obj);
//		method = null;
//		obj = null;
//		c = null;
//		System.gc();
		return price;
	}
}
