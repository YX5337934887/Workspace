package com.sky.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadSQLFile {
	/**
	 * Oracle数据库连接URL
	 */
	private final static String DB_URL = "jdbc:oracle:thin:@localhost:1521:ORACL";
	/**
	 * Oracle数据库连接驱
	 */
	private final static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	/**
	 * 数据库用户名
	 */
	private final static String DB_USERNAME = "gts1031";
	/**
	 * 数据库密码
	 */
	private final static String DB_PASSWORD = "gts1031";

	public static void main(String[] args) {
		try {
			ReadSQLFile rsf = new ReadSQLFile();
			Connection conn = rsf.getConnection();
			File f = new File("D:/init.sql");
			InputStream is = new FileInputStream(f);
			StringBuffer bu = new StringBuffer();
			byte[] buf = new byte[1024];
			int br = 0;
			while ((br = is.read(buf)) != -1) {
				bu.append(new String(buf, 0, br));
			}
			String str = bu.toString();
			String[] fileName = str.split("@");
			if (fileName != null && fileName.length > 0) {
				for (int i = 0; i < fileName.length; i++) {
					StringBuffer sb = new StringBuffer();
					File file = new File("D:/" + fileName[i].trim());
					InputStream in = new FileInputStream(file);
					byte[] buff = new byte[1024];
					int byteRead = 0;
					while ((byteRead = in.read(buff)) != -1) {
						sb.append(new String(buff, 0, byteRead));
						Statement stmt = conn.createStatement();
						String sqlStr = sb.toString();
						String[] sql = sqlStr.split(";");
						if (sql != null && sql.length > 0) {
							for (int j = 0; j < sql.length; j++) {
								try {
									stmt.executeUpdate(sql[j]);
								} catch (Exception e) {
									// 打印日志
									e.printStackTrace();
									continue;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {
		/**
		 * 声明Connection连接对象
		 */
		Connection conn = null;
		try {
			/**
			 * 加载驱动
			 */
			Class.forName(DB_DRIVER);
			/**
			 * 获取数据库连接
			 */
			conn = DriverManager
					.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
