package org.base.space;

import java.awt.event.KeyEvent;

public class RemoveAllSpace {
	public static String removeAllSpace(String s) {
		StringBuffer str = new StringBuffer("");
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c!=KeyEvent.VK_SPACE&&c!=KeyEvent.VK_TAB) {
				str.append(String.valueOf(c));
			}
		}
		return str.toString();
	}
	public static void main(String[] args) {
		System.out.println(removeAllSpace("fjeorf fmo	fwae  regfr"));
	}
}
