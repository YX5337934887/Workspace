package org.base.statics.constant;

import java.util.Calendar;

class Employee {
	public static final Employee employee = new Employee();//��ִ�й��췽����CURRENT_YEARֵΪ0
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