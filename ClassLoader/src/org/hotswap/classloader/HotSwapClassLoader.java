package org.hotswap.classloader;

public class HotSwapClassLoader extends ClassLoader {

//	private String classPath = System.getProperty("user.dir") + File.separator + "bin";
	private static HotSwapClassLoader hotSwapClassLoader;

	public static HotSwapClassLoader getClassLoader() {
		return hotSwapClassLoader;
	}

	@Override
	public Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		Class<?> clazz = null;
		// 查看HotSwapClassLoader实例缓存下，是否已经加载过class
		// 不同的HotSwapClassLoader实例是不共享缓存的
		clazz = findLoadedClass(name);
		if (clazz != null) {
			if (resolve) {
				resolveClass(clazz);
			}
			// 如果class类被修改过，则重新加载
			hotSwapClassLoader = new HotSwapClassLoader();
			clazz = customLoad(name, hotSwapClassLoader);
			return clazz;
		}
		return null;
	}

	/**
	 * 自定义加载
	 * @param name
	 * @param loader
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name, ClassLoader loader)
			throws ClassNotFoundException {
		return customLoad(name, false, loader);
	}

	/**
	 * 自定义加载
	 * @param name
	 * @param resolve
	 * @param loader
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name, boolean resolve, ClassLoader loader)
			throws ClassNotFoundException {
		// findClass()调用的是URLClassLoader里面重载了ClassLoader的findClass()方法
		Class<?> clazz = ((HotSwapClassLoader) loader).findClass(name);
		if (resolve)
			((HotSwapClassLoader) loader).resolveClass(clazz);
		return clazz;
	}
}