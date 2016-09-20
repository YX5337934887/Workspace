package org.file.zipfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileDemo {
	
	/**
	 * ѹ���ļ�����
	 * @param file ��Ҫѹ�����ļ�
	 * @param destZip ѹ������ļ�
	 */
	public void zip(String file,String destZip){
		try {
			FileOutputStream out = new FileOutputStream(destZip);//���������
			BufferedOutputStream bout = new BufferedOutputStream(out);//����������
			ZipOutputStream zout = new ZipOutputStream(bout);//����Zip��
			FileInputStream in = new FileInputStream(file);//����������
			BufferedInputStream bin = new BufferedInputStream(in);//����������
			File f = new File(file);//�����ļ�����
			ZipEntry zEntry = new ZipEntry(f.getName());//������Ŀ
			zout.putNextEntry(zEntry);//��ʼд���µ�Zip�ļ���Ŀ
			int len = bin.read();//��ȡһ���ֽ���Ϣ
			while(len != -1) {
				zout.write(len);//д��Zip�����
				len = bin.read();//��ȡ��һ���ֽ���Ϣ
			}
			zout.closeEntry();//�رյ�ǰZip��Ŀ
			zout.close();
			bout.close();
			out.close();
			bin.close();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ѹ���ļ�����
	 * @param zipFile ��Ҫ��ѹ�����ļ�
	 * @param destPath ��ѹ���λ��
	 */
	public void unZip(String zipFile,String destPath) {
		try {
			FileInputStream in = new FileInputStream(zipFile);//����������
			BufferedInputStream bin = new BufferedInputStream(in);//����������
			ZipInputStream zin = new ZipInputStream(bin);//����Zip������
			ZipEntry zEntry = zin.getNextEntry();//��ȡ��һ��Zip�ļ�����
			String fileName = zEntry.getName();//����ļ���
			FileOutputStream out = new FileOutputStream(destPath + fileName);//�����ļ������
			while(zEntry != null) {
				if(zEntry.isDirectory()) {
					File file = new File(destPath + zEntry.getName());
					file.mkdirs();//�����ļ�
				}
				else {
					int len = zin.read();//��ȡ�ֽ�
					while(len!=-1) {
						out.write(len);//д���ļ�
						len = zin.read();//��ȡ��һ���ֽ�
					}
					zin.closeEntry();//�رյ�ǰZip��Ŀ
				}
				zEntry = zin.getNextEntry();//��ȡ��һ��Zip��Ŀ
			}
			out.flush();//���浽����
			out.close();//�ر���
			zin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ZipFileDemo demo = new ZipFileDemo();
//		demo.zip("D:/KsafeSoftDownloads/baiduyunguanjia_jinshanshichang_5.3.2.4a.exe", "D:/KsafeSoftDownloads/baiduyunguanjia_jinshanshichang_5.3.2.4a.zip");
		demo.unZip("D:/KsafeSoftDownloads/baiduyunguanjia_jinshanshichang_5.3.2.4a.zip", "D:/KsafeSoftDownloads/");
	}
}
