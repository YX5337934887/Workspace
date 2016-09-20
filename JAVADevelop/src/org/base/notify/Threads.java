package org.base.notify;

class Producer extends Thread {
	private static Product product;
	private static Producer p = new Producer(product);
	public Producer(Product product) {
		Producer.product = product;
	}
	public Producer(Thread t,Product product) {
//		super(t);
		super(p);
		Producer.product = product;
	}
	public void run() {
		for(int id=1;id<=3;id++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			product.setProduct("Áã¼þ", id);
		}
	}
}

class Consumer extends Thread {
	private static Product product;
	private static Consumer p = new Consumer(product);
	public Consumer(Product product) {
		Consumer.product = product;
	}
	public Consumer(Thread t,Product product) {
//		super(t);
		super(p);
		Consumer.product = product;
	}
	public void run() {
		for(int id=1;id<=3;id++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			product.getProduct();
		}
	}
}
