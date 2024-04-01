package First.demosele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AstrologerRegistration {

	public static void main(String[] args) {

		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  
		  driver.get("https://astrovastutalks.com/astrologer-register");
		  
		  driver.findElement(By.xpath("//input[@id='validationCustom01']")).sendKeys("Sunil");
		  driver.findElement(By.cssSelector("#validationCustom02")).sendKeys("Astro Sunil");
		  driver.findElement(By.cssSelector("#inputEmail4")).sendKeys("Sunil452@mail.com");
		  driver.findElement(By.cssSelector("body > section:nth-child(8) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > input:nth-child(2)")).sendKeys("9878974785");
		  driver.findElement(By.cssSelector("input[placeholder='Experience']")).sendKeys("5");
		  driver.findElement(By.cssSelector("#house_no")).sendKeys("5");
		  driver.findElement(By.cssSelector("#street_area")).sendKeys("boarkheda");
		  driver.findElement(By.cssSelector("#landmark")).sendKeys("Kanchan resort");
		  driver.findElement(By.cssSelector("#inputZip")).sendKeys("324005");
		  driver.findElement(By.cssSelector("body > section:nth-child(8) > form:nth-child(1) > div:nth-child(1) > div:nth-child(21) > input:nth-child(2)")).sendKeys("QWERT1234L");
		  driver.findElement(By.cssSelector("div[role='textbox']")).sendKeys("Test Description");
		  driver.findElement(By.cssSelector("input[placeholder='Bank Name']")).sendKeys("State Bank Of India");
		  driver.findElement(By.cssSelector("input[placeholder='IFSC Code']")).sendKeys("SBIN0032065");
		  driver.findElement(By.cssSelector("input[placeholder='Account No']")).sendKeys("58846976548");
		  driver.findElement(By.cssSelector("input[placeholder='Account Holder Name']")).sendKeys("John Methew");
		  driver.findElement(By.cssSelector("#writing_language")).sendKeys("test");
		  driver.findElement(By.cssSelector("#writing_details")).sendKeys("test");
		  driver.findElement(By.cssSelector("#teaching_subject")).sendKeys("test");
		  driver.findElement(By.cssSelector("#teaching_subject")).sendKeys("5");
		  driver.findElement(By.cssSelector("#existing_fees")).sendKeys("500");
		  
		  WebElement dropdown = driver.findElement(By.xpath("//section[contains(@class,'text-light bg-light p-2 formsection')]//form"));
	      dropdown.click();
	      WebElement option = driver.findElement(By.xpath("//section[contains(@class,'text-light bg-light p-2 formsection')]//form//option[text()='Desktop']"));
	      option.click();
	      
	      
		  
		  
	      
	      
//		  Astrologer Image
//		  Birth Date
//		  Category 
//		  Language
//		  Skills 
//		  Select your Location
//		  Add Document

//		  Do You Have Any Writing Experience
//		  Do You Have Any Teaching Experience
//		  Do You Have Any Existing Website
//		  Are You Associate With any Temple
		  
		 
		  
		  
		  
		  
		  
		  
		  
		  
		  
	        
//	        WebElement uploadButton = driver.findElement(By.cssSelector(".upload-icn"));
//	        uploadButton.click();
//	        WebElement fileInput = driver.findElement(By.cssSelector(".upload-icn"));
//	        fileInput.sendKeys("C:\\Users\\pc\\Downloads\\6369.jpg");
	}

}
