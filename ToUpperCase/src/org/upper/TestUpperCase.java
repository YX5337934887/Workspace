package org.upper;

import java.lang.reflect.Field;

public class TestUpperCase {
	private static long times = 299999L;

	public static String lcy_firstLetterToUpper(String str) {
		return String.valueOf(str.charAt(0)).concat(str.substring(1));
	}

	public static String letterToUpper(String str) {
		Character c = Character.toUpperCase(str.charAt(0));
		return c.toString().concat(str.substring(1));
	}

	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		for (long i = 0; i <times ; i++) {
			firstLetterToUpperUseChar("abc" + i);
		}
		System.out.println(System.currentTimeMillis() - millis);

		millis = System.currentTimeMillis();
		for (long i = 0; i < times; i++) {
			firstLetterToUpperUseSubstr("abc" + i);
		}
		System.out.println(System.currentTimeMillis() - millis);

		millis = System.currentTimeMillis();
		for (long i = 0; i < times; i++) {
			firstLetterToUpperUseConcat("abc" + i);
		}
		System.out.println(System.currentTimeMillis() - millis);

		millis = System.currentTimeMillis();
		for (long i = 0; i < times; i++) {
			firstLetterToUpperUseAdd("abc" + i);
		}
		System.out.println(System.currentTimeMillis() - millis);
	}

	static String firstLetterToUpperUseChar(String str) {
		char[] array = str.toCharArray();
		array[0] -= 32;
		return String.valueOf(array);
	}

	static String firstLetterToUpperUseSubstr(String str) {
		return str.substring(0, 1)+str.substring(1);
	}
	
	static String firstLetterToUpperUseConcat(String str) {
		return String.valueOf(str.charAt(0)).concat(str.substring(1));
	}
	
	static String firstLetterToUpperUseAdd(String str) {
		return String.valueOf(str.charAt(0))+str.substring(1);
	}
}
