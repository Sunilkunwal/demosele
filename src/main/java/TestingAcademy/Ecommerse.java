package TestingAcademy;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ecommerse {

	public static void main(String[] args) throws InterruptedException {
	
		
		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		
		String [] itemsNeeded = {"Brocolli","Cucumber","Beetroot","Carrot"};
		int j=0;
		
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0; i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
			String formatetedName = name[0].trim();
			//format it to get actual vegetable name 
			//convert array into array list for easy search
			//check whether name you extracted is present in array list or not 
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			
			if(itemsNeededList.contains(formatetedName))
			{
				j++;
				//click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length) 
				{
					break;
				}
				
			}
		}

	}

}
