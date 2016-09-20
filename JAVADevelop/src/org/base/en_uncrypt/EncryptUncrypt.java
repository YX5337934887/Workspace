package org.base.en_uncrypt;

public class EncryptUncrypt {
	public static String encryptUncrypt(String value,char secret) {
		byte[] bt = value.getBytes();
		for(int i = 0;i<bt.length;i++) 
			bt[i] = (byte)(bt[i]^(int)secret);
		return new String(bt,0,bt.length);
	}
	public static void main(String[] args) {
		String value = "ż������������";
		char secret='8';
		System.out.println(value);
		String encryptResult = EncryptUncrypt.encryptUncrypt(value, secret);
		System.out.println("���ܺ��ֵ:"+encryptResult);
		String uncryptResult = EncryptUncrypt.encryptUncrypt(encryptResult, secret);
		System.out.println("���ܺ��ֵ:"+uncryptResult);
	}
}
