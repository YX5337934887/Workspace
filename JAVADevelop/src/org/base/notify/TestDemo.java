package org.base.notify;

public class TestDemo {
	public static void main(String[] args) {
		Product product = new Product();
//		ProducerThread pt = new ProducerThread(product);
//		ConsumerThread ct = new ConsumerThread(product);
//		pt.start();
//		ct.start();
		Producer p = new Producer(product);
		Consumer c = new Consumer(p,product);
		p = new Producer(c,product);
		p.start();
		c.start();
	}
}
