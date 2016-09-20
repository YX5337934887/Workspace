package org.base.reflect;

public class MessageDemo {
	private String message;
	public MessageDemo() {
		message="use reflect";
	}
	public String getMessage() {
		return message;
	}
	public static void main(String[] args) {
		Class<MessageDemo> c = MessageDemo.class;
		try {
			MessageDemo demo = c.newInstance();
			System.out.println(demo.getMessage());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
