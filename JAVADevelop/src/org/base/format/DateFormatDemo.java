package org.base.format;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatDemo {
	public static void main(String[] args) {
		Date date = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
		String value = df.format(date);
		System.out.println("转化为长日期格式的效果:"+value);
		df = DateFormat.getDateInstance();
		value = df.format(date);
		System.out.println("转化为标准日期的效果:"+value);
		df = DateFormat.getDateInstance(DateFormat.SHORT);
		value = df.format(date);
		System.out.println("格式化为短日期的效果:"+value);
		df = DateFormat.getTimeInstance(DateFormat.SHORT);
		value = df.format(date);
		System.out.println("带上下午标记的时间效果:"+value);
		df = DateFormat.getTimeInstance();
		value = df.format(date);
		System.out.println("格式化为标准时间的效果:"+value);
	}
}
