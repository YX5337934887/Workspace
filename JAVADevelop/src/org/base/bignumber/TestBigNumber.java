package org.base.bignumber;

import java.math.*;

class TestBigNumber {
	public static void main(String[] args) {
		BigInteger x=new BigInteger("2500");
		BigInteger y=new BigInteger("500");
		System.out.println(x.add(y));
		BigDecimal num1=new BigDecimal("3.00000000");
		BigDecimal num2=new BigDecimal("2.6");
		System.out.println(num1.subtract(num2));
	}
}
