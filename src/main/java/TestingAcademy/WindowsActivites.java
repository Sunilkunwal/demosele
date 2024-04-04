package TestingAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsActivites {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://google.com");
		 driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		 driver.navigate().back();
		 driver.navigate().forward();
	}

}
