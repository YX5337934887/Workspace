package org.base.email;

public class CheckEmail {
	public static boolean checkEmail(String email) {
		String format = "\\p{Alpha}\\w{2,15}[@][a-z0-0]{3,}[.]\\p{Lower}{2,}";
		return email.matches(format);
	}
	public static void main(String[] args) {
		System.out.println(checkEmail("vdf*greaf@ree.com"));
	}
}
