package org.encode;


public class Test {
	public static void main(String[] args) {
		String str="ÖÐÎÄ±àÂë";
		try {
			System.out.println(str);
			str=new String(str.getBytes("utf-8"),"iso-8859-1");
			System.out.println(Encoding.getEncoding(str)+","+str);
			str=new String(str.getBytes("iso-8859-1"),"utf-8");
			System.out.println(Encoding.getEncoding(str)+","+str);
			str=new String(str.getBytes("utf-8"),"iso-8859-1");
			System.out.println(Encoding.getEncoding(str)+","+str);
			str=new String(str.getBytes("iso-8859-1"),"gb2312");
			System.out.println(Encoding.getEncoding(str)+","+str);
			str=new String(str.getBytes("gb2312"),"gbk");
			System.out.println(Encoding.getEncoding(str)+","+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
