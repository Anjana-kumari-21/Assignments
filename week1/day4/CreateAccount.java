package week1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		//driver.findElement(By.partialLinkText("Account")).click();
		
		driver.findElement(By.xpath("//a[contains(@href, 'createAccountForm')]")).click();
		
		driver.findElement(By.id("accountName")).sendKeys("Tester");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("10");
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		driver.findElement(By.className("smallSubmit")).click();
		
		String title=driver.getTitle();
		System.out.println("the current title is: " +title);
		if(title.equals("Account Details | opentaps CRM"))
		{
			System.out.println("Web page title is verified");
		}
		else
		{
			System.out.println("Web page title is not verified");
		}
		
		driver.close();
	}

}
