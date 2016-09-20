package org.file.filelength;

import java.io.File;

public class FileLengthDemo {
	private long len = 0;//����ļ���С
	
	public long getFileLength(File file) {
		if(file.isFile()) {
			len += file.length();//���ļ���С�����ۼ�
		}
		else if(file.isDirectory()) {
			File[] files = file.listFiles();//�����ļ���
			for(int i = 0;i<files.length;i++) {
				getFileLength(files[i]);//�ݹ���÷��������ļ��д�С
			}
		}
		return len;
	}
	
	public long getLength(String file) {
		return getFileLength(new File(file));
	}
	
	public static void main(String[] args) {
		FileLengthDemo demo = new FileLengthDemo();
		System.out.println("�ļ��д�С��:"+demo.getLength("D:/KsafeSoftDownloads/baiduyunguanjia_jinshanshichang_5.3.2.4a.exe")+"�ֽ�");
	}
}
