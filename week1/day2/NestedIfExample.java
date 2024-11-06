package week1.day2;

public class NestedIfExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String education = "Graduate";
		int marks=70;
		
		if(education == "Graduate") {
			if(marks > 60) {
				System.out.println("Eligible for interview...");
			}else {
				System.out.println("Not Eligible for interview...");
			}
		}else {
			System.out.println("Please Complete your graduation....");
		}

	}

}
