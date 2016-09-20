import java.util.Random;

public class LettersCount {
	public static void main(String[] args) {
		char[] chars=createArray();
//		char[] chars={'l', 's', 'i', 'h', 'm', 'e', 'd', 'x', 'm', 'd' };
		/*for(char c:chars){
			System.out.print(c+"\t");
		}*/
		displayArray(chars);
		System.out.println();
		int[] countss=countLetters(chars);
		displayCount(countss);
	}
	static char[] createArray(){
		char[] chars=new char[100];
		Random random=new Random();
		/*for(char c:chars){
			c=(char) (97+random.nextInt(25));
//			c=RandomCharacter.getRandowLowerCaseLeter();
		}*/
		for(int i=0;i<chars.length;i++){
			chars[i]=(char) (97+random.nextInt(26));
		}
		return chars;
	}
	
	static void displayArray(char[] chars){
		for(int i=0;i<chars.length;i++){
			System.out.print(chars[i]+" ");
		}
	}
	
	static int[] countLetters(char[] chars){
		int[] counts=new int[26];
		for(char c:chars){
			counts[c-'a']++;
		}
		/*for(int i=0;i<chars.length;i++){
			counts[chars[i]-'a']++;
		}*/
		return counts;
	}
	
	static void displayCount(int[] counts){
		for(int i=0;i<counts.length;i++){
			if((i+1)%10==0){
				System.out.println((char)(i+'a')+":"+counts[i]);
			}
			else{
				System.out.print((char)(i+'a')+":"+counts[i]+" ");
			}
		}
	}
}
