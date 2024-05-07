package TestingAcademy;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scop {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement Footer = driver.findElement(By.id("gf-BIG"));								//Limiting webdriver scope
		System.out.println(Footer.findElements(By.tagName("a")).size());
		
		
//		print footer column section lint
		WebElement columndriver =Footer.findElement(By.xpath("//table//tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
//		4 click on each link in the column and check if page are opening
		for (int i=1; i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinkTab =Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);
		}//open all taps
		
		Set<String> NewWins =driver.getWindowHandles();	
		Iterator<String> it = NewWins.iterator();
		
		while(it.hasNext())
		{
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
