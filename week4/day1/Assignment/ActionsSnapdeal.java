package week4.day1.Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1. Launch (https://www.snapdeal.com/)

		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// 2. Go to "Men's Fashion".

		Actions act = new Actions(driver);
		WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		act.moveToElement(mensFashion).perform();

		// 3. Go to "Sports Shoes".

		WebElement menSportsShoes = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		menSportsShoes.click();

		// 4. Get the count of sports shoes.
		String count = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Items count : " + count);
		
		// 5. Click on "Training Shoes".
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(1000);
		
		//6. Sort the products by "Low to High".
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		Thread.sleep(20000);
		
		// 7. Check if the displayed items are sorted correctly.
		List<WebElement> rupess = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int firstNo,secNo;
		for(int i=0;i<rupess.size()-1;i++)
		{
		firstNo=Integer.parseInt(rupess.get(i).getAttribute("display-price"));
		secNo=Integer.parseInt(rupess.get(i+1).getAttribute("display-price"));
		if(firstNo>secNo)
		{
			System.out.println("Filter is not working properly");
			break;
		}
		
		}
		
		// 8. Select any price range ex:(500-700).
		
		WebElement minRu = driver.findElement(By.name("fromVal"));
		minRu.clear();
		minRu.sendKeys("500");
		WebElement maxRup = driver.findElement(By.name("toVal"));
		maxRup.clear();
		maxRup.sendKeys("2000");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(20000);
		
		// 9. Filter by any colour.
		driver.findElement(By.xpath("//span[@class='filter-color-tile Black ']")).click();		
		Thread.sleep(20000);
		
		// 10. Verify all the applied filters.
		WebElement filterPrice = driver.findElement(By.xpath("//span[@class='lfloat product-price']"));
		int FilPrice=Integer.parseInt(filterPrice.getAttribute("display-price"));
		if(FilPrice>=500 && FilPrice<=2000)
		{
			System.out.println("Filter applied correctly");
		}
		else
		{
			System.out.println("Filter is not applied properly");
		}
		
		// 11. Mouse hover on the first resulting "Training Shoes".
		
		// 12. Click the "Quick View" button.
		WebElement quickView = driver.findElement(By.xpath("//div[@class='clearfix row-disc']"));
		act.moveToElement(quickView).click().build().perform();
		
		// 13. Print the cost and the discount percentage.
		
		String discountPrice = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(discountPrice);
		
		
		// 14. Take a snapshot of the shoes.
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("C:\\TestL\\ScreenShot\\screenSnapDeal.png"));
		
		// 15. Close the current window.
		
		driver.close();
		
		

	}

}
