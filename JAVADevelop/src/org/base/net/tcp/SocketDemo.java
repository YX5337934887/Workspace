package org.base.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {
	public static void main(String[] args) {
		String str;
		Socket clientSocket;
		try {
			clientSocket = new Socket("127.0.0.1",4331);
			DataInputStream in = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			out.writeUTF("網請ㄛ網請");
			int i = 0;
			while(true) {
				str = in.readUTF();
				out.writeUTF(i+++"");
				System.out.println("彶善ㄩ"+str);
				Thread.sleep(1000);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
