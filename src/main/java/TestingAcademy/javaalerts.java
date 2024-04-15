package TestingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class javaalerts {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String text = "Sunil Kunwal";
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("input[value='Alert']")).click();

		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();

	}

}
