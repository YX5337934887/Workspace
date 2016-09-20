package org.file.filelength;

import java.io.File;

public class FileLengthDemo {
	private long len = 0;//存放文件大小
	
	public long getFileLength(File file) {
		if(file.isFile()) {
			len += file.length();//对文件大小进行累加
		}
		else if(file.isDirectory()) {
			File[] files = file.listFiles();//遍历文件夹
			for(int i = 0;i<files.length;i++) {
				getFileLength(files[i]);//递归调用方法计算文件夹大小
			}
		}
		return len;
	}
	
	public long getLength(String file) {
		return getFileLength(new File(file));
	}
	
	public static void main(String[] args) {
		FileLengthDemo demo = new FileLengthDemo();
		System.out.println("文件夹大小是:"+demo.getLength("D:/KsafeSoftDownloads/baiduyunguanjia_jinshanshichang_5.3.2.4a.exe")+"字节");
	}
}
