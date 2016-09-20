package org.agency.cglib;

public class TestCglib {

	public static void main(String[] args) {
		BookFacadeProxy cglibProxy = new BookFacadeProxy();
		BookFacadeImpl bookCglib = (BookFacadeImpl) cglibProxy.getInstance(new BookFacadeImpl());
		bookCglib.addBook();
	}
}
