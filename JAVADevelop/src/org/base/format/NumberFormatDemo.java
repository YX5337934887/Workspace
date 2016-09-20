package org.base.format;

import java.text.NumberFormat;

public class NumberFormatDemo {
	public static void main(String[] args) {
		double num = 123.456789;
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		String value = nf.format(num);
		System.out.println("��ʽ��Ϊ���ҵ�Ч��:"+value);
		nf = NumberFormat.getIntegerInstance();
		value = nf.format(num);
		System.out.println("��ʽ��Ϊ������Ч��:"+value);
		nf = NumberFormat.getPercentInstance();
		value = nf.format(.12);
		System.out.println("��ʽ��Ϊ�ٷ�����Ч��:"+value);
	}
}
