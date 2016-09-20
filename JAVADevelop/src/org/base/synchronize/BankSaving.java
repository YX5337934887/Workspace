package org.base.synchronize;

import java.util.concurrent.locks.ReentrantLock;

public class BankSaving {
	private double syncbankMoney = 10000;
	private double bankMoney = 10000;
	private double lockbankMoney = 100000;
	public synchronized void syncsaving(double saveMoney) {
		if(saveMoney>0) {
			syncbankMoney=syncbankMoney+saveMoney;
			System.out.println("syncbankMoney:"+syncbankMoney);
		}
	}

	public void saving(double saveMoney) {
		if(saveMoney>0) {
			bankMoney=bankMoney+saveMoney;
			System.out.println("bankMoney:"+bankMoney);
		}
	}
	
	//创建同步锁
	private final ReentrantLock lock=new ReentrantLock();
	public void locksaving(double saveMoney) {
		lock.lock();//添加锁
		if(saveMoney>0) {
			lockbankMoney=lockbankMoney+saveMoney;
			System.out.println("lockbankMoney:"+lockbankMoney);
		}
		lock.unlock();//释放锁
	}
}
