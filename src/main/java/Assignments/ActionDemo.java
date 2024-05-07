package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("[id='nav-link-accountList']"));
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		//move to specific element 
		a.moveToElement(move).build().perform();
		
		//send keys in capital letters and select world with double click 
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		//to right click on on location 
		a.moveToElement(move).contextClick().build().perform();
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys(" sunil").doubleClick().build().perform();
		

	}

}
