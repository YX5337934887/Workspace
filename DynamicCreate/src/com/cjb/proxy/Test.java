package com.cjb.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Test {
	public static void main(String[] args) throws Exception {
		String rt = "\r\n";
		String source = "package com.cjb.proxy;" + rt
				+ "public class Dealer implements Store" + rt + "{" + rt
				+ "private Store s;" + rt + "public Dealer(Store s)" + rt
				+ " {" + "  this.s = s;" + rt + " }" + rt +
				" public void sell()" + " {" + rt
				+ "  System.out.println(\"price markup....\");" + rt
				+ "  s.sell();" + " }" + rt + "}";

		String fileName = System.getProperty("user.dir") + "/bin/com/cjb/proxy/Dealer.java";
				// ��ȡ����Ŀ�ĸ�·��
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(source);
		fw.flush();
		fw.close();// ����ֻ�ǲ���һ��JAVA�ļ�,�򵥵�IO����

		// compile���濪ʼ�������Store.java
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
//		Iterable units = fileMgr.getJavaFileObjects(fileName);
		Iterable<? extends JavaFileObject> units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		t.call();
		fileMgr.close();

		// load into memory and create an instance
		URL[] urls = new URL[] { new URL("file:/" + System.getProperty("user.dir") + "/bin") };
		URLClassLoader ul = new URLClassLoader(urls);
		Class<?> c = ul.loadClass("com.cjb.proxy.Dealer");
		System.out.println(c);

		// �ͻ��˵���

		Constructor<?> ctr = c.getConstructor(Store.class);
		Store s = (Store) ctr.newInstance(new Supermarket());// ���￴��,�������������������ʵ��Store��ԭ��
		s.sell();
	}
}