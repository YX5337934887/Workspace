package org.base.net.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = null;
			Socket clientSocket = null;
			String str = null;
			DataOutputStream out = null;
			DataInputStream in= null;
			serverSocket = new ServerSocket(4331);
			System.out.println("等待客户端连接......");
			clientSocket = serverSocket.accept();
			in = new DataInputStream(clientSocket.getInputStream());
			out = new DataOutputStream(clientSocket.getOutputStream());
			int i = 0;
			while(true) {
				str = in.readUTF();
				out.writeUTF(i+++"");
				System.out.println("收到："+str);
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
