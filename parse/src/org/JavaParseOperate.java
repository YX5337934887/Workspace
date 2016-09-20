package org;

import java.util.Stack;

public class JavaParseOperate {
	public static void main(String[] args) {
		JavaParseOperate parse=new JavaParseOperate();
		parse.calcFormula("1 + 2 ");

		// show the Operataror
		System.out.println("number as following:");
		while (!parse.s1.empty()) {
			System.out.println(parse.s1.pop());
		}
		System.out.println("Operator as following:");
		while (!parse.s2.empty()) {
			System.out.println(parse.s2.pop());
		}
	}

	private Stack<Double> s1;
	private Stack<Character> s2;

	public JavaParseOperate() {
		s1 = new Stack<Double>(); //存放运算数
		s2 = new Stack<Character>(); //存放运算符
	}

	public Stack<Object> calcFormula(String input) {

		Stack<Object> formulaStack;

		formulaStack = new Stack<Object>(); //存放逆波兰表达式
		
		// 先实现对四则运算表达式的解析
		char temp;
		StringBuffer tempNum = new StringBuffer(); //存放临时操作数
		Double num = 0.0;

		for (int i = 0; i < input.length(); i++) {
			temp = input.charAt(i);
			if (' ' == temp) {
				continue;
			}
			else {
				if (('=' == temp) && (0 != tempNum.length())) {
					num = Double.parseDouble(tempNum.toString());
					formulaStack.push(num);
				}
				if (isOperator(temp)) {
					if (0 != tempNum.length()) {
						num = Double.parseDouble(tempNum.toString());
						tempNum.setLength(0);
						formulaStack.push(num);
					}
					formulaStack.push(temp);
				} else {
					tempNum.append(temp);
				}
			}
		}
		if (0 != tempNum.length()) {
			formulaStack.push(Double.parseDouble(tempNum.toString()));
		}
		// end of for(int i = 0; i < input.length(); i++){
		return formulaStack;
	}

	public void calcFormula1(String input) {

		// 先实现对四则运算表达式的解析
		char temp;
		StringBuffer sv = new StringBuffer();
		Double dv = 0.0;

		for (int i = 0; i < input.length(); i++) {
			temp = input.charAt(i);

			if (('=' == temp) && (0 != sv.length())) {
				dv = Double.parseDouble(sv.toString());
				s1.push(dv);
			}
			if (' ' == temp) {
				continue;
			}
			if (isOperator(temp)) {
				if (0 != sv.length()) {
					dv = Double.parseDouble(sv.toString());
					sv.setLength(0);
					s1.push(dv);
					dv = 0.0;
				}
				s2.push(temp);
			} else {
				sv.append(temp);
			}
		}
		if (0 != sv.length()) {
			dv = Double.parseDouble(sv.toString());
			s1.push(dv);
		}
		// end of for(int i = 0; i < input.length(); i++){
	}

	public boolean isOperator(char temp) {
		return ('(' == temp) || (')' == temp) || ('+' == temp) || ('-' == temp) || ('*' == temp) || ('/' == temp);
	}
}
