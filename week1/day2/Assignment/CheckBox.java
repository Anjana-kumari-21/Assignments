package week1.day2.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CheckBox {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver; // Declare driver only once at the class level
        String browser = "chrome"; // Set the browser type

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(); // Initialize ChromeDriver if browser is chrome
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(); // Initialize EdgeDriver if browser is edge
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        
        driver.manage().window().maximize();
        driver.get("https://leafground.com/checkbox.xhtml");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//span[text()='Basic']")).click();
        WebElement chk = driver.findElement(By.xpath("//span[text()='Ajax']"));
        chk.click();
        
        String ajaxNotification = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span[@class='ui-growl-title' and text()='Checked']")).getText();
		System.out.println(ajaxNotification);
		/*
		 * if(chk.isSelected()) { System.out.println(ajaxNotification); } 
		 */
        WebElement java = driver.findElement(By.xpath("//table[@id='j_idt87:basic']//td[label[text()='Java']]"));
        String ja = java.getText();        
        java.click();
        System.out.println("Selected lanuage is " + ja);
        driver.findElement(By.xpath("//input[@id='j_idt87:ajaxTriState_input']")).click();
        WebElement toggle = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt100_input']"));
        toggle.click();
        if(toggle.isSelected()) {
        	System.out.println("Toggle selected");
        }
        
        
        
        
        
        driver.close();
    }
}

