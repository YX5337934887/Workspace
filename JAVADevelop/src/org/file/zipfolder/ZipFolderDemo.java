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
	 * 递归压缩文件夹
	 * @param file 压缩后生成文件的File对象
	 * @param out 压缩流
	 * @param basePath 递归获得的路径
	 */
	public void zipFolder(File file,ZipOutputStream out,String basePath) {
		try {
			if(file.isDirectory()) {
				File[] files = file.listFiles();//获得文件列表
				out.putNextEntry(new ZipEntry(basePath+"/"));//添加Zip条目
				if(basePath.length()==0) {
					basePath = "";//路径为空
				}
				else {
					basePath = basePath+"/";//不为空时获得的路径
				}
				for(int i=0;i<files.length;i++){
					//递归调用方法压缩
					zipFolder(files[i],out,basePath+files[i].getName());
				}
			}
			else {
				out.putNextEntry(new ZipEntry(basePath));//添加Zip条目
				FileInputStream in = new FileInputStream(file);
				int len = in.read();//读取信息
				while(len!=-1) {
					out.write(len);//写入磁盘
					len = in.read();
				}
				in.close();//关闭流
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 压缩文件夹
	 * @param inputFile 需要压缩的文件夹
	 * @param zipFileName 压缩后的文件名
	 */
	public void zipFolder(String inputFile,String zipFileName) {
		try {
			File file= new File(inputFile);//创建文件对象
			FileOutputStream fout = new FileOutputStream(zipFileName);//创建压缩输入流
			ZipOutputStream out = new ZipOutputStream(fout);//创建压缩输出流对象
			zipFolder(file,out,"");//调用压缩方法
			out.close();//关闭压缩流
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
