package org.file.deletefolder;

import java.io.File;

public class DeleteFolderDemo {
	private void deleteFolder(File file) {
		if(file.exists()) {
			if(file.isFile()) {//���ļ�
				file.delete();//ɾ���ļ�
			}
			else if(file.isDirectory()) {//���ļ���
				File files[] = file.listFiles();//������ļ���
				for(int i=0;i<files.length;i++) {
					deleteFolder(files[i]);//�ݹ���÷���
				}
				file.delete();//ɾ���ļ���
			}
//			System.out.println(file.delete());//ɾ���ļ���
		}
	}
	public static void main(String[] args) {
		File file = new File("D:/download");
		new DeleteFolderDemo().deleteFolder(file);
	}
}
