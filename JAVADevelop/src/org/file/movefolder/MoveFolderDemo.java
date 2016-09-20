package org.file.movefolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MoveFolderDemo {

	/**
	 * 复制文件夹方法
	 * @param oldFolder 源文件夹
	 * @param newFolder 目标文件夹
	 */
	private void copyFolder(String oldFolder,String newFolder) {
		try {
			File file = new File(newFolder);
			if(!file.exists()) {
				file.mkdirs();
			}
			File oldFile = new File(oldFolder);
			String[] files = oldFile.list();
			File tempFile = null;
			for(int i=0;i<files.length;i++) {
				//如果源文件夹以文件分隔符结尾
				if(oldFolder.endsWith(File.separator)) {
					//直接连接文件名创建临时文件对象
					tempFile = new File(oldFolder+files[i]);
				}
				else {
					//连接文件名时使用分隔符并创建临时文件对象
					tempFile = new File(oldFolder+File.separator+files[i]);
				}
				//创建临时文件对象是文件
				if(tempFile.isFile()) {
					FileInputStream in = new FileInputStream(tempFile);
					//创建输入流，读取文件内容；创建输出流，用于写文件内容
					FileOutputStream out = new FileOutputStream(newFolder+"/"+tempFile.getName().toString());
					byte[] bt = new byte[1024];
					int len = in.read(bt);//读取文件内容
					while(len!=-1) {
						out.write(bt,0,len);//写到目标位置
						len = in.read(bt);//读取文件内容
					}
					out.flush();//保存到磁盘
					out.close();//关闭流
					in.close();//关闭流
				}
				if(tempFile.isDirectory()) {
					//递归调用方法
					copyFolder(oldFolder+"/"+files[i],newFolder+"/"+files[i]);
				}
			}
			System.out.println("文件夹复制成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件夹
	 * @param file
	 */
	private void deleteFolder(File file) {
		if(file.exists()) {
			if(file.isFile()) {//是文件
				file.delete();//删除文件
			}
			else if(file.isDirectory()) {//是文件夹
				File files[] = file.listFiles();//获得子文件夹
				for(int i=0;i<files.length;i++) {
					deleteFolder(files[i]);//递归调用方法
				}
			}
			file.delete();//删除文件夹
		}
	}
	
	public static void main(String[] args) {
		MoveFolderDemo demo = new MoveFolderDemo();
		demo.copyFolder("D:/KSafeRecycle", "D:/KSafeRecycle");
		demo.deleteFolder(new File("D:/KSafeRecycle"));
	}
}
