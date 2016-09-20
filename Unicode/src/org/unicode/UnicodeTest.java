package org.unicode;

public class UnicodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\u005b\u005d");
		System.out.println(convert("]"));
	}

	/**
	 * ���ַ���ת��unicode
	 * @param str ��ת�ַ���
	 * @return unicode�ַ���
	 */
	public static String convert(String str) {
		str = (str == null ? "" : str);
		String tmp;
		StringBuffer sb = new StringBuffer();
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			sb.append("\\u");
			j = (c >>> 8); // ȡ����8λ
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
			j = (c & 0xFF); // ȡ����8λ
			tmp = Integer.toHexString(j);
			if (tmp.length() == 1)
				sb.append("0");
			sb.append(tmp);
		}
		return (sb.toString());
	}

	/**
	 * ��unicode �ַ���
	 * @param str ��ת�ַ���
	 * @return ��ͨ�ַ���
	 */
	public String revert(String str) {
		str = (str == null ? "" : str);
		if (str.indexOf("\\u") == -1)// �������unicode����ԭ������
			return str;

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length() - 6;) {
			String strTemp = str.substring(i, i + 6);
			String value = strTemp.substring(2);
			int c = 0;
			for (int j = 0; j < value.length(); j++) {
				char tempChar = value.charAt(j);
				int t = 0;
				switch (tempChar) {
				case 'a':
					t = 10;
					break;
				case 'b':
					t = 11;
					break;
				case 'c':
					t = 12;
					break;
				case 'd':
					t = 13;
					break;
				case 'e':
					t = 14;
					break;
				case 'f':
					t = 15;
					break;
				default:
					t = tempChar - 48;
					break;
				}

				c += t * ((int) Math.pow(16, (value.length() - j - 1)));
			}
			sb.append((char) c);
			i = i + 6;
		}
		return sb.toString();
	}
}
