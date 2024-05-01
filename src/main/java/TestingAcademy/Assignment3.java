package TestingAcademy;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[2]//span[2]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-body'] p")));
		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();

		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByValue("consult");

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();

		String[] itemsNeeded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
		driver.findElement(By.cssSelector("button[class='btn btn-success']")).click();
		driver.findElement(By.id("country")).sendKeys("india");

		List<WebElement> options = driver.findElements(By.xpath("//a[normalize-space()='India']"));
		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		driver.findElement(By.xpath("//label[@for='checkbox2']")).click();
		System.out.println(
				driver.findElement(By.xpath("(//div[@class='alert alert-success alert-dismissible'])[1]")).getText());

		// driver.close();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) { 
																									
			int j = 0;
		List<WebElement> products = driver.findElements(By.xpath("//a[normalize-space()='']"));
		for (int i = 0; i < products.size(); i++) {
		    String productName = products.get(i).getText();
		    List itemsNeededList = Arrays.asList(itemsNeeded);
		    if (itemsNeededList.contains(productName)) {
		        j++;
		        // click on add to cart
		        products.get(i).findElement(By.xpath(".//button[@class='btn btn-info']")).click();

		        if (j == itemsNeeded.length) {
		            break;
		        }
		    }
		}
	}

}
