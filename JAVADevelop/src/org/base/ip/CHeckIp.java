package org.base.ip;

public class CHeckIp {
	public static String matches(String text) {
		if(text!=null&&!text.isEmpty()) {
			String regex = 
					"^(1\\d{2}|2[0-4]\\d|25[0-5]||[1-9]\\d|[1-9])\\."+
					"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."+
					"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."+
					"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
			if(text.matches(regex)) {
				return text+"\n是一个合法的IP地址！";
			}
			return text + "\n不是一个合法的IP地址！";
		}
		return "请输入要验证的IP地址！";
	}
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		System.out.println(matches(ip));
	}
}
