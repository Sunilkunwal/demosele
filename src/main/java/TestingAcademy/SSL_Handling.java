package TestingAcademy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL_Handling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"/home/sunil/Downloads/Selenium Drivers/chromedriver-linux64/chromedriver");
		
//		open InsecureWebsite 
		ChromeOptions IneWeb = new ChromeOptions();
		IneWeb.setAcceptInsecureCerts(true);
		
//		Proxy setup
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		IneWeb.setCapability("proxy", proxy);
		
//		Block pop-up windows
		ChromeOptions popUp = new ChromeOptions(); 
		popUp.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
//		Set download directory 
		ChromeOptions directory = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "/directory/path");
		directory.setExperimentalOption("prefs", prefs);
		
		
		WebDriver driver = new ChromeDriver(IneWeb);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookieNamed("sessionkey");
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
