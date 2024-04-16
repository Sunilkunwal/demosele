package First.demosele;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class VendorRegistrations {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://astrovastutalks.com/vendor-register");

//		Name
		driver.findElement(By.id("validationCustom01")).sendKeys("Sunil");

//		Email
		driver.findElement(By.id("inputEmail4")).sendKeys("suniallaaa@gmail.com");

//		Mobile No.
		driver.findElement(By.id("inputPassword4")).sendKeys("9877745654");

//		GST Number
		driver.findElement(By.id("gst_no")).sendKeys("AAA09QWERT1234HAD");

//		Firm Name
		driver.findElement(By.name("firm_name")).sendKeys("Ram lal and son's Traders");

//		Select your Location
		driver.findElement(By.id("autocomplete")).sendKeys("kota");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='pac-matched'] /span"));

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("kota")) {
				option.click();
				break;
			}
		}

//		Pincode
		driver.findElement(By.id("inputZip")).sendKeys("324009");

//		Terms & Condition
		driver.findElement(By.className("note-editable")).sendKeys("test");

//		submiteButton
//		WebElement element = driver.findElement(By.id("continue"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(element).click().build().perform();

	}

}
