package First.demosele;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AstroSyni {
    public static void main(String[] args) throws InterruptedException {
    	
    	//Invoking Browser 
    	//Chrome - ChromeDriver exten-->Methods close get
    	//Firefox - FirefoxDriver -->methods close get
    	//safari SafariDriver -->methods close get
    	//WebDriver close get
    	//WebDrive methods + Chrome browser 
    	
    	
    	//chromedriver.exe--> chrome browser
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
        

        // webdriver.chrome.driver-->value of path
        WebDriver driver = new ChromeDriver();
        
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
//       System.out.println(driver.getTitle());
//       System.out.println(driver.getCurrentUrl());
//       driver.close();
//       driver.quit();
        driver.findElement(By.id("validationCustom01")).sendKeys("Sunil");
        driver.findElement(By.id("inputEmail4")).sendKeys("sunial@gmail.com");
        driver.findElement(By.id("inputPassword4")).sendKeys("9874564111");
        driver.findElement(By.name("firm_name")).sendKeys("Ram lal and son's Traders");
        driver.findElement(By.id("gst_no")).sendKeys("AAA09QWERT1234HAD");
        driver.findElement(By.id("autocomplete")).sendKeys("kota");
        driver.findElement(By.id("inputZip")).sendKeys("324009");
        driver.findElement(By.className("note-editable")).sendKeys("test");
        driver.findElement(By.id("continue")).click();
        
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".astro-btn")).click();
        
//        driver.close();
  
      
        
        
    }
}
