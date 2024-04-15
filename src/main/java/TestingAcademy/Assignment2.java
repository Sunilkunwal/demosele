package TestingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Check the first Checkbox and verify if it is successfully checked and Uncheck
		// it again to verify if it is successfully Unchecked

		driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).isSelected());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).isSelected());

		// How to get the Count of number of check boxes present in the page

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

	}

}
