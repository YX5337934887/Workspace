package org.base.threadpool;

public class ShowInfoThread implements Runnable {
	@Override
	public void run() {
		for(int i=1;i<=3;i++) {
			System.out.println("showinfo:"+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
