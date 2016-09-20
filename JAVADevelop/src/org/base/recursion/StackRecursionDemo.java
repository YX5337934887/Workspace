package org.base.recursion;

import java.util.Stack;

public class StackRecursionDemo {
	public static void main(String[] args) {
		Long a = new Long(1);
		Long b = new Long(1);
		//������ջ
		Stack<Long> stack = new Stack<Long>();
		stack.push(a);
		stack.push(b);
		int i=1;
		int items = 8;
		if(items==1||items==2) {
			System.out.println("쳲���������"+items+"���ֵ�ǣ�"+1);
		}
		else if(items>2) {
			while(i<=items-1) {
				a=stack.pop();
				b=stack.pop();
				Long z = a+b;
				stack.push(a);
				stack.push(z);
				i++;
			}
			System.out.println("쳲���������"+items+"���ֵ�ǣ�"+stack.pop());
		}
	}
}
