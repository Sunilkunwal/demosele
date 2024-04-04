package First.demosele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VendorRegistration {
    public static void main(String[] args) throws InterruptedException{
    	
    	//Invoking Browser 
    	//Chrome - ChromeDriver exten-->Methods close get
    	//Firefox - FirefoxDriver -->methods close get
    	//safari SafariDriver -->methods close get
    	//WebDriver close get
    	//WebDrive methods + Chrome browser 
    	
    	
    	//chromedriver.exe--> chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
        

        // webdriver.chrome.driver-->value of path
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        //firefox Launch
        //geckodriver
        
        //webdriver.gecko.driver
//    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\geckodriver.exe");
//    	System.setProperty("webdriver.gecko.driver", "/home/sunil/Downloads/Selenium Drivers/geckodriver-v0.34.0-linux64/geckodriver");
//        WebDriver driver = new FirefoxDriver();
        
        //webdriver.gecko.driver
//    	System.setProperty("webdriver.edge.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\msedgedriver.exe");
//    	System.setProperty("webdriver.edge.driver", "kali");
//        WebDriver driver2 = new EdgeDriver();
        
        
        driver.get("https://astrovastutalks.com/vendor-register");
       
//       System.out.println(driver.getTitle());
//       System.out.println(driver.getCurrentUrl());
//       driver.close();
//       driver.quit();
        driver.findElement(By.id("validationCustom01")).sendKeys("Sunil");
        driver.findElement(By.id("inputEmail4")).sendKeys("suniallaaa@gmail.com");
        driver.findElement(By.id("inputPassword4")).sendKeys("9877745654");
        driver.findElement(By.name("firm_name")).sendKeys("Ram lal and son's Traders");
        driver.findElement(By.id("gst_no")).sendKeys("AAA09QWERT1234HAD");
        driver.findElement(By.id("autocomplete")).sendKeys("kota");
        driver.findElement(By.id("inputZip")).sendKeys("324009");
        driver.findElement(By.className("note-editable")).sendKeys("test");
        
       
//        driver.findElement(By.cssSelector("#continue")).click();
        
        WebElement element = driver.findElement(By.id("continue"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        
       System.out.println(driver.findElement(By.cssSelector("body > section:nth-child(8) > form:nth-child(2) > div:nth-child(1) > div:nth-child(3) > p:nth-child(3)")).getText());
       System.out.println(driver.findElement(By.cssSelector("div[class='col-4'] div p[class='text-danger text-xs mt-2']")).getText());
     
       
       
        driver.close();
       
  
      
        
        
    }
}
