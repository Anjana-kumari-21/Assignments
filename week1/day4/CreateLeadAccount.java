package week1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeadAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'createLeadForm')]")).click();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("tester");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("tester");
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("company");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("title");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
		System.out.println("the current title is: " +title);
		if(title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("Web page title is verified");
		}
		else
		{
			System.out.println("Web page title is not verified");
		}


	}

}
