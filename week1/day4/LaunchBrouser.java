package week1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrouser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.partialLinkText("Find")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Forgotten Password | Can't Log In | Facebook\r\n"
				+ "";
		if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification passed!");
        } else {
            System.out.println("Title verification failed! Expected: " + expectedTitle + ", but got: " + actualTitle);
        }
	}

}
			