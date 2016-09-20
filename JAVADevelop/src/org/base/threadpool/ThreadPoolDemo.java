package org.base.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(5);
		es.submit(new ShowInfoThread());
		es.submit(new PrintInfoThread());
		es.shutdown();
	}

}
