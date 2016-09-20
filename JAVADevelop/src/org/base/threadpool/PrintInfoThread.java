package org.base.threadpool;

public class PrintInfoThread implements Runnable{
	@Override
	public void run() {
		for(int i=1;i<=4;i++) {
			System.out.println("printinfo:"+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
