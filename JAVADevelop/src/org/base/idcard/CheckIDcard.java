package org.base.idcard;

public class CheckIDcard {
	private final int[] weightNumber = new int[]{7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2,1};
	private final int[] checkNumber = new int[]{1,0,'X',9,8,7,6,5,4,3,2};
	public String verift(String cardNumber) {
		if(cardNumber.length()==15) {
			cardNumber = fifteenToEighteen(cardNumber);
		}
		if(cardNumber.length()!=18) {
			return "验证失败";
		}
		String checkDight = cardNumber.substring(17,18);
		if(checkDight.equals(getCheckDigit(cardNumber))) {
			return "验证成功";
		}
		return "验证失败";
	}
	public boolean validayBrithday(String idcard,String brithday) {
		return idcard.substring(6,14).equals(brithday);
	}
	public String getCheckDigit(String cardNumber) {
		int verify = 0;
		cardNumber = cardNumber.substring(0,17);
		int sum = 0;
		int[] wi = new int[17];
		for(int i= 0;i<17;i++) {
			String strid = cardNumber.substring(i,i+1);
			wi[i] = Integer.parseInt(strid);
		}
		for(int i=0;i<17;i++) {
			sum += weightNumber[i] * wi[i];
		}
		verify = sum%11;
		if(verify==2) {
			return "X";
		}
		return String.valueOf(checkNumber[verify]);
	}
	public String fifteenToEighteen(String fifteenNumber) {
		String eighteenNumberBefore = fifteenNumber.substring(0,6);
		String eighteenNumberAfter = fifteenNumber.substring(6,15);
		String eighteenNumber = eighteenNumberBefore+"19" + eighteenNumberAfter;
		eighteenNumber = eighteenNumber+getCheckDigit(eighteenNumber);
		return eighteenNumber;
	}
	public static void main(String[] args) {
		CheckIDcard idcard = new CheckIDcard();
		String id = "2201838041103262";
		System.out.println("身份证号"+id+idcard.verift(id));
		id = "610402199201285196";
		System.out.println("身份证号"+id+idcard.verift(id));
		id = "61040219930804523X";
		System.out.println("身份证号"+id+idcard.verift(id));
	}
}
