package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TataCliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1. Navigate to https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		// 2. MouseHover on 'Brands'
		Actions act = new Actions(driver);
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement brands = driver.findElement(By.xpath("//div[text()='Brands']"));
		act.moveToElement(brands).perform();

		// 3. MouseHover on 'Watches & Accessories'
		WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		act.moveToElement(watches).perform();

		// 4. Choose the first option from the 'Featured brands'.
		WebElement firstFeaturedBrand = driver
				.findElement(By.xpath("//div[@class= 'DesktopHeader__brandsDetails'][1]"));
		firstFeaturedBrand.click();

		// 5. sort by New Arrivals
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("New Arrivals");

		// 6. choose men from catagories filter.
		WebElement men = driver.findElement(By.xpath("//div[@class='FilterDesktop__newFilName']"));
		men.click();

		// 7. print all price of watches
		Thread.sleep(1000);
		List<WebElement> watchPrices = driver
				.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		String firstPrice = watchPrices.get(0).getText();
		System.out.println("First Watch Price:- " + firstPrice);
		System.out.println("List of Watch Prices:-");
		
		for (WebElement webElement : watchPrices) {
			System.out.print(webElement.getText() + "   ");
		}

		// 8. click on the first resulting watch
		WebElement firstProduct = driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv'][1]"));
		firstProduct.click();
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());
				
				//9. click Add to Bag   and  get count from the Bag cart icon.
				WebElement bag = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
				bag.click();
				String cartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
				System.out.println("Count of items in cart:- " + cartCount);
				
				//10. compare two price are similar
				Thread.sleep(1000);
				String currentPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']/h3")).getText();
				System.out.println("Current price:- " + currentPrice);
				if(firstPrice==currentPrice) {
					System.out.println("Prices match");
				}else {
					System.out.println("Prices match");
				}
				
				//11. Click on the Bag cart icon
				driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
				
				//12. Take snapshot
				TakesScreenshot scrObj = (TakesScreenshot) driver;

				File scrFile = scrObj.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("C:\\TestL\\ScreenShot\\TataCliq.png"));
				
				//13. close the tabs
				driver.close();
			}

		}
		
		
		driver.switchTo().window(parent);
		driver.close();
		

	}
}
