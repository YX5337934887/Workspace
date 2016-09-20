package org.base.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class DatagramServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatagramSocket serverSocket;
		try {
			int port = 6000;
			serverSocket = new DatagramSocket(port);
			byte[] recvBuf = new byte[100];
			DatagramPacket recvPacket = new DatagramPacket(recvBuf,recvBuf.length);
			serverSocket.receive(recvPacket);
			String recvStr = new String(recvPacket.getData(),0,recvPacket.getLength());
//			String recvStr = new String(recvPacket.getData());
			System.out.println("server("+port+") receive message,"+recvStr);
			port = recvPacket.getPort();
			InetAddress address = recvPacket.getAddress();
			String sendStr = "client("+port+") send message";
			byte[] sendBuf;
			sendBuf = sendStr.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendBuf,sendBuf.length,address,port);
			serverSocket.send(sendPacket);
			serverSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
