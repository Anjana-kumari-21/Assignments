package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnWebTable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		// Passing URL
		driver.get("https://www.asx.com.au/");

		// Adding wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Maximizing the window
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		driver.findElement(By.xpath("//h5[text()='S&P ASX200 top 5']")).click();
		WebElement table = driver.findElement(By.xpath("//table[@class='md-bootstrap-tooltip' and caption[text()='Gains']]"));
		Thread.sleep(3000);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='md-bootstrap-tooltip' and caption[text()='Gains']]/tr"));
		Thread.sleep(3000);
		int rowSize = rows.size();
		System.out.println(rowSize);
		Thread.sleep(3000);
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='md-bootstrap-tooltip' and caption[text()='Gains']]/tr[1]/td"));
		Thread.sleep(3000);
		int colSize = cols.size();
		System.out.println(colSize);
		
		driver.close();
		

		


	}

}
