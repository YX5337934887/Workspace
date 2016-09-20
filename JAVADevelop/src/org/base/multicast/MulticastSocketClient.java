package org.base.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastSocketClient implements Runnable {
	int port;
	InetAddress group = null;
	MulticastSocket socket = null;
	Thread thread;
	public MulticastSocketClient() {
		thread = new Thread(this);
		port = 9898;
		try {
			group = InetAddress.getByName("224.0.0.0");
			socket = new MulticastSocket(port);
			socket.joinGroup(group);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true){
			byte data[] = new byte[0124];
			DatagramPacket packet =  new DatagramPacket(data,data.length,group,port);
			try {
				socket.receive(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String message = new String(packet.getData(),0,packet.getLength());
			System.out.println("正在接受的内容："+message);
		}
	}
	public static void main(String[] args) {
		new Thread(new MulticastSocketServer()).start();
		new Thread(new MulticastSocketClient()).start();
	}
}
