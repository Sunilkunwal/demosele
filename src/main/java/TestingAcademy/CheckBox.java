package TestingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBox {

	public static void main(String[] args) {
		
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
		 System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
		 driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
		 System.out.println(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
		 
		 System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		 Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
	}

}
