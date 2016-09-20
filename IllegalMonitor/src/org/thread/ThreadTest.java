package org.thread;

public class ThreadTest {

	public static void main(String[] args) {
//		ThreadDemo d = null;
//		new Thread(d).start();

		new Thread(new ThreadDemo()).start();

	}
}

class ThreadDemo implements Runnable {
	private int i = 0;

	public synchronized void run() {
		try {
//			Thread.sleep(100);
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + ":" + i);

	}
}

