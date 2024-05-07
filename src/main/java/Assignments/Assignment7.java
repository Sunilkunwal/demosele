package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Assignment7 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebElement table = driver.findElement(By.cssSelector("#product"));
		List<WebElement> rows = table.findElements(By.cssSelector("tr"));
		System.out.println((rows.size()));

		List<WebElement> columns = rows.get(0).findElements(By.cssSelector("th,td"));
		int columnSize = columns.size();

		System.out.println(columnSize);
		System.out.println(driver.findElement(By.xpath("(//tr)[3]")).getText());

		driver.quit();
	
//		WebElement table=driver.findElement(By.id("product"));
//		System.out.println(table.findElements(By.tagName("tr")).size());
//		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
//		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
//		System.out.println(secondrow.get(0).getText());
//		System.out.println(secondrow.get(1).getText());
//		System.out.println(secondrow.get(2).getText());
		
	}

}
