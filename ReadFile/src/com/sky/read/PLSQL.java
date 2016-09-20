package com.sky.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PLSQL {

	public static void main(String[] args) {
		new PLSQL().exeSqlplus(
			"zzs",
			"zzs",
			"localhost",
			"1521",
			"orcl",
			"import.sql",
			"D:/Program Files/Apache Software Foundation/Tomcat 6.0/webapps/financemanage_zzs/WEB-INF/classes/financemanage/taxZzsManage/actions/",
			"D:/DBLOG/gts1031.log"
		);
	}

	public void exeSqlplus(String username, String password, String host,
			String port, String sid, String fileName, String dir, String log) {
		FileOutputStream fos = null;
		InputStream in = null;
		Process p = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("sqlplus ");
			sb.append(username);
			sb.append("/");
			sb.append(password);
			sb.append("@");
			sb.append(host);
			sb.append(":");
			sb.append(port);
			sb.append("/");
			sb.append(sid);
			sb.append(" @");
			sb.append("\""+fileName+"\"");
			// String cmd =
			// "sqlplus gts1031/gts1031@ORACL @init-6.0.01.sql >D:/gts1031.log";
			String cmd = sb.toString();
			System.out.println(cmd);
			
			Runtime rt = Runtime.getRuntime();
			// p = rt.exec(cmd,null,new File("D:/db/integrate/"));
			p = rt.exec(cmd, null, new File(dir));
//			in = p.getInputStream();

			InputStreamReader isr = new InputStreamReader(p.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println("输出信息:" + line);
			}
			if(p.waitFor() != 0)
				System.out.println("操作失败！");
			
			
			// fos = new FileOutputStream("D:/gts1031.log");
			/*
			fos = new FileOutputStream(log);
			byte[] b = new byte[1024];
			int br = 0;
			while ((br = in.read(b)) != -1) {
				String str = new String(b, 0, br);
				int i = str.indexOf("SP2-0310");
				int j = str.indexOf("SQL>");
				if (i != -1) {
					p.destroy();
				}
				fos.write(b, 0, br);
				if (j != -1) {
					p.destroy();
				}
			}
			p.waitFor();
			fos.flush();
			fos.close();
			in.close();
			*/
			p.destroy();
			System.out.println("执行结束");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
