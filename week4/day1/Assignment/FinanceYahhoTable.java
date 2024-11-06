package week4.day1.Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahhoTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		// Passing URL
		driver.get("https://finance.yahoo.com/ ");

		// Adding wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Maximizing the window
		driver.manage().window().maximize();
		
		WebElement more =  driver.findElement(By.xpath("//span[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
		WebElement element = driver.findElement(By.cssSelector("a[href='https://finance.yahoo.com/crypto/']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		List<WebElement> col = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for (WebElement webElement : col) {
			System.out.println(webElement.getText());
			
		}
		driver.close();

	}

}
