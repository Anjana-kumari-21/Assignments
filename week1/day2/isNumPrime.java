package week1.day2;

public class isNumPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//prime numbers=2,3,5,7
		int n = 7;
		boolean flag=false;
		if(n == 0 || n==1) {
			flag = false;
		}
		for (int i = 2; i < n; i++) {
			if(n%i == 0) {
				flag = false;
				break;
			}
		
		}
		if(flag == true) {
			System.out.println("prime");
		}
		else {
			System.out.println("not prime");
		}
	}
	

}
