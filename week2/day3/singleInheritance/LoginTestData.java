package week2.day3.singleInheritance;

public class LoginTestData extends TestData
{
	void enterUsername()
	{
		System.out.println("Entering user name -- > child class");
	}
	void enterPassword()
	{
	System.out.println("Entering password --> child class");	
	}
public static void main(String args[])
{
	LoginTestData td=new LoginTestData();
	td.enterCredentials();
	td.navigateToHomePage();
	td.enterUsername();
	td.enterPassword();
}
}