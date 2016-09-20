package org.base.money;

public class ChangeMoney {
	public static String change(String money) {
		String[] scale = {"·Ö","½Ç","Ôª","Ê°","°Û","Çª","Íò","Ê°","°Û","Çª","ÒÚ","Ê°","°Û","Çª","Õ×","Ê°","°Û","Çª"};
		String[] num = {"Áã","Ò¼","·¡","Èþ","ËÁ","Îé","Â½","Æâ","°Æ","¾Á"};
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
		System.out.println("1234567.89×ª»»Îª´óÐ´½ð¶î£º"+ChangeMoney.change("1204567.89"));
	}
}
