package org.encode;

public class Encoding {
	public static String getEncoding(String str) {
		String encode = "";
		String []encodes = {"ISO-8859-1","UTF-8","Unicode","GBK","GB2312","GB18030"};
		try {
			for(int i=0;i<encodes.length;i++) {
				encode = encodes[i];
				if (str.equals(new String(str.getBytes(encode), encode))) {
//					return encode;
					break;
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
		return encode;
	}
}
