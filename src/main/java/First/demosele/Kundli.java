package First.demosele;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Kundli {

	public static void main(String[] args) throws InterruptedException {

		
//		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		  driver.get("https://astro.synilogictech.com/free-kundali");
		  
		 //Date of Birth
		  LocalDate currentDate = LocalDate.now();
		  DateTimeFormatter Dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      String formattedDate = currentDate.format(Dateformatter);
	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("arguments[0].value = arguments[1];", driver.findElement(By.name("dob")), formattedDate);
	      
	      
	      //Time of Birth
	      WebElement timePickerInput = driver.findElement(By.name("tob"));
	      timePickerInput.click();
	      Actions actions = new Actions(driver);
	      actions.sendKeys("04:10:45PM").perform();
	      
	    
	      //Place of birth
	      Actions a = new Actions(driver);
	      WebElement Style = driver.findElement(By.xpath("//select[contains(@name,'style_field')]"));
	      a.moveToElement(Style).click().build().perform();
	      driver.findElement(By.id("free_kundli_location")).sendKeys("kota");
	      List<WebElement> options =driver.findElements(By.xpath("//div[@class='pac-item'] /span"));
			 
			 for(WebElement option :options) 
			 {
				 
				 if(option.getText().equalsIgnoreCase("Kota"))
				 {
					 option.click();
					 break;
				 }
			 }
	      
	      
		//Div
	    WebElement divDropdown = driver.findElement(By.name("div_field"));
	    Select dropdown = new Select(divDropdown);
	    dropdown.selectByValue("D3");
	    
	    
	    //Style
	    WebElement StyleDropdown = driver.findElement(By.name("style_field"));
	    Select dropdown1 = new Select(StyleDropdown);
	    dropdown1.selectByValue("south");
	    
	    
	    //Language
	    WebElement LanguageDropdown = driver.findElement(By.name("language"));
	    Select dropdown2 =new Select(LanguageDropdown);
	    dropdown2.selectByValue("hi");
	    
	    
	    //Submit Button 
	    WebElement SubmiButton =driver.findElement(By.xpath("//button[normalize-space()='Get Result']"));
	    a.moveToElement(SubmiButton).click().build().perform();
	    
		// submit Toast
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());
//		zaid
	}

}
