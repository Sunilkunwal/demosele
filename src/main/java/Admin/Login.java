package Admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://astro.synilogictech.com/sy-admin/login");

		// login
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// click on users
		driver.findElement(By.xpath("//a[contains(@href, '#user_management')]")).click();

		// click on astrologer
		WebElement Astrologer = driver.findElement(By.xpath("//span[normalize-space()='Astrologer']"));
		action.moveToElement(Astrologer).click().build().perform();

		// click on add new button
		driver.findElement(By.xpath("//a[contains(text(),'+  Add New')]")).click();

		// Fill From
		driver.findElement(By.id("name")).sendKeys("Test");
		driver.findElement(By.id("email")).sendKeys("test@test.com");
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		driver.findElement(By.id("display_name")).sendKeys("Astro Test");
		WebElement GenderDropDown = driver.findElement(By.id("gender"));
		Select GenderDD = new Select(GenderDropDown);
		GenderDD.selectByValue("male");
		driver.findElement(By.id("house_no")).sendKeys("123");
		driver.findElement(By.id("street_area")).sendKeys("borkhedha");
		driver.findElement(By.id("landmark")).sendKeys("near kanchan resort");

		// Address
		WebElement Address = driver.findElement(By.xpath("//div[@role='textbox']//p"));
		action.moveToElement(Address).click().build().perform();
		driver.findElement(By.name("address")).sendKeys("kota");
		List<WebElement> Locationoptions = driver.findElements(By.xpath(
				"//div[@class='pac-container pac-logo']//span[@class='pac-item-query']/span[contains(text(), 'Kota')]"));

		System.out.println(Locationoptions.size());
		for (WebElement optionL : Locationoptions) {

			if (optionL.getText().equalsIgnoreCase("Kota")) {
				wait.until(ExpectedConditions.visibilityOf(optionL));
				action.moveToElement(optionL).click().build().perform();
				break;
			}
		}
		
		

//		driver.close();
	}

}
