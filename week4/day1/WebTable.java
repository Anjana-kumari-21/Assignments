package week4.day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		// Launching browser
		ChromeDriver driver = new ChromeDriver();

		// Passing URL
		driver.get("https://erail.in/");

		// Adding wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Maximizing the window
		driver.manage().window().maximize();
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.ENTER);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("MDU", Keys.ENTER);
		WebElement checkbox = driver.findElement(By.id("chkSelectDateOnly"));
		if (checkbox.isSelected()) {
			checkbox.click();
		}
		
		
		
		/*
		 * // getting row size List<WebElement> rowList =
		 * driver.findElements(By.xpath("//*[@id=\"divTrainsList\"]/table[1]/tbody/tr"))
		 * ; int rowSize = rowList.size(); System.out.println(rowSize);
		 * 
		 * 
		 * // getting col size List<WebElement> colList = driver.findElements(By.xpath(
		 * "//*[@id=\"divTrainsList\"]/table[1]/tbody/tr[1]/td")); int colSize =
		 * colList.size(); System.out.println(colSize);
		 * 
		 * //iterating over rows and cols to get data
		 * 
		 * for(int i=1;i<=rowSize;i++) { for(int j=1;j<=colSize;j++) {
		 * System.out.println(driver.findElement(By.xpath(
		 * "//*[@id=\"divTrainsList\"]/table[1]/tbody/tr[" + i + "]/td[" + j +
		 * "]")).getText()); } }
		 */
		Set<String> duplicate = new LinkedHashSet<>();
		List<WebElement> coloumns = driver.findElements(By.xpath("//*[@id=\"divTrainsList\"]/table[1]/tbody/tr/td[2]"));
		for(int i = 1;i<coloumns.size();i++) {
			String data = coloumns.get(i).getText();
			boolean add = duplicate.add(data);
			if(add) {
				System.out.println("Train Names:- " + data);
			}
			else {
				System.out.println("Duplicate Train Names:- " + data);
			}
			
		}

		driver.close();

	}

}
