package org.base.synchronize;

public class SynchronizedDemo {
	private BankSaving bs = new BankSaving();
	public static void main(String[] args) {
		SynchronizedDemo demo = new SynchronizedDemo();
		SaveMoneyThread th1 = demo.new SaveMoneyThread();
		SaveMoneyThread th2 = demo.new SaveMoneyThread();
		th1.start();
		th2.start();
	}
	class SaveMoneyThread extends Thread {
		public void run() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bs.saving(500);
			bs.locksaving(10000);
			bs.syncsaving(500);
		}
	}
}