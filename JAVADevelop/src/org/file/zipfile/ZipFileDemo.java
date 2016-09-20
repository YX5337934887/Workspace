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
	 * 压缩文件方法
	 * @param file 需要压缩的文件
	 * @param destZip 压缩后的文件
	 */
	public void zip(String file,String destZip){
		try {
			FileOutputStream out = new FileOutputStream(destZip);//创建输出流
			BufferedOutputStream bout = new BufferedOutputStream(out);//创建缓冲流
			ZipOutputStream zout = new ZipOutputStream(bout);//创建Zip流
			FileInputStream in = new FileInputStream(file);//创建输入流
			BufferedInputStream bin = new BufferedInputStream(in);//创建缓冲流
			File f = new File(file);//创建文件对象
			ZipEntry zEntry = new ZipEntry(f.getName());//创建条目
			zout.putNextEntry(zEntry);//开始写入新的Zip文件条目
			int len = bin.read();//读取一个字节信息
			while(len != -1) {
				zout.write(len);//写入Zip输出流
				len = bin.read();//读取下一个字节信息
			}
			zout.closeEntry();//关闭当前Zip条目
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
	 * 解压缩文件方法
	 * @param zipFile 需要解压缩的文件
	 * @param destPath 解压后的位置
	 */
	public void unZip(String zipFile,String destPath) {
		try {
			FileInputStream in = new FileInputStream(zipFile);//创建输入流
			BufferedInputStream bin = new BufferedInputStream(in);//创建缓冲流
			ZipInputStream zin = new ZipInputStream(bin);//创建Zip输入流
			ZipEntry zEntry = zin.getNextEntry();//读取下一个Zip文件对象
			String fileName = zEntry.getName();//获得文件名
			FileOutputStream out = new FileOutputStream(destPath + fileName);//创建文件输出流
			while(zEntry != null) {
				if(zEntry.isDirectory()) {
					File file = new File(destPath + zEntry.getName());
					file.mkdirs();//创建文件
				}
				else {
					int len = zin.read();//读取字节
					while(len!=-1) {
						out.write(len);//写到文件
						len = zin.read();//读取下一个字节
					}
					zin.closeEntry();//关闭当前Zip条目
				}
				zEntry = zin.getNextEntry();//读取下一个Zip条目
			}
			out.flush();//保存到磁盘
			out.close();//关闭流
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
