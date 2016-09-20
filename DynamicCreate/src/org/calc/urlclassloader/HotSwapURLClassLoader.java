package org.calc.urlclassloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 只要功能是重新加载更改过的.class文件，达到热替换的作用
 */
public class HotSwapURLClassLoader extends URLClassLoader {

	// 工程class类所在的路径
	private static String classPath = "./bin";

	private static HotSwapURLClassLoader classLoader = new HotSwapURLClassLoader();

	public HotSwapURLClassLoader() {
		// 设置ClassLoader加载的路径
		super(getURLs(classPath));
	}

	public static HotSwapURLClassLoader getClassLoader() {
		return classLoader;
	}

	private static URL[] getURLs(String classPath) {
		URL url = null;
		try {
			url = new File(classPath).toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new URL[] { url };
	}

	/**
	 * 重写loadClass，不采用双亲委托机制("java."开头的类还是会由系统默认ClassLoader加载)
	 */
	@Override
	public Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		// 查看HotSwapURLClassLoader实例缓存下，是否已经加载过class
		// 不同的HotSwapURLClassLoader实例是不共享缓存的
		Class<?> clazz = findLoadedClass(name);
		if (clazz != null) {
			if (resolve) {
				resolveClass(clazz);
			}
			classLoader = new HotSwapURLClassLoader();
			clazz = customLoad(name, classLoader);
			return clazz;
		}
		// 如果类的包名为"java."开始，则有系统默认加载器AppClassLoader加载
		if (name.startsWith("java.")) {
			try {
				// 得到系统默认的加载cl，即AppClassLoader
				ClassLoader system = ClassLoader.getSystemClassLoader();
				clazz = system.loadClass(name);
				if (clazz != null) {
					if (resolve)
						resolveClass(clazz);
					return (clazz);
				}
			} catch (ClassNotFoundException e) {
			}
		}
		return customLoad(name, this);
	}

	public Class<?> load(String name) throws Exception {
		return loadClass(name);
	}

	/**
	 * 自定义加载
	 * 
	 * @param name
	 * @param cl
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name, ClassLoader cl)
			throws ClassNotFoundException {
		return customLoad(name, false, cl);
	}

	/**
	 * 自定义加载
	 * 
	 * @param name
	 * @param resolve
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name, boolean resolve, ClassLoader cl)
			throws ClassNotFoundException {
		// findClass()调用的是URLClassLoader里面重载了ClassLoader的findClass()方法
		Class<?> clazz = ((HotSwapURLClassLoader) cl).findClass(name);
		if (resolve)
			((HotSwapURLClassLoader) cl).resolveClass(clazz);
		return clazz;
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return loadClass(name, false);
	}
	
	/**
	 * 回收垃圾对象
	 */
	@Override
	protected void finalize() throws Throwable {
		Test.num--;
		System.out.println("对象："+this+"将要被回收，"+"剩余对象个数："+Test.num);
	}
}