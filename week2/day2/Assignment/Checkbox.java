package week2.day2.Assignment;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		
		//Launching browser
		ChromeDriver driver = new ChromeDriver();
		
		//Passing URL
		driver.get("https://leafground.com/checkbox.xhtml");
		
		//Adding wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Maximizing the window
		driver.manage().window().maximize();
		
		//Clicking on basic check box
		driver.findElement(By.xpath("(//span[text()='Basic']/preceding-sibling::div)[2]")).click();
		
		//Clicking on Notification check box
		driver.findElement(By.xpath("(//span[text()='Ajax']/preceding-sibling::div)[2]")).click();
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Checked']"));
		String text = element.getText();
		System.out.println("Confirmation message is displayed with "+text);
		
		//Clicking on favorite language
		driver.findElement(By.xpath("//label[text()='Java']")).click();
		
		//Clicking on Tri State Checkbox
		driver.findElement(By.xpath("//span[@class='ui-chkbox-icon ui-c ']/parent::div")).click();
		
		//Verifying for confirmation message
		WebElement element2 = driver.findElement(By.xpath("//p[text()='State = 1']"));
		String text2 = element2.getText();
		System.out.println(text2+", which refers to tri state has been choosen with tick");
		
		//Toggle the switch
		driver.findElement(By.className("ui-toggleswitch-slider")).click();
		
		WebElement element3 = driver.findElement(By.xpath("//span[text()='Checked']"));
		String text3 = element3.getText();
		System.out.println("Toggle is enabled and confirmation message is verified as "+text3);
		
		WebElement element4 = driver.findElement(By.xpath("//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled ui-state-disabled']"));
		boolean verify = element4.isSelected();
		System.out.println("Check box is not selected so it is mentioned as "+verify);
		
		driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-icon-t')]")).click();
		Thread.sleep(2000);
		
		//Selecting multiple options
		driver.findElement(By.xpath("(//label[text()='Miami'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Berlin'])[2]")).click();
		
		//Verifying what are the check boxes are clicked
		WebElement element5 = driver.findElement(By.xpath("//ul[@data-label='Cities']"));
		String text5 = element5.getText();
		System.out.println(text5+" has been checked");
		
		//Closing the window
		driver.close();
		
	}

}