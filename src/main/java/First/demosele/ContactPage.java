package First.demosele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://astrovastutalks.com/contact");
		Actions a = new Actions(driver);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

//		Name
		driver.findElement(By.name("name")).sendKeys("sunil");

//		Email
		driver.findElement(By.name("email")).sendKeys("sunil@mail.co");

//		Contact Number
		driver.findElement(By.name("number")).sendKeys("9874563215");

//		Subject
		driver.findElement(By.name("subject")).sendKeys("test");

//		Message
		driver.findElement(By.name("message")).sendKeys("test 1431232435356!@$#%%*&((^($E");

//		SubmitButton
		WebElement SubmitButton = driver.findElement(By.xpath("//span[contains(text(),'Send')]"));
		a.moveToElement(SubmitButton).click().build().perform();

//		Submit Toast
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());

	}

}
