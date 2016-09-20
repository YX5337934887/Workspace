package org.hotswap.urlclassloader;

import java.lang.reflect.Method;

public class MonitorHotSwap implements Runnable {
	// Hot���������޸ģ����������ȼ���
	private String className = "org.hotswap.urlclassloader.Hot";
	private Class<?> hotClazz = null;
	private HotSwapURLClassLoader hotSwapCL = null;

//	@Override
	public void run() {
		try {
//			while (true) {
				initLoad();
				Object hot = hotClazz.newInstance();
				Method m = hotClazz.getMethod("hot");
				m.invoke(hot); // ��ӡ�������Ϣ
				Thread.sleep(10000);// ÿ��10�����¼���һ��
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����class
	 */
	public void initLoad() throws Exception {
		hotSwapCL = HotSwapURLClassLoader.getClassLoader();
		// ���Hot�౻�޸��ˣ���ô�����¼��أ�hotClassҲ�᷵���µ�
		hotClazz = hotSwapCL.loadClass(className);
	}
}