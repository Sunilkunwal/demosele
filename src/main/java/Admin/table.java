package Admin;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class table {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String AstroMobileNumber = "+918104488289";
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://astrosaggaapp.com/sy-admin/login");

		// login
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Veer$$1212");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// click on users
		driver.findElement(By.xpath("//a[contains(@href, '#user_management')]")).click();

		// click on astrologer
		

		WebElement Astrologer = driver.findElement(By.xpath("//span[normalize-space()='Astrologer']"));
		action.moveToElement(Astrologer).click().build().perform();
		
		int maxPages = 8;
		int selectedPage = 1;
		List<WebElement> mobileColumn;
		List<String> mobileStrList;
		WebElement nextPage;

		for(int currentPage = selectedPage; currentPage < maxPages; currentPage++) {
		    mobileColumn = driver.findElements(By.xpath("//tr/td[4]"));
		    mobileStrList = mobileColumn.stream().map(WebElement::getText).collect(Collectors.toList());
		    
		    for (WebElement mobile : mobileColumn) {
		        String mobileText = mobile.getText().trim();
		        
		        if (!mobileText.isEmpty()) {
		            System.out.println("Mobile number: " + mobileText);
		            
		            if (mobileText.equalsIgnoreCase("+919454028575")) {
		                System.out.println("Selected number found: " + mobileText);
		                // Further actions if the number is found
		                return; // or break if continuing with the outer loop
		            }
		        }
		    }
		    // Navigate to the next page
		    nextPage = driver.findElement(By.xpath("//a[contains(text(),'›')]"));
		    action.moveToElement(nextPage).click().build().perform();
		}
		System.out.println("Number not found after iterating through " + maxPages + " pages.");

	}

}
