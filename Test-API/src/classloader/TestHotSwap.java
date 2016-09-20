package classloader;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;


public class TestHotSwap {

	public static void main(String[] args) throws Exception {
		// 开启线程，如果class文件有修改，就热替换
		Thread t = new Thread(new MonitorHotSwap());
		t.start();
	}
}

class MonitorHotSwap implements Runnable {
	// Hot就是用于修改，用来测试热加载
	private String className = "classloader.Hot";
	private Class hotClazz = null;
	private HotSwapURLClassLoader hotSwapCL = null;
	private List<Object> list = new LinkedList();

	@Override
	public void run() {
		try {
			while (true) {
				initLoad();
				Object hot =  hotClazz.newInstance();				
			 
				
				if(!isExisting(hot)){
					list.add(hot);
				}
				
				Method m = hotClazz.getMethod("toString");
				m.invoke(hot, null); // 打印出相关信息
				
				System.out.println("List size="+list.size());				
				System.out.println("==============================================================");

				// 每隔10秒重新加载一次
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载class
	 */
	void initLoad() throws Exception {
		hotSwapCL = HotSwapURLClassLoader.getClassLoader();
		// 如果Hot类被修改了，那么会重新加载，hotClass也会返回新的
		hotClazz = hotSwapCL.loadClass(className);
	}
	
	boolean isExisting(Object obj){
		for(Object tempObj : list){
			if(tempObj.getClass().getClassLoader().equals(obj.getClass().getClassLoader())){
				return true;
			}
		}
		return false;
	}
}