package TestingAcademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumdemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 driver.findElement(By.id("inputUsername")).sendKeys("sunil");
		 driver.findElement(By.name("inputPassword")).sendKeys("sunil123");
		 driver.findElement(By.className("signInBtn")).click();
		 
		 System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		 
		 driver.findElement(By.linkText("Forgot your password?")).click();
		 
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
		 driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@maaal.co");
		 driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		 driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("johnnnn@mail.com");
		 driver.findElement(By.xpath("//form/input[3]")).sendKeys("9667737387");
		 driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		 System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		 
		 driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		 
		 Thread.sleep(1000);
		
		 driver.findElement(By.cssSelector("#inputUsername")).sendKeys("sunil");
		 driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		 
		 driver.findElement(By.id("chkboxOne")).click();
		 driver.findElement(By.id("chkboxTwo")).click();
		 
		 driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		 
//		 driver.close();
	}

}
