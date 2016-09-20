package org.file.movefolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MoveFolderDemo {

	/**
	 * �����ļ��з���
	 * @param oldFolder Դ�ļ���
	 * @param newFolder Ŀ���ļ���
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
				//���Դ�ļ������ļ��ָ�����β
				if(oldFolder.endsWith(File.separator)) {
					//ֱ�������ļ���������ʱ�ļ�����
					tempFile = new File(oldFolder+files[i]);
				}
				else {
					//�����ļ���ʱʹ�÷ָ�����������ʱ�ļ�����
					tempFile = new File(oldFolder+File.separator+files[i]);
				}
				//������ʱ�ļ��������ļ�
				if(tempFile.isFile()) {
					FileInputStream in = new FileInputStream(tempFile);
					//��������������ȡ�ļ����ݣ����������������д�ļ�����
					FileOutputStream out = new FileOutputStream(newFolder+"/"+tempFile.getName().toString());
					byte[] bt = new byte[1024];
					int len = in.read(bt);//��ȡ�ļ�����
					while(len!=-1) {
						out.write(bt,0,len);//д��Ŀ��λ��
						len = in.read(bt);//��ȡ�ļ�����
					}
					out.flush();//���浽����
					out.close();//�ر���
					in.close();//�ر���
				}
				if(tempFile.isDirectory()) {
					//�ݹ���÷���
					copyFolder(oldFolder+"/"+files[i],newFolder+"/"+files[i]);
				}
			}
			System.out.println("�ļ��и��Ƴɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ���ļ���
	 * @param file
	 */
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
			}
			file.delete();//ɾ���ļ���
		}
	}
	
	public static void main(String[] args) {
		MoveFolderDemo demo = new MoveFolderDemo();
		demo.copyFolder("D:/KSafeRecycle", "D:/KSafeRecycle");
		demo.deleteFolder(new File("D:/KSafeRecycle"));
	}
}
