package org.base.finalize;

public class Reclaimer {
	String message = "���Զ��������";
	public static void main(String[] args) {
		Reclaimer r = new Reclaimer();
		System.out.println(r.message);
		r = null;
		System.gc();
	}
	@Override
	protected void finalize() throws Throwable {
		message = null;
		System.out.println(message);
	}
}
