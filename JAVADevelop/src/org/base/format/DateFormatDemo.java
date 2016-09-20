package org.base.format;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatDemo {
	public static void main(String[] args) {
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		String value = df.format(date);
		System.out.println("ת��Ϊ�����ڸ�ʽ��Ч��:"+value);
		df = DateFormat.getDateInstance();
		value = df.format(date);
		System.out.println("ת��Ϊ��׼���ڵ�Ч��:"+value);
		df = DateFormat.getDateInstance(DateFormat.SHORT);
		value = df.format(date);
		System.out.println("��ʽ��Ϊ�����ڵ�Ч��:"+value);
		df = DateFormat.getTimeInstance(DateFormat.SHORT);
		value = df.format(date);
		System.out.println("���������ǵ�ʱ��Ч��:"+value);
		df = DateFormat.getTimeInstance();
		value = df.format(date);
		System.out.println("��ʽ��Ϊ��׼ʱ���Ч��:"+value);
	}
}
