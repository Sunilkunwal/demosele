package First.demosele;

import java.math.BigInteger;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerLogin {

	public static void main(String[] args) throws InterruptedException {
		String mobileNo = "9667737387";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://astro.synilogictech.com/");
		
//		Click on login button
		driver.findElement(By.xpath("(//button[normalize-space()='LOGIN'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By
				.xpath("//div[@class='iti iti--allow-dropdown iti--separate-dial-code']//input[@id='recipient-name']"))
				.sendKeys(mobileNo);
		Thread.sleep(2000);
		WebElement checkbox = driver.findElement(By.xpath("(//input[@id='myCheck'])[1]"));
		checkbox.click();
		WebElement checkbox1 = driver.findElement(By.xpath("(//input[@id='myCheck'])[1]"));
		checkbox1.click();
		driver.findElement(By.cssSelector("#getotp")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='d-flex flex-row ']//input[@id='recipient-name']"))
				.sendKeys("666331");
		driver.findElement(By.cssSelector("#verify")).click();

		// submit Toast
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());

		System.out.println(driver.findElement(By.cssSelector(
				"body > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > a:nth-child(2) > h4:nth-child(1)"))
				.getText());
		Assert.assertEquals(driver.findElement(By.cssSelector(
				"body > section:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > a:nth-child(2) > h4:nth-child(1)"))
				.getText(), "sunil");

		driver.findElement(By.cssSelector(".fw-bold.m-0")).getText();
		String CUSID = driver.findElement(By.cssSelector(".fw-bold.m-0")).getText();

		driver.close();

	}

}
