package week1.day3;

import java.util.Arrays;

public class MissingEleOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 4,3,2,8, 6, 7};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			if(a[i] != i+1) {
				System.out.println("Missing Element is: " + (i+1));
				break;
			}
		}

	}

}
