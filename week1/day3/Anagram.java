package week1.day3;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text1 = "stops";
		String text2 = "pots";
		
		char[] str1 = text1.toCharArray();
		char[] str2 = text2.toCharArray();
		
		Arrays.sort(str1);
		Arrays.sort(str2);
		
		for (int i = 0; i < str1.length; i++) {
			if(str1[i] != str2[i]) {
				System.out.println("not anagram");
				break;
			} 
			
		}
		
		
	}

}
