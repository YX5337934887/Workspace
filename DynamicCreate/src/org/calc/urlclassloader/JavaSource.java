package org.calc.urlclassloader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class JavaSource {
	private String fileName;
	private String className;
	private String formula;
	private StringBuffer content = new StringBuffer();
//	private String content;

	public JavaSource() {
	}
	public JavaSource(String formula) {
		this.formula = formula;
	}
	
//			"package org.calc.urlclassloader;" + 
//					"public class CalcPrice {" + 
//					"public double getPrice() {" + 
//						"return "+formula + ";" + 
//			"}}";
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getContent() {
		return content.toString();
	}
	public void setContent(String formula) {
		this.formula = formula;
//	    content = 
//				"package org.calc.urlclassloader;" + 
//						"public class CalcPrice {" + 
//						"public double getPrice() {" + 
//							"return "+formula + ";" + 
//				"}}";
	}

	public void createJavaFile() throws IOException {
//		fileName = "./bin/"+packageName.replace('.', '/');
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(content.toString());
		fw.flush();
		fw.close();// 这里只是产生一个JAVA文件,简单的IO操作
	}

	public void createClassFile() throws IOException{
		// compile下面开始编译这个Store.java
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
//		Iterable units = fileMgr.getJavaFileObjects(fileName);
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, fileMgr.getJavaFileObjects(fileName));
		t.call();
		fileMgr.close();
	}
}
