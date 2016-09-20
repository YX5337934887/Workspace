package org.base.format;

public class RoundTool {
	public static String round(double value,int dotNum) {
		String strValue = String.valueOf(value);
		int pos = strValue.indexOf('.');
		int len = strValue.length();
		int dotLen = len - 1 - pos;
		double endValue = 0.0;
		String endNum = "";
		if(dotNum < dotLen) {
			String cNum = strValue.substring(pos+dotNum+1,pos+dotNum+2);
			int iNum = Integer.valueOf(cNum);
			String sNum = strValue.substring(0,pos+dotNum+1);
			endValue=Double.valueOf(sNum);
			if(iNum>=5) {
				String endPos = "";
				String dotValue = "";
				for(int i = 1;i<dotNum;i++) {
					dotValue = dotValue+"0";
				}
				endPos = "0."+dotValue+"1";
				endValue = endValue+Double.valueOf(endPos);
				strValue = String.valueOf(endValue);
				pos = strValue.indexOf('.');
				len = strValue.length();
				dotLen = len-1-pos;
				if(dotLen<dotNum) {
					for(int i=pos+dotLen+1;i<pos+dotNum+1;i++) {
						endNum=String.valueOf(endValue)+0;
					}
				}
				else {
					endNum = String.valueOf(endValue).substring(0,pos+dotNum+1);
				}
			}
		}
		else if(dotNum == dotLen) {
			endNum = String.valueOf(value);
		}
		else {
			for(int i = 1;i<=dotNum - dotLen;i++) {
				strValue = strValue + "0";
			}
			endNum = strValue;
		}
		return endNum;
	}
	public static void main(String[] args) {
		System.out.println("数值123.456789保留2位小数:\t"+RoundTool.round(123.456789, 2));
		System.out.println("数值123.456789保留3位小数:\t"+RoundTool.round(123.456789, 3));
		System.out.println("数值123保留3位小数:\t\t"+RoundTool.round(123,3));
		System.out.println("数值123.5保留3位小数:\t\t"+RoundTool.round(123.5,3));
	}
}
