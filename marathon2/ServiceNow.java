package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Shadow shadow = new Shadow(driver);

		// 1. Navigate to https://dev186929.service-now.com/
		driver.get("https://dev186929.service-now.com/");
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		//2. Login with valid credentials username as admin and password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2AqjN!lC2!Vy");
		driver.findElement(By.id("sysverb_login")).click();
		
		//3. Click----->All in the SERVICE NOW Page  &  click the  Service catalog in filter navigator.
		Thread.sleep(5000);
		WebElement all = shadow.findElementByXPath("//div[text()='All']");
		all.click();
		
		WebElement serviceCat = shadow.findElementByXPath("//span[text()='Service Catalog']");
		serviceCat.click();
		
		//4. Click on  mobiles
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		
		//5. Select Apple iphone13pro
		driver.findElement(By.xpath("//strong[contains(text(),'Apple iPhone 13 pro')]")).click();
		
		//6. Choose yes option in lost or broken iPhone, enter the mobile number
		driver.findElement(By.xpath("//label[@class='radio-label' and text()='Yes']")).click();
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("123123456");
		
		//7. Select Unlimited from the dropdown in Monthly data allowance
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select select = new Select(dropdown);
		select.selectByValue("unlimited");
		
		//8. Update color field to SierraBlue and storage field to 512GB
		driver.findElement(By.xpath("//label[@class='radio-label' and text()='Sierra Blue']")).click();
		driver.findElement(By.xpath("//label[@class='radio-label' and text()='128 GB']")).click();
		
		//9. Click on Order now option
		driver.findElement(By.id("oi_order_now_button")).click();
		
		//10. Verify order is placed and copy the request number
		String confirmation = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		if(confirmation.contains("Thank you,")) {
			System.out.println("Order Placed.....");
		}else {
			System.out.println("Order Not Placed.....");
		}
		
		String requestID = driver.findElement(By.xpath("//a[@id='requesturl']/b")).getText();
		System.out.println("Request ID is:- " + requestID);
		
		//11. Take Screenshot
		TakesScreenshot scrObj = (TakesScreenshot) driver;

		File scrFile = scrObj.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\TestL\\ScreenShot\\ServiceNow.png"));
		
		
		driver.close();


	}

}
