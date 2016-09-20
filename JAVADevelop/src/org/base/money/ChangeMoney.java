package org.base.money;

public class ChangeMoney {
	public static String change(String money) {
		String[] scale = {"��","��","Ԫ","ʰ","��","Ǫ","��","ʰ","��","Ǫ","��","ʰ","��","Ǫ","��","ʰ","��","Ǫ"};
		String[] num = {"��","Ҽ","��","��","��","��","½","��","��","��"};
		String m = "";
		boolean isPoint = false;
		
		if(money.indexOf('.')!=-1) {
			money = money.substring(0,money.indexOf('.'))+money.substring(money.indexOf('.')+1);
			isPoint = true;
		}
		for(int i = money.length();i>0;i--) {
			int data = Integer.parseInt(String.valueOf(money.charAt(money.length()-i)));
			m+=num[data];
			if(isPoint) {
				m+=scale[i-1];
			}
			else {
				m+=scale[i+1];
			}
		}
		return m;
	}
	public static void main(String[] args) {
		System.out.println("1234567.89ת��Ϊ��д��"+ChangeMoney.change("1204567.89"));
	}
}
