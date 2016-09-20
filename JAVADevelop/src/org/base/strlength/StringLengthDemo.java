package org.base.strlength;

public class StringLengthDemo {
	public static int getStringLen(String s) {
		int len = 0;
		if(s==null||s.length()==0) {
			len = 0;
		}
		else {
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
//				System.out.println(c+":"+Character.isLetter(c));
//				if((c>=0&&c<=9)||(c>='a'&&c<='z')||(c>='A'&&c<='Z'))
				if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
					len++;
				else if(Character.isLetter(c))
					len+=2;
				else
					len++;
			}
		}
		return len;
	}
	public static void main(String[] args) {
		String s = "个4沟通bgytk宝鸡";
		System.out.println("'"+s+"'的实际长度:"+StringLengthDemo.getStringLen(s));
	}
}
