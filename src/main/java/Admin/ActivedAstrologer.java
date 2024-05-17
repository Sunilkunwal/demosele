package Admin;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ActivedAstrologer {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String AstroMobileNumber = "+918104488289";
		JavascriptExecutor js = (JavascriptExecutor) driver;

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
		
		List<WebElement> MobileTble = driver.findElements(By.cssSelector(".card-body td:nth-child(4)"));
		List<String> MobileOgiginalList = MobileTble.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> MobileOgiginalSortedList = MobileOgiginalList.stream().sorted().collect(Collectors.toList());
		List<WebElement> StatusButton = driver.findElements(By.cssSelector(".form-check-input.updateStatus"));
		WebElement NextPage = driver.findElement(By.xpath("//a[contains(text(),'›')]"));

		List<String> row;
		do {
			List<WebElement> MobileRow = driver.findElements(By.xpath("//tr/td[4]"));
			row = MobileRow.stream().filter(s -> {
				String script = "return arguments[0].textContent.trim();";
				String mobileText = (String) js.executeScript(script, s);
				return mobileText.contains(AstroMobileNumber);
			}).map(s -> getAstroMobileNumber(s)).collect(Collectors.toList());
			row.forEach(a -> System.out.println(a));
			if (row.size() < 1) {
				action.moveToElement(NextPage).click().build().perform();
			}
		} while (row.size() < 1);
		action.moveToElement((WebElement) StatusButton).click().build().perform();
	}

	private static String getAstroMobileNumber(WebElement s) {
		String StatusButton = s.findElement(By.xpath("following-sibling::td[3]")).getText();
		return StatusButton;
	}

//		driver.close();

}
