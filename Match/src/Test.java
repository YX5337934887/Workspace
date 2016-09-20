public class Test {
	public static void main(String[] args) {
		String count = "54234.36";
		System.out.println(count.matches("^\\d+(.\\d+)?$"));
		System.out.println(count.matches("\\d+(.\\d+)?"));
		System.out.println(count.substring(0,count.indexOf('.')));
	}
}
