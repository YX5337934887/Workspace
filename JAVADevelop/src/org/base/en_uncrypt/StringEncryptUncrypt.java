package org.base.en_uncrypt;

public class StringEncryptUncrypt {
	public static byte[] encrypt(String value) {
		return value.getBytes();
	}
	public static String uncrype(byte[] bt) {
		return new String(bt,0,bt.length);
	}
	public static void main(String[] args) {
		String value = "¸ñ¶û°¢·ð·Ö";
		System.out.println(value);
		System.out.println(StringEncryptUncrypt.encrypt(value));
		System.out.println(StringEncryptUncrypt.uncrype(StringEncryptUncrypt.encrypt(value)));
	}
}
