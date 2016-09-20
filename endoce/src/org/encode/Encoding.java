package org.encode;

public class Encoding {
	public static String getEncoding(String str) {
		String encode = "GB2312";
		String []encodes = {"GB2312","ISO-8859-1","UTF-8","GBK"};
		try {
			for(int i=0;i<encodes.length;i++) {
				encode = encodes[i];
				if (str.equals(new String(str.getBytes(encode), encode))) {
					return encode;
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		/*
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		*/
		return "";
	}
}
