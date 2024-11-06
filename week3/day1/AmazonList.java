package week3.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("mobiles and entries");
		search.sendKeys(Keys.ENTER);
		List <WebElement> priceList = new ArrayList();
		priceList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println("total no. od prices available: ");
		System.out.println(priceList.size());
		System.out.println("Prices are as follows: ");
		List<String> textList = new ArrayList();
		for (WebElement webElement : priceList) {
			String text =  webElement.getText();
			textList.add(text);
			
		}
		System.out.println(textList);
		driver.close();
	}

}
