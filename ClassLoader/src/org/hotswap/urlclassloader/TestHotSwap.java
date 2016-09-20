package org.hotswap.urlclassloader;
public class TestHotSwap {
    public static void main(String[] args) throws Exception {
        //开启线程，如果class文件有修改，就热替换
//    	new MonitorHotSwap().run();
        Thread t = new Thread(new MonitorHotSwap());
        t.start();
    }
}
