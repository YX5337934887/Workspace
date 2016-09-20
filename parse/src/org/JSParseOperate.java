package org;

import java.util.Stack;

public class JSParseOperate {
	public static void main(String[] args) {
		JSParseOperate parse = new JSParseOperate();

//		System.out.println(parse.calcFormula("1 + 2"));
		
//		System.out.println("����(1 + 2)");
//		System.out.println(parse.evalRpn(parse.dalToRpn("(1 + 2)")));
		
//		System.out.println("����1 + 2 + 3");
//		System.out.println(parse.evalRpn(parse.dalToRpn("1 + 2 + 3")));
		
//		System.out.println("����1 + 2 * 3");
//		System.out.println(parse.evalRpn(parse.dalToRpn("1 + 2 * 3")));
		
		System.out.println("����:1 + 2 * 3 - 4 / 5");
		System.out.println(parse.evalRpn(parse.dalToRpn("1 + 2 * 3 - 4 / 5")));
		
//		System.out.println(parse.evalRpn(parse.dalToRpn("( 1 + 2 )")));
//
//		System.out.println(parse.evalRpn(parse.dal2Rpn("( 1 + 2 ) * ( 3 - 4 ) / 5")));
//		System.out.println(parse.evalRpn(parse.dal2Rpn("( 1 + 2 ) * (( 3 - 4 ) / 5)")));
	}

	public Object evalRpn(Stack<Object> outputStack) {
		while (outputStack.size() > 1) {
			Object cur = outputStack.remove(0);
			if (!isOperator(cur)) {
				outputStack.push(cur);
			} else {
				if (outputStack.size() < 2) {
					System.out.println("unvalid stack length");
				}
				else {
					Object sec = outputStack.pop();
					Object fir = outputStack.pop();
					outputStack.push(getResult(fir,sec, cur));
				}
			}
		}
		if (outputStack.size() != 1) {
			System.out.println("unvalid expression");
		}
		return outputStack.pop();
	}
	
	private Object getResult(Object fir, Object sec, Object cur) {
		double num1 = Double.parseDouble(fir.toString());
		double num2 = Double.parseDouble(sec.toString());
		switch ((Character)cur) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / num2;
		default:
			return 0;
		}
	}

	public boolean isOperator(Object o) {
		if(o instanceof Character) {
			char temp=(Character) o;
			return '(' == temp || ')' == temp || '+' == temp || '-' == temp || '*' == temp || '/' == temp;
		}
		return false;
	}

	/*
	public boolean isOperator(char temp) {
		return '(' == temp || ')' == temp || '+' == temp || '-' == temp || '*' == temp || '/' == temp;
	}
	*/

	Stack<Object> dalToRpn(String exp) {
		Stack<Character> operateStack = new Stack<Character>();
		Stack<Object> resultStack = new Stack<Object>();
		char cur;
		StringBuffer tempNum = new StringBuffer(); //�����ʱ������

		for (int i = 0; i < exp.length(); i++) {
			System.out.println(i);
			cur = exp.charAt(i);
			System.out.println("��ǰֵ��:"+cur);
			System.out.println("�ж��Ƿ��ǿո�");
			if (' ' == cur) {
				System.out.println("�ǿո�,����");
				continue;
			}
			System.out.println("�ж��Ƿ��ǲ�����");
			if (isOperator(cur)) {
				if (cur == '(') {
					System.out.println("��cur:"+cur+"�ŵ�operateStack:"+operateStack);
					operateStack.push(cur);
					System.out.println("operateStack:"+operateStack);
				} else if (cur == ')') {
					System.out.println("cur:"+cur+",operateStack:"+operateStack);
					char po = operateStack.pop();
					System.out.println("��po:"+po+"��operateStack:"+operateStack+"��ȡ��");
					while (po != '(' && operateStack.size() > 0) {
						System.out.println("��po:"+po+"�ŵ�resultStack:"+resultStack+"��");
						resultStack.push(po);
						System.out.println("resultStackֵ��"+resultStack);
						System.out.println("operateStack:"+operateStack);
						po = operateStack.pop();
						System.out.println("��po:"+po+"��operateStack:"+operateStack+"��ȡ��");
					}
//					System.out.println("�ж�po�ǲ���'('");
					if (po != '(') {
						System.out.println("error: unmatched ')'");
					}
				} else {
					System.out.println("��ǰֵ��:"+cur);
					if(operateStack.size() > 0)
						System.out.println("�ж���������ȼ�"+cur+","+operateStack.lastElement()+":"+priority(cur, operateStack.lastElement()));
					while (operateStack.size() > 0 && priority(cur, operateStack.lastElement())) {
						System.out.println("�ж�operateStack��Ϊ�գ��ж���������ȼ�"+cur+","+operateStack.lastElement()+":"+priority(cur, operateStack.lastElement()));
						System.out.println("operateStack:"+operateStack);
						Character a = operateStack.pop();
						System.out.println("��a:"+a+"��operateStack:"+operateStack+"��ȡ��");
						System.out.println("��a:"+a+"�ŵ�resultStack:"+resultStack+"��");
						resultStack.push(a);
						System.out.println("resultStack:"+resultStack);
					}
					System.out.println("��cur:"+cur+"�ŵ�operateStack:"+operateStack+"��");
					operateStack.push(cur);
					System.out.println("operateStack:"+operateStack);
				}
			} else {
				System.out.println("��cur:"+cur+"�ŵ�resultStack:"+resultStack+"��");
				resultStack.push(cur);
				System.out.println("resultStack:"+resultStack);
			}
		}
		
		if (operateStack.size() > 0) {
			if (operateStack.lastElement() == ')' || operateStack.lastElement() == '(') {
				System.out.println("error: unmatched ()");
			}
			while (operateStack.size() > 0) {
				System.out.println("operateStack:"+operateStack);
				Character a = operateStack.pop();
				System.out.println("��operateStack:"+operateStack+"��ȡ��a:"+a);
				System.out.println("��a:"+a+"�ŵ�resultStack:"+resultStack+"��");
				resultStack.push(a);
				System.out.println("resultStack:"+resultStack);
			}
		}
		System.out.println("resultStack:"+resultStack);
		return resultStack;
	}
	
	/*
	boolean isOperator(char value) {
		String operatorString = "/*+-()";
		return operatorString.indexOf(value) > -1;
	}
	*/

	int getPrioraty(char value) {
		switch (value) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	boolean priority(char o1, char o2) {
		return getPrioraty(o1) <= getPrioraty(o2);
	}

	Stack<Object> dal2Rpn(String exp) {
		Stack<Character> inputStack = new Stack<Character>();
		Stack<Character> outputStack = new Stack<Character>();
		Stack<Object> outputQueue = new Stack<Object>();

		for (int i = 0, len = exp.length(); i < len; i++) {
			char cur = exp.charAt(i);
			if (cur != ' ') {
				// System.out.println(cur);
				inputStack.push(cur);
			}
		}
//		System.out.println("step one");
		while (inputStack.size() > 0) {
			char cur = inputStack.remove(0);
			if (isOperator(cur)) {
				if (cur == '(') {
					// System.out.println(cur);
					outputStack.push(cur);
				} else if (cur == ')') {
					char po = (Character) outputStack.pop();
					while (po != '(' && outputStack.size() > 0) {
						// System.out.println(po);
						outputQueue.push(po);
						po = (Character) outputStack.pop();
						// System.out.println(po);
					}
					if (po != '(') {
						System.out.println("error: unmatched ')'");
					}
				} else {
					while (outputStack.size() > 0 && priority(cur, (char) outputStack.indexOf(outputStack.size() - 1))) {
						Character a = outputStack.pop();
						// System.out.println(a);
						outputQueue.push(a);
					}
					outputStack.push(cur);
				}
			} else {
				// System.out.println(cur);
				outputQueue.push(cur);
			}
		}
//		System.out.println("step two");
		if (outputStack.size() > 0) {
			if (outputStack.indexOf(outputStack.size() - 1) == ')' || outputStack.indexOf(outputStack.size() - 1) == '(') {
				System.out.println("error: unmatched ()");
			}
			while (outputStack.size() > 0) {
				Character a = outputStack.pop();
				// System.out.println(a);
				outputQueue.push(a);
			}
		}
//		System.out.println("step three");
		return outputQueue;
	}
}
