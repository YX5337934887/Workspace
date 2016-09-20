import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) {
//		expFile("yys","TRANS_OPER_REG");
//		impFile("E:/yys.dmp","TRANS_OPER_REG");
		impFile();
	}
	/**
	 * �����ݿ⵼����Ŀ����
	 * 
	 * @param map
	 * @return
	 */
	public static String expFile(String filename, String tablename) {
		String info = "";
		String[] cmds = new String[3];
		// ������� ���Ҫ����������� tables��������� ���� tables=(KM_DOC,KM_FOLDER,����,����)
		String commandBuf = "exp yys/yys@localhost:1521/orcl file=E://" + filename
				+ ".dmp tables=(" + tablename + ")";// query=\"\"\" TABLE_EXISTS_ACTION=REPLACE ";
		cmds[0] = "cmd";
		cmds[1] = "/C";
		cmds[2] = commandBuf.toString();
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(cmds);
		} catch (IOException e) {

			e.printStackTrace();
			info = "�������";
		}
		boolean shouldClose = false;
		try {
			InputStreamReader isr = new InputStreamReader(
					process.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.indexOf("????") != -1) {
					shouldClose = true;
					break;
				}
			}
		} catch (IOException ioe) {
			shouldClose = true;
			info = "�������";
		}
		if (shouldClose)
			process.destroy();
		int exitVal;
		try {
			exitVal = process.waitFor();
			System.out.print(exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
			info = "�������";
		}
		return info;
	}

	/**
	 * �������ݿ��ļ�
	 * 
	 * @param map
	 */
	public static String impFile(String filepath, String tablename) {
		String info = "";
		String[] cmds = new String[3];
		String commandBuf = "imp yys/yys@localhost:1521/orcl file=" + filepath + " tables=(" + tablename + ") ignore=y";
		cmds[0] = "cmd";
		cmds[1] = "/C";
		cmds[2] = commandBuf.toString();
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(cmds);
		} catch (IOException e) {
			e.printStackTrace();
			info = "�������";
		}
		boolean shouldClose = false;
		try {
			InputStreamReader isr = new InputStreamReader(process.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.indexOf("????") != -1) {
					shouldClose = true;
					break;
				}
			}
		} catch (IOException ioe) {
			shouldClose = true;
			info = "�������";
		}
		if (shouldClose)
			process.destroy();
		int exitVal;
		try {
			exitVal = process.waitFor();
			System.out.print(exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
			info = "�������";
		}
		return info;
	}
	
	public static String impFile() {
		String info = "";
		String commandBuf = "imp yys/yys@localhost:1521/orcl file=E:/database_backup/TRANS_TABLE/yys_TRANS_TABLE_20160323154427.dmp tables=TRANS_TABLE";
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(commandBuf);
			InputStreamReader isr = new InputStreamReader(process.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println(process.waitFor());
			System.out.println(process.exitValue());
		} catch (Exception e) {
			e.printStackTrace();
			info = "�������";
		}
		return info;
	}
}
