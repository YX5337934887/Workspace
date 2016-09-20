package org.base.chinesecode;

import java.io.UnsupportedEncodingException;

public class ChineseCode {
	public String codeToChinese(String code) {
		String chinese = "";
		for(int i=0;i<code.length();i+=4) {
			byte[] bytes = new byte[2];
			String highCoe = code.substring(i,i+2);
			int tempHigh = Integer.parseInt(highCoe);
			tempHigh+=160;
			bytes[0]=(byte)tempHigh;
			String lowCode = code.substring(i+2,code.length());
			int tempLow=Integer.parseInt(lowCode);
			tempLow+=160;
			bytes[1]=(byte)tempLow;
			String singleChar="";
			try {
				singleChar = new String(bytes,"GB2312");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			chinese+=singleChar;
		}
		return chinese;
	}
	
	public String byteToHexString(byte b) {
		byte[]bt = {b};
		return byteToHexString(bt);
	}
	
	public String byteToHexString(byte[] bt) {
		StringBuffer hexUpper = new StringBuffer("");
		for(int i = 0;i<bt.length;i++) {
			String hex = Integer.toHexString(bt[i]&0xFF);
			if(hex.length()==1) {
				hex='0'+hex;
			}
			hexUpper.append(hex.toUpperCase());
		}
		return hexUpper.toString();
	}
	
	public String chineseToCode(String chinese) {
		byte[] bt;
		StringBuffer code = new StringBuffer("");
		try {
			bt = chinese.getBytes("GB2312");
			for(int i=0;i<bt.length;i++) {
				System.out.println(byteToHexString(bt[i]));
				int a = Integer.parseInt(byteToHexString(bt[i]),16);
				code.append(a-0x80-0x20);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return code.toString();
	}
	
	public static void main(String[] args) {
		ChineseCode code = new ChineseCode();
		System.out.println("区位码2626对应的汉字是:"+code.codeToChinese("5554"));
		System.out.println(code.chineseToCode("汉字"));
	}
}
