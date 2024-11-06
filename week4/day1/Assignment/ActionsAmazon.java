package week4.day1.Assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsAmazon {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 9 pro", Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String firstMobilePrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("First Mobile Price= " + firstMobilePrice);
		String custRating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("First Mobile Rating= " + custRating);
		WebElement firstLinkText = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
		String firstLinkText1 = firstLinkText.getText();
		System.out.println("First Link Text= " + firstLinkText1);
		firstLinkText.click();
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                // Switch to the new window
                driver.switchTo().window(handle);
                break; // Exit the loop after switching to the new window
            }
        }

        // Now the driver is in the new window
        System.out.println("Switched to new window/tab");
        Thread.sleep(3000);
        WebElement cart = driver.findElement(By.id("add-to-cart-button"));
        WebElement cardCount = driver.findElement(By.id("nav-cart-count"));
		int cardValueBefore=Integer.parseInt(cardCount.getText());
        js.executeScript("arguments[0].scrollIntoView(true);", cart);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", cart);
        
        System.out.println("Add to cart clicked");
		String subTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		WebElement close = driver.findElement(By.id("attach-close_sideSheet-link"));
		WebElement closeAvail = wait.until(ExpectedConditions.elementToBeClickable(close));
		if(closeAvail.isDisplayed())
		close.click();
		
		int cardvalueAfter=Integer.parseInt(cardCount.getText());
		if(cardValueBefore+1==cardvalueAfter)
		{
			System.out.println("item Added in the card successfully");
		}
		else
		{
			System.out.println("Item is not added in the card");
		}
		
        // To switch back to the main window:
        //driver.switchTo().window(mainWindowHandle);

		
		driver.close();

	}

}
