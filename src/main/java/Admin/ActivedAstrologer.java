package Admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivedAstrologer {

	public static void main(String[] args) {

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
		String AstroMobileNumber = "+918104488289";
		WebElement Astrologer = driver.findElement(By.xpath("//span[normalize-space()='Astrologer']"));
		action.moveToElement(Astrologer).click().build().perform();

		WebElement AstrologerTable = driver.findElement(By.xpath("//table[@class='table align-items-center mb-0']"));
		List<WebElement> Rows = AstrologerTable.findElements(By.cssSelector("tr"));
		System.out.println(Rows.size());
		List<WebElement> Columns = AstrologerTable.findElements(By.cssSelector("th,td"));
		System.out.println(Columns.size());

		List<WebElement> MobileTble = driver.findElements(By.cssSelector(".card-body td:nth-child(4)"));
		List<WebElement> StatusButton = driver.findElements(By.cssSelector(".form-check-input.updateStatus"));
		WebElement NextPage = driver.findElement(By.xpath("//a[contains(text(),'›')]"));

		for (int i = 0; i < MobileTble.size(); i++) {
			WebElement mobileElement = MobileTble.get(i);
			String mobileNumber = mobileElement.getText();
			if (mobileNumber.equals(AstroMobileNumber)) {
				WebElement statusButton = StatusButton.get(i);
				statusButton.click();
				
			}
			else{
				action.moveToElement(NextPage).click().build().perform();
				
			}
		}

		

		System.out.println(driver.findElement(By.cssSelector(".swal2-html-container")).getText());
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();

//		driver.close();

	}

}
