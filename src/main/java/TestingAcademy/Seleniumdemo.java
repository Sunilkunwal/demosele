package TestingAcademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 driver.findElement(By.id("inputUsername")).sendKeys("sunil");
		 driver.findElement(By.name("inputPassword")).sendKeys("sunil123");
		 driver.findElement(By.className("signInBtn")).click();
		 
		 //driver.close();
	}

}
