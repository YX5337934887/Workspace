package org.base.notify;

public class Product {
	private int value = 0;
	private String productName = null;
	public synchronized void setProduct(String productName,int value) {
		if(this.value!=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.productName = productName;
		this.value = value;
		System.out.println("Éú²ú"+this.productName+this.value);
		notify();
	}
	public synchronized void getProduct(){
		if(this.value==0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("¹ºÂò"+this.productName+this.value);
		this.value=0;
		notify();
	}
}
