package org.hotswap.urlclassloader;
public class TestHotSwap {
    public static void main(String[] args) throws Exception {
        //�����̣߳����class�ļ����޸ģ������滻
//    	new MonitorHotSwap().run();
        Thread t = new Thread(new MonitorHotSwap());
        t.start();
    }
}
