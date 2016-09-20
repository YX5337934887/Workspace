package org.base.serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
	public static void main(String[] args) {
		try {
			File file= new File("stu.txt");
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream obj = new ObjectInputStream(in);
			Student stu = (Student) obj.readObject();
			System.out.println(stu.getId());
			System.out.println(stu.getName());
			System.out.println(stu.getInfo());
			obj.close();
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
