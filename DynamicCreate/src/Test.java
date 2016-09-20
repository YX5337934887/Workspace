import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    String s = null;
	    do{
			createFile();
	    	s = input.nextLine();
	    }
	    while (s != null);
	}
	public static void createFile() {
		try {
			Class<?> cla = Class.forName("financemanage.financialApproval.taxZzsManageActions.Calc");
			Object obj=cla.newInstance();
			Method method = cla.getMethod("getPrice");
			System.out.println(method.invoke(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
