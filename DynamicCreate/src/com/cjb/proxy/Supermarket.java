package com.cjb.proxy;

public class Supermarket implements Store {

	@Override
	public void sell() {
		System.out.println("sel in supermarket.....");
	}

}
