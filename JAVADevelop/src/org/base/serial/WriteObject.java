package org.base.serial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		try {
			Student stu = new Student();
			stu.setId(0);
			stu.setName("stu");
			stu.setInfo("...");
			File file= new File("stu.txt");
			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream obj = new ObjectOutputStream(out);
			obj.writeObject(stu);
			System.out.println("对象保存成功");
			obj.close();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
