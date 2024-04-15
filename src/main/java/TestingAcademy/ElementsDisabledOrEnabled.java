package TestingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ElementsDisabledOrEnabled {

	public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.chrome.driver", "/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		 System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		 System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		 driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//		 System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		 System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		 
		 if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		 {
			 System.out.println("it's enabled");
					 Assert.assertTrue(true);
		 }
		 else
		 {
			 Assert.assertTrue(false);
		 }
	}

}
