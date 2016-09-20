package org.file.deletefolder;

import java.io.File;

public class DeleteFolderDemo {
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
				file.delete();//删除文件夹
			}
//			System.out.println(file.delete());//删除文件夹
		}
	}
	public static void main(String[] args) {
		File file = new File("D:/download");
		new DeleteFolderDemo().deleteFolder(file);
	}
}
