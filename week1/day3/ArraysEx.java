package week1.day3;

import java.util.Arrays;

public class ArraysEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {2,7,9,2,4,7,0,1,8};
		int numLength = num.length;
		System.out.println("Length of Array is " + numLength);
		System.out.println("Original Array is.....");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
		System.out.println();
		Arrays.sort(num);
		System.out.println("Sorted Array is.....");
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
		System.out.println("smallest number of array is " + num[0]);
		System.out.println("largest number of array is " + num[numLength-1]);
		System.out.println("finding duplicate elements....");
		for (int i = 0; i < num.length-1; i++) {
			if(num[i]==num[i+1]) {
				System.out.println("duplicate elements are " + num[i]);
			}
		}
	}

}
