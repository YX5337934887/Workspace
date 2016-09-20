package org.file.zipfolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFolderDemo {
	
	/**
	 * �ݹ�ѹ���ļ���
	 * @param file ѹ���������ļ���File����
	 * @param out ѹ����
	 * @param basePath �ݹ��õ�·��
	 */
	public void zipFolder(File file,ZipOutputStream out,String basePath) {
		try {
			if(file.isDirectory()) {
				File[] files = file.listFiles();//����ļ��б�
				out.putNextEntry(new ZipEntry(basePath+"/"));//���Zip��Ŀ
				if(basePath.length()==0) {
					basePath = "";//·��Ϊ��
				}
				else {
					basePath = basePath+"/";//��Ϊ��ʱ��õ�·��
				}
				for(int i=0;i<files.length;i++){
					//�ݹ���÷���ѹ��
					zipFolder(files[i],out,basePath+files[i].getName());
				}
			}
			else {
				out.putNextEntry(new ZipEntry(basePath));//���Zip��Ŀ
				FileInputStream in = new FileInputStream(file);
				int len = in.read();//��ȡ��Ϣ
				while(len!=-1) {
					out.write(len);//д�����
					len = in.read();
				}
				in.close();//�ر���
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ѹ���ļ���
	 * @param inputFile ��Ҫѹ�����ļ���
	 * @param zipFileName ѹ������ļ���
	 */
	public void zipFolder(String inputFile,String zipFileName) {
		try {
			File file= new File(inputFile);//�����ļ�����
			FileOutputStream fout = new FileOutputStream(zipFileName);//����ѹ��������
			ZipOutputStream out = new ZipOutputStream(fout);//����ѹ�����������
			zipFolder(file,out,"");//����ѹ������
			out.close();//�ر�ѹ����
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void unzipFolder(String zipFileName,String outputDirectory) {
		try {
			FileInputStream fin = new FileInputStream(zipFileName);
			ZipInputStream in = new ZipInputStream(fin);
			ZipEntry zEntry = in.getNextEntry();
			while(zEntry!=null){
				if(zEntry.isDirectory()){
					String name = zEntry.getName();
					name = name.substring(0,name.length()-1);
					File file = new File(outputDirectory + File.separator+name);
					file.mkdir();
				}
				else{
					File file = new File(outputDirectory+File.separator+zEntry.getName());
					file.createNewFile();
					FileOutputStream out = new FileOutputStream(file);
					int len = in.read();
					while(len!=-1){
						out.write(len);
						len = in.read();
					}
					out.close();
				}
				zEntry = in.getNextEntry();
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ZipFolderDemo demo = new ZipFolderDemo();
		demo.zipFolder("D:/KsafeSoftDownloads", "D:/KsafeSoftDownloads.zip");
	}
}
