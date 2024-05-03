package First.demosele;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AstroDrop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://astrovastutalks.com/astrologer-register");
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

//		Add Document
		Actions a = new Actions(driver);
		WebElement AddButton = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		a.moveToElement(AddButton).click().build().perform();
		AddButton.click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();

//	    Do You Have Any Writing Experience

//	    Switch back to the main page

//		Do You Have Any Teaching Experience

//		Do You Have Any Existing Website

//	    Are You Associate With any Temple

	}

}
