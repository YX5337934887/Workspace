package org.calc.urlclassloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * ֻҪ���������¼��ظ��Ĺ���.class�ļ����ﵽ���滻������
 */
public class HotSwapURLClassLoader extends URLClassLoader {

	// ����class�����ڵ�·��
	private static String classPath = "./bin";

	private static HotSwapURLClassLoader classLoader = new HotSwapURLClassLoader();

	public HotSwapURLClassLoader() {
		// ����ClassLoader���ص�·��
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
	 * ��дloadClass��������˫��ί�л���("java."��ͷ���໹�ǻ���ϵͳĬ��ClassLoader����)
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
			clazz = customLoad(name, classLoader);
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
		return customLoad(name, this);
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
	public Class<?> customLoad(String name, ClassLoader cl)
			throws ClassNotFoundException {
		return customLoad(name, false, cl);
	}

	/**
	 * �Զ������
	 * 
	 * @param name
	 * @param resolve
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class<?> customLoad(String name, boolean resolve, ClassLoader cl)
			throws ClassNotFoundException {
		// findClass()���õ���URLClassLoader����������ClassLoader��findClass()����
		Class<?> clazz = ((HotSwapURLClassLoader) cl).findClass(name);
		if (resolve)
			((HotSwapURLClassLoader) cl).resolveClass(clazz);
		return clazz;
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return loadClass(name, false);
	}
	
	/**
	 * ������������
	 */
	@Override
	protected void finalize() throws Throwable {
		Test.num--;
		System.out.println("����"+this+"��Ҫ�����գ�"+"ʣ����������"+Test.num);
	}
}