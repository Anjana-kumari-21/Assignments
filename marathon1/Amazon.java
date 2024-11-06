package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String result = driver.findElement(By.xpath("//span[contains(text(),'1-48 of over 70,000 results for')]")).getText();
		String result2 = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
		System.out.println("total result: " + result + " " + result2);
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		String bag_name = driver.findElement(By.xpath("//span[contains(text(), 'Troop Casual Backpack 32L, 3 Main Compartments,')]")).getText();
		String dis_price = driver.findElement(By.xpath("//span[text()='1,378']")).getText();
		System.out.println("first bag's name is: " + bag_name );
		System.out.println("Discounted Price is: " + dis_price);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		driver.close();		
	}

}
