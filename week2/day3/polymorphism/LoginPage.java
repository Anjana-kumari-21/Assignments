package week2.day3.polymorphism;

class BasePage 
{

	void findElement()
	{
		System.out.println("Find the webdriver element");
	}
	 void clickElement()
	 {
		 System.out.println("Click the Element");
	 }
	 void enterText()
	 {
		System.out.println("Enter text to the input element"); 
	 }
	 void performCommonTasks()
	 {
		 System.out.println("Get title of the webdriver");
	 }
	 
}
 class LoginPage extends BasePage{

	 @Override
	void performCommonTasks()
	{
		System.out.println("Drag and drop the element");
		super.performCommonTasks();
	}
	 
	 public static void main(String[] args) {
		LoginPage p=new LoginPage();
		p.findElement();
		p.clickElement();
		p.enterText();
		p.performCommonTasks();
		
	}
}