package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnExplicitWait {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		// Passing URL
		driver.get("https://www.leafground.com/window.xhtml;jsessionid=node01lg014x0pip8smxjmg54srwpe7587462.node0");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Open with delay']"));
		element.click();
		boolean flag = wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println(flag);
		driver.close();
	}

}
