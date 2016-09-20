

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

class MyClassCompiler {
	private String simpleClassName;
	private String code;
	private String classPath = System.getProperty("user.dir") + File.separator + "bin";

	public MyClassCompiler(String simpleClassName, String code) {
		this.simpleClassName = simpleClassName;
		this.code = code;
	}

	public boolean compile() {
		try {
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			JavaFileObject javaFile = new SimpleJavaFileObject(new URI(
					simpleClassName + ".java"), Kind.SOURCE) {
				@Override
				public CharSequence getCharContent(boolean arg) throws IOException {
					return code;
				}
			};
			CompilationTask task = compiler.getTask(null, null, null, Arrays.asList("-d", classPath), null, Arrays.asList(javaFile));
			return task.call();
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String getSimpleClassName() {
		return simpleClassName;
	}

	public void setSimpleClassName(String simpleClassName) {
		this.simpleClassName = simpleClassName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
}

public class MyClassLoader extends ClassLoader {

	private boolean alwaysDefineClass = true;
	private String classPath = System.getProperty("user.dir") + File.separator + "bin";

	@Override
	protected Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		return super.loadClass(name, resolve);
	}
	
	/*
	@Override
	public Class<?> loadClass(String name,boolean resolve) throws ClassNotFoundException {
        Class clazz = null;
        //查看HotSwapURLClassLoader实例缓存下，是否已经加载过class
        //不同的HotSwapURLClassLoader实例是不共享缓存的
        clazz = findLoadedClass(name);
        if (clazz != null ) {
            if (resolve){
                resolveClass(clazz);
            }
            //如果class类被修改过，则重新加载
            if (isModify(name)) {
                hcl = new HotSwapClassLoader();
                clazz = customLoad(name, hcl);
            }
            return (clazz);
        }
	}
	*/
	
	@Override
	protected Class<?> findClass(String fullClassName)
			throws ClassNotFoundException {
		Class<?> clazz = null;
		// clazz = findLoadedClass(fullClassName);
		// if(alwaysDefineClass || clazz == null){
		byte[] raw = readClassBytes(fullClassName);
		clazz = defineClass(fullClassName, raw, 0, raw.length);
		resolveClass(clazz);
		// }

		return clazz;
	}

	private byte[] readClassBytes(String fullClassName) {
		byte[] raw = null;
		InputStream stream = null;
		File file = new File(classPath + File.separator
				+ fullClassName.replaceAll("\\.", "/") + ".class");

		try {
			stream = new FileInputStream(file);
			raw = new byte[(int) file.length()];
			stream.read(raw);
		} catch (Exception e) {

		} finally {
			try {
				stream.close();
			} catch (IOException e) {
			}
		}
		return raw;
	}

	public boolean isAlwaysDefineClass() {
		return alwaysDefineClass;
	}

	public void setAlwaysDefineClass(boolean alwaysDefineClass) {
		this.alwaysDefineClass = alwaysDefineClass;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
}

interface MyInterface {
	public void sayHello();
}

class Main {
	public static void main(String[] args) {
		String fullClassName = "MyObj";

		String code = "public class MyObj implements MyInterface{public void sayHello(){System.out.println(666);}}";
		String code_2 = "public class MyObj implements MyInterface{public void sayHello(){System.out.println(777);}}";
		String code_3 = "public class MyObj implements MyInterface{public void sayHello(){System.out.println(888);}}";
		load(code, fullClassName);
		load(code_2, fullClassName);
		load(code_3, fullClassName);
	}

	private static void load(String code, String fullClassName) {
		if(!new MyClassCompiler(fullClassName, code).compile())
			return;

		try {
			MyInterface myObj = (MyInterface) new MyClassLoader().loadClass(
					fullClassName).newInstance();
			myObj.sayHello();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}