package org.base.statics.constant;

import java.util.Calendar;

class Employee {
	public static final Employee employee = new Employee();//先执行构造方法，CURRENT_YEAR值为0
	public static final int CURRENT_YEAR = currentYear();
	private int workAges;
	private Employee() {
		workAges = CURRENT_YEAR - 2005;
	}
	
	private static int currentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	private int getWorkAges() {
		return workAges;
	}
	
	public static void main(String[] args) {
		System.out.println(employee.getWorkAges());
	}

}