package First.demosele;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AstroDrop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://astrovastutalks.com/astrologer-register");
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

		
		
	}

}
