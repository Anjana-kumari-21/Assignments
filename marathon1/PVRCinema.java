package marathon1;

import java.sql.Time;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PVRCinema {
	public static void main(String[] args) throws InterruptedException {
		//Load URL
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.pvrcinemas.com/");
		Thread.sleep(1000);
		//Select Location=Chennai
		driver.findElement(By.xpath("(//span[@class='cities-placed'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='cities-names']/h6[text()='Chennai']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='date-show']/span[text()='Cinema']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='INOX The Marina Mall, OMR, Chennai']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='p-dropdown-items-wrapper']/ul/li/span[text()='BLACK']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='03:55 PM']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Book']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='CL.CLUB|K:27' and @class='seat-current-pvr']"));
		Thread.sleep(1000);

		
		String seatNumner = driver.findElement(By.xpath("//span[@id='CL.CLUB|K:27' and @class='seat-current-pvr']")).getText();
		Thread.sleep(1000);
		System.out.println("Selected seat : "+ seatNumner);
		driver.findElement(By.xpath("//span[@id='CL.CLUB|K:27' and @class='seat-current-pvr']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(1000);


		String grandTotal = driver.findElement(By.xpath("//div[@class='all-grand']/div/h6/span")).getText();
		System.out.println("Grand Total = " + grandTotal);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		String title = driver.getTitle();
		System.out.println("Title of the current page : " + title);
		if(title.contains("PVR Cinemas"))
		{
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title not matched");
		}
		driver.close();
	}


}