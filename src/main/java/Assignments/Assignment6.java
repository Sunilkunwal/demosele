package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement Option =driver.findElement(By.id("checkBoxOption2"));
		Option.click();
		String OptionValue = Option.getAttribute("value");
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select Optiondropdown = new Select(dropdown);
		Optiondropdown.selectByValue(OptionValue);
		driver.findElement(By.id("name")).sendKeys(OptionValue);
		driver.findElement(By.id("alertbtn")).click();
		String Alertoption =driver.switchTo().alert().getText();
		
        if (Alertoption.contains(Alertoption)) {
            System.out.println("Selected option is present in the alert text.");
        } else {
            System.out.println("Selected option is not present in the alert text.");
        }

		driver.close();
		

	}

}
