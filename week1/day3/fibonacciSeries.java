package week1.day3;

import java.util.Arrays;

public class fibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fib = 1 1 2 3 5 8 9
		
		int n=7;
		int[] fib = new int[n];
		if(n==1) {
			fib[0]=1;
		} else if(n==2) {
			fib[0]=1;
			fib[1]=1;
		} else {
			fib[0]=1;
			fib[1]=1;
			for(int i = 2;i<n;i++) {
				fib[i] = fib[i-1] + fib[i-2];
			}
			System.out.println(Arrays.toString(fib));
		}
		

	}

}
