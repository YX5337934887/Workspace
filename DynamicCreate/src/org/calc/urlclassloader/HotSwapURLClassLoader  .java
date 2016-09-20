package org.calc.urlclassloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * ��Ҫ���������¼��ظ��Ĺ���.class�ļ����ﵽ���滻������
 * 
 * @author banana
 */
public class HotSwapURLClassLoader extends URLClassLoader {

	// ����class�����ڵ�·��
	private static String classPath = "./bin";
	private static HotSwapURLClassLoader classLoader = new HotSwapURLClassLoader();
	/**
	 * Ĭ��·��Ϊ��ǰ�����ռ�
	 */
	public HotSwapURLClassLoader() {
		super(getURLs(classPath));
	}

	/**
	 * ����ָ��·���µ�class
	 * @param classPath
	 */
	public HotSwapURLClassLoader(String classPath) {
		// ����ClassLoader���ص�·��
		super(getURLs(classPath));
	}

	public static HotSwapURLClassLoader getClassLoader() {
		return classLoader;
	}

	private static URL[] getURLs(String classPath) {
		try {
			URL url = new File(classPath).toURI().toURL();
			HotSwapURLClassLoader.classPath = classPath;
			return new URL[] { url };
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��дloadClass��������˫��ί�л���
	 */
	@Override
	public Class<?> loadClass(String name, boolean resolve)
			throws ClassNotFoundException {
		// �鿴HotSwapURLClassLoaderʵ�������£��Ƿ��Ѿ����ع�class
		// ��ͬ��HotSwapURLClassLoaderʵ���ǲ��������
		Class<?> clazz = findLoadedClass(name);
		if (clazz != null) {
			if (resolve) {
				resolveClass(clazz);
			}
			classLoader = new HotSwapURLClassLoader();
			clazz = customLoad(name);
			return clazz;
		}

		// �����İ���Ϊ"java."��ʼ������ϵͳĬ�ϼ�����AppClassLoader����
		if (name.startsWith("java.")) {
			try {
				// �õ�ϵͳĬ�ϵļ���cl����AppClassLoader
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
		return customLoad(name);
	}

	public Class<?> load(String name) throws Exception {
		return loadClass(name);
	}

	/**
	 * �Զ������
	 * 
	 * @param name
	 * @param cl
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name)
			throws ClassNotFoundException {
		return customLoad(name, false);
	}

	/**
	 * �Զ������
	 * 
	 * @param name
	 * @param resolve
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name, boolean resolve)
			throws ClassNotFoundException {
		// findClass()���õ���URLClassLoader����������ClassLoader��findClass()����
		Class<?> clazz = findClass(name);
		if (resolve)
			classLoader.resolveClass(clazz);
		return clazz;
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return loadClass(name, false);
	}
}