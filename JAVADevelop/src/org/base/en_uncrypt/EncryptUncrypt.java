package org.base.en_uncrypt;

public class EncryptUncrypt {
	public static String encryptUncrypt(String value,char secret) {
		byte[] bt = value.getBytes();
		for(int i = 0;i<bt.length;i++) 
			bt[i] = (byte)(bt[i]^(int)secret);
		return new String(bt,0,bt.length);
	}
	public static void main(String[] args) {
		String value = "偶尔发明屏风马";
		char secret='8';
		System.out.println(value);
		String encryptResult = EncryptUncrypt.encryptUncrypt(value, secret);
		System.out.println("加密后的值:"+encryptResult);
		String uncryptResult = EncryptUncrypt.encryptUncrypt(encryptResult, secret);
		System.out.println("解密后的值:"+uncryptResult);
	}
}
