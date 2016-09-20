package org.base.notify;

class ProducerThread extends Thread{
	private Product product;
	public ProducerThread(Product product) {
		this.product = product;
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

class ConsumerThread extends Thread{
	private Product product;
	public ConsumerThread(Product product) {
		this.product = product;
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
