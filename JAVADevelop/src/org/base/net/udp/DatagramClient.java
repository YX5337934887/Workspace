package org.base.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DatagramClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DatagramSocket clientSocket;
		try {
			clientSocket = new DatagramSocket();
			String sendStr = "client";
			byte[] sendBuf;
			sendBuf = sendStr.getBytes();
			InetAddress addr = InetAddress.getByName("127.0.0.1");
			int port = 6000;
//			DatagramPacket sendPacket = new DatagramPacket(sendBuf, port);
			DatagramPacket sendPacket = new DatagramPacket(sendBuf,sendBuf.length,addr,port);
			clientSocket.send(sendPacket);
			byte[] recvBuf = new byte[100];
			DatagramPacket recvPacket = new DatagramPacket(recvBuf,recvBuf.length);
			clientSocket.receive(recvPacket);
			String recvStr = new String(recvPacket.getData(),0,recvPacket.getLength());
//			String recvStr = new String(recvPacket.getData());
			System.out.println(" ’µΩ£∫"+recvStr);
			clientSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
