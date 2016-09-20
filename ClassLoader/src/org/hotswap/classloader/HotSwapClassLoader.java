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
		// �鿴HotSwapClassLoaderʵ�������£��Ƿ��Ѿ����ع�class
		// ��ͬ��HotSwapClassLoaderʵ���ǲ��������
		clazz = findLoadedClass(name);
		if (clazz != null) {
			if (resolve) {
				resolveClass(clazz);
			}
			// ���class�౻�޸Ĺ��������¼���
			hotSwapClassLoader = new HotSwapClassLoader();
			clazz = customLoad(name, hotSwapClassLoader);
			return clazz;
		}
		return null;
	}

	/**
	 * �Զ������
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
	 * �Զ������
	 * @param name
	 * @param resolve
	 * @param loader
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name, boolean resolve, ClassLoader loader)
			throws ClassNotFoundException {
		// findClass()���õ���URLClassLoader����������ClassLoader��findClass()����
		Class<?> clazz = ((HotSwapClassLoader) loader).findClass(name);
		if (resolve)
			((HotSwapClassLoader) loader).resolveClass(clazz);
		return clazz;
	}
}