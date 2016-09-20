package org.base.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InetAddress intAddress;
		try {
			intAddress = InetAddress.getLocalHost();
			String localName = intAddress.getHostName();//获取本地主机名
			String localIp = intAddress.getHostAddress();
			System.out.println("本机名："+localName);
			System.out.println("IP："+localIp);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
