package org.base.format;

import java.text.NumberFormat;

public class NumberFormatDemo {
	public static void main(String[] args) {
		double num = 123.456789;
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		String value = nf.format(num);
		System.out.println("格式化为货币的效果:"+value);
		nf = NumberFormat.getIntegerInstance();
		value = nf.format(num);
		System.out.println("格式化为整数的效果:"+value);
		nf = NumberFormat.getPercentInstance();
		value = nf.format(.12);
		System.out.println("格式化为百分数的效果:"+value);
	}
}
