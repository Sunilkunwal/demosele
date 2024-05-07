package TestingAcademy;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_Handling {

	public static void main(String[] args) throws IOException {
		
//		System.setProperty("webdriver.chrome.driver",
//				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		
//		open InsecureWebsite 
		ChromeOptions IneWeb = new ChromeOptions();
		IneWeb.setAcceptInsecureCerts(true);
		
//		Proxy setup
//		Proxy proxy = new Proxy();
//		proxy.setHttpProxy("ipaddress:4444");
//		IneWeb.setCapability("proxy", proxy);
		
//		Block pop-up windows
//		ChromeOptions popUp = new ChromeOptions(); 
//		popUp.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
//		Set download directory 
//		ChromeOptions directory = new ChromeOptions();
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.default_directory", "/directory/path");
//		directory.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(IneWeb);
//		driver.manage().window().maximize();			//maximize windows 
//		driver.manage().deleteAllCookies();				//delete cookies 
//		driver.manage().deleteCookieNamed("sessionkey");
		
		driver.get("https://expired.badssl.com/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\pc\\Downloads\\Selenium ScreenShot\\screenshot.png"));
		
		System.out.println(driver.getTitle());
	}

}
