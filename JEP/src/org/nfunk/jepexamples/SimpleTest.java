package org.nfunk.jepexamples;
import org.nfunk.jep.*;

import com.singularsys.jep.Jep;
import com.singularsys.jep.JepException;

/**
 * A seven line program for testing whether the Jep library can be found
 * by the compiler and at run-time.<br>
 * Upon successful compilation and running of the program, the program should
 * print out one line: "1+2 = 3.0"
 */
public class SimpleTest {
    public static void main(String args[]) {
        JEP myParser = new JEP();
        myParser.parseExpression("1+2");
        System.out.println("1+2 = " + myParser.getValue());
    }
}

class SimpleExample {
	public static void main(String[] args) throws JepException {
		Jep jep = new Jep(); // һ����ѧ���ʽ
		String exp = "((a+b)*(c+b))/(c+a)/b"; // ��������ֵ
		jep.addVariable("a", 10);
		jep.addVariable("b", 10);
		jep.addVariable("c", 10);
		try { // ִ��
			jep.parse(exp);
			Object result = jep.evaluate();
			System.out.println("�������� " + result);
		} catch (JepException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}
}