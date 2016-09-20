package org.file.filestream;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteFileDemo {
	
	public void writeInfo() {
		try {
			FileOutputStream fout = new FileOutputStream("D:/test.txt");
			DataOutputStream out = new DataOutputStream(fout);
			out.write(888);
			out.writeUTF("²Á²Á²Á²Á");
			out.writeBoolean(false);
			out.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readInfo() {
		try {
			FileInputStream fin = new FileInputStream("D:/test.txt");
//			DataInputStream in = new DataInputStream(fin);
//			System.out.println(in.readInt());
//			System.out.println(in.readUTF());
//			System.out.println(in.readBoolean());
//			in.close();
			InputStreamReader isr = new InputStreamReader(fin);
			char []cha = new char[1024];
		    int len = isr.read(cha);
		    System.out.println(new String(cha,0,len));
		    isr.close();
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WriteFileDemo demo = new WriteFileDemo();
		demo.writeInfo();
		demo.readInfo();
	}
}
