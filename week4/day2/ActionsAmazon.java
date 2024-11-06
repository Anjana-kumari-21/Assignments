package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		// Passing URL
		driver.get("https://www.amazon.in/");

		// Adding wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Maximizing the window
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		//scroll down a page
		a.sendKeys(Keys.END).perform();
		
		String text = driver.findElement(By.xpath("//a[text()='Conditions of Use & Sale']")).getText();
		System.out.println("text is:- " + text);
		driver.close();
	}

}
