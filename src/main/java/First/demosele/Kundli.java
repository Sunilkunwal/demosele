package First.demosele;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Kundli {

	public static void main(String[] args) {
		
		

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  driver.get("https://astro.synilogictech.com/free-kundali");
		  
		 //calendor
		  LocalDate currentDate = LocalDate.now();
		  DateTimeFormatter Dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      String formattedDate = currentDate.format(Dateformatter);
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("arguments[0].value = arguments[1];", driver.findElement(By.name("dob")), formattedDate);
	      
	      
	      //time
	      WebElement timePickerInput = driver.findElement(By.name("tob"));
	      timePickerInput.click();
	      Actions actions = new Actions(driver);
	      actions.sendKeys("04:10:45 PM").perform();
	      

	      //place of birh 
	     

	     
	        

	}

}
