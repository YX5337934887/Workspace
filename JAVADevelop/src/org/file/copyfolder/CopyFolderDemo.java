package org.file.copyfolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFolderDemo {

	/**
	 * �����ļ��з���
	 * @param oldFolder Դ�ļ���
	 * @param newFolder Ŀ���ļ���
	 */
	public void copyFolder(String oldFolder, String newFolder) {
		try {
			File file = new File(newFolder);
			if (!file.exists()) {
				file.mkdirs();
			}
			File oldFile = new File(oldFolder);
			String[] files = oldFile.list();
			File tempFile = null;
			for (int i = 0; i < files.length; i++) {
				// ���Դ�ļ������ļ��ָ�����β
				if (oldFolder.endsWith(File.separator)) {
					// ֱ�������ļ���������ʱ�ļ�����
					tempFile = new File(oldFolder + files[i]);
				} else {
					// �����ļ���ʱʹ�÷ָ�����������ʱ�ļ�����
					tempFile = new File(oldFolder + File.separator + files[i]);
				}
				// ������ʱ�ļ��������ļ�
				if (tempFile.isFile()) {
					FileInputStream in = new FileInputStream(tempFile);
					// ��������������ȡ�ļ����ݣ����������������д�ļ�����
					FileOutputStream out = new FileOutputStream(newFolder + "/"
							+ tempFile.getName().toString());
					byte[] bt = new byte[1024];
					// int len = in.read(bt);//��ȡ�ļ�����
					// while(len!=-1) {
					// out.write(bt,0,len);//д��Ŀ��λ��
					// len = in.read(bt);//��ȡ�ļ�����
					// }
					int len = 0;
					while ((len = in.read(bt)) != -1) {
						out.write(bt, 0, len);// д��Ŀ��λ��
						// len = in.read(bt);//��ȡ�ļ�����
					}
					out.flush();// ���浽����
					out.close();// �ر���
					in.close();// �ر���
				}
				if (tempFile.isDirectory()) {
					// �ݹ���÷���
					copyFolder(oldFolder + "/" + files[i], newFolder + "/"
							+ files[i]);
				}
			}
			System.out.println("�ļ��и��Ƴɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CopyFolderDemo().copyFolder("D:/KsafeSoftDownloads",
				"E:/KsafeSoftDownloads");
	}
}
