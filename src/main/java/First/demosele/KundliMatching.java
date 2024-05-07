package First.demosele;

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

public class KundliMatching {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://astro.synilogictech.com/kundali-matching");
		Actions a = new Actions(driver);

//		 Language
		WebElement LanguagedropDown = driver.findElement(By.xpath("//select[@name='language']"));
		Select LanDropDown = new Select(LanguagedropDown);
		LanDropDown.selectByIndex(0);

//		Girl's Date Of Birth:
		driver.findElement(By.name("girl_date")).sendKeys("01january	2024");

//		Girl's Date Of Time:
		WebElement GTime = driver.findElement(By.name("girl_time"));
		a.moveToElement(GTime).click().sendKeys("04:10:45PM").build().perform();

//		Girl's Place of birth:
		WebElement GPlace = driver.findElement(By.id("girl_location"));
		WebElement Button = driver.findElement(By.xpath("(//button[normalize-space()='Get Result'])[1]"));
		a.moveToElement(Button).build().perform();
		a.moveToElement(GPlace).click().build().perform();
		driver.findElement(By.id("girl_location")).sendKeys("kota");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pac-item'] /span")));
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='pac-item'] /span"));

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("Kota")) {
				option.click();
				break;
			}
		}

//		Boy's Date Of Birth:
		driver.findElement(By.name("boy_date")).sendKeys("01january	2024");

//		Boy's Date Of Time:
		WebElement BTime = driver.findElement(By.name("boy_time"));
		a.moveToElement(BTime).click().sendKeys("04:10:45PM").build().perform();

//		Boy's Place of birth:
		WebElement BPlace = driver.findElement(By.id("boy_location"));
		WebElement SubmitButton = driver.findElement(By.xpath("(//button[normalize-space()='Get Result'])[1]"));
		a.moveToElement(SubmitButton).build().perform();
		a.moveToElement(BPlace).click().build().perform();
		driver.findElement(By.id("boy_location")).sendKeys("kota");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pac-item'] /span")));
		List<WebElement> Submitoptions = driver.findElements(By.xpath("//div[@class='pac-item'] /span"));

		for (WebElement option1 : Submitoptions) {

			if (option1.getText().equalsIgnoreCase("Kota")) {
				option1.click();
				break;
			}
		}

//		Submit Button
		a.moveToElement(SubmitButton).click().build().perform();

		// submit Toast
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());

	}

}
