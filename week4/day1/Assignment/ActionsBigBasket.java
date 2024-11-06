package week4.day1.Assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsBigBasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1. Navigate to https://www.bigbasket.com/.

		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		// 2. Click on "Shop by Category".
		driver.findElement(By.xpath("(//div[@class='relative h-full'])[4]")).click();

		// 3. Mouse over "Foodgrains, Oil & Masala".

		Actions act = new Actions(driver);
		WebElement food = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		System.out.println(food.getText());
		act.moveToElement(food).perform();
		Thread.sleep(1000);

		// 4. Mouse over "Rice & Rice Products".

		WebElement rice = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		System.out.println(rice.getText());
		act.moveToElement(rice).perform();

		// 5. Click on "Boiled & Steam Rice".

		WebElement boiledRice = driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"));
		System.out.println(boiledRice.getText());
		boiledRice.click();

		// 6. Filter the results by selecting the brand "bb Royal".
		WebElement brand = driver.findElement(By.xpath("//span[text()='Brands']"));
		System.out.println(brand.getText());
		js.executeScript("arguments[0].scrollIntoView(true);", brand);
		WebElement bbroyal = driver.findElement(By.id("i-BBRoyal"));
		System.out.println(bbroyal.getText());
		bbroyal.click();

		// 7. Click on "Tamil Ponni Boiled Rice".
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement tamilPonniRice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']")));
		System.out.println(tamilPonniRice.getText());
		tamilPonniRice.click();
		
		

		// 8. Select the 5 Kg bag.

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				// Switch to the new window
				driver.switchTo().window(handle);
				break; // Exit the loop after switching to the new window
			}
		}
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement kg = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='5 kg']")));
		
		System.out.println(kg.getText());
		js.executeScript("arguments[0].click();", kg);

		// 9. Check and note the price of the rice.

		WebElement ricePrice = driver
				.findElement(By.xpath("//table/tr[contains(@class, 'flex items-center justify-start')]/td[1]"));
		System.out.println(ricePrice.getTagName());

		// 10. Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("//button[text()='Add to basket'][1]")).click();

		// 11. Verify the success message that confirms the item was added to your cart.

		String Message = driver.findElement(By.xpath("//p[contains(text(),'An item has been added')]")).getText();
		if (Message.equalsIgnoreCase("An item has been added to your basket successfully")) {
			System.out.println("Added successfully");
		} else {
			System.out.println("not added to the card");
		}

		// 12. Take a snapshot of the current page

		TakesScreenshot scrObj = (TakesScreenshot) driver;

		File scrFile = scrObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\TestL\\ScreenShot\\BigBasket.png"));
		
		
		// 13. Close the current window. 
		driver.close();
		
		
		//14. Close the main window.
		driver.switchTo().window(mainWindowHandle);
		driver.close();

	}

}
