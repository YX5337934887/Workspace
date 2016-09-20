package org.calc.parse;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	    String s = null;
	    CreateFile c = new CreateFile();
	    try {
			do{
				s = input.nextLine();
				System.out.println(c.getResult(s));
			}
			while (s != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
