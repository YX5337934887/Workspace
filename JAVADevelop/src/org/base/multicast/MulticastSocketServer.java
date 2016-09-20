package org.base.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastSocketServer extends Thread {
	String weather = "天气预报，明天将会下雨，出门不要忘记带伞。";
	int port = 9898;
	InetAddress iaddress = null;
	MulticastSocket socket = null;
	MulticastSocketServer() {
		try {
			iaddress = InetAddress.getByName("224.0.0.0");
			socket = new MulticastSocket(port);
			socket.setTimeToLive(1);
			socket.joinGroup(iaddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		while(true) {
			byte data[] = weather.getBytes();
			DatagramPacket packet = new DatagramPacket(data,data.length,iaddress,port);
			System.out.println("正在发送内容："+new String(data));
			try {
				socket.send(packet);
				sleep(3000);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
