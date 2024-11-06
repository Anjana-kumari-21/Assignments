package week1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountWithSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(@href, 'createAccountForm')]")).click();
		driver.findElement(By.id("accountName")).sendKeys("Tester3");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
		//locate select
		WebElement dropdownElement1 =driver.findElement(By.name("industryEnumId"));
		
		// Instantiate the Select class
        Select dropdown1 = new Select(dropdownElement1);
        
       // Select by visible text
        dropdown1.selectByValue("IND_SOFTWARE");
        
        WebElement dropdownElement2 = driver.findElement(By.name("ownershipEnumId"));
        Select dropdown2 = new Select(dropdownElement2);
        dropdown2.selectByVisibleText("S-Corporation");
        
        WebElement dropdownElement3 = driver.findElement(By.id("dataSourceId"));
        Select dropdown3 = new Select(dropdownElement3);
        dropdown3.selectByIndex(4);
        
        WebElement dropdownElement4 = driver.findElement(By.id("marketingCampaignId"));
        Select dropdown4 = new Select(dropdownElement4);
        dropdown4.selectByIndex(5);
        
        WebElement dropdownElement5 = driver.findElement(By.id("generalStateProvinceGeoId"));
        Select dropdown5 = new Select(dropdownElement5);
        dropdown5.selectByValue("TX");
        
        driver.findElement(By.className("smallSubmit")).click();
		String title=driver.getTitle();
		System.out.println("the current title is: " +title);
		
		String accname=driver.findElement(By.xpath("//span[contains(text(),'Tester')]")).getText();
		
		System.out.println("Account name is:" + " Tester");
		if(accname.contains("Tester"))
			
		{
			System.out.println("Account name is displayed correctly");
		}
		else
		{
			System.out.println("Account name is displayed incorrectly");
		}
	}

}
