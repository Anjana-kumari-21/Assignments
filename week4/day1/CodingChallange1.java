package week4.day1;

import java.util.Arrays;

public class CodingChallange1 {

	public static void main(String[] args) {
		String str = "   fly me   to   the moon  ";
		String[] words = str.split(" ");
		/* System.out.println(Arrays.toString(words)); */
		//System.out.println(words[words.length-1]);
		String lastWord = words[words.length-1];
		System.out.println(lastWord.length());

	}

}
