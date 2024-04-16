package First.demosele;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AstrologerRegistration {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();

//		  Astrologer Image
		driver.get("https://astrovastutalks.com/astrologer-register");
		File uploadFile = new File("src\\test\\java\\First\\demosele\\userimage.png");

		WebElement fileInput = driver.findElement(By.cssSelector("#astro_img"));
		fileInput.sendKeys(uploadFile.getAbsolutePath());

//		 Name
		driver.findElement(By.xpath("//input[@id='validationCustom01']")).sendKeys("Sunil");

//		 Display Name
		driver.findElement(By.cssSelector("#validationCustom02")).sendKeys("Astro Sunil");

//		 Email
		driver.findElement(By.cssSelector("#inputEmail4")).sendKeys("Sunil452@mail.com");

//		 Mobile No.
		driver.findElement(By.cssSelector(
				"body > section:nth-child(8) > form:nth-child(1) > div:nth-child(1) > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > input:nth-child(2)"))
				.sendKeys("9878974785");

//		  Birth Date
		driver.findElement(By.name("birth_date")).sendKeys("01january	2024");

//		Gender 
		WebElement staticDropdown = driver.findElement(By.name("gender"));
		Select dropdownGender = new Select(staticDropdown);
		dropdownGender.selectByValue("female");

//		Experience(Years) 	
		driver.findElement(By.cssSelector("input[placeholder='Experience']")).sendKeys("5");

//		Category 

//		Language 

//		Skills 

//		 House No
		driver.findElement(By.cssSelector("#house_no")).sendKeys("5");

//		 Street Area
		driver.findElement(By.cssSelector("#street_area")).sendKeys("boarkheda");

//		 Landmark
		driver.findElement(By.cssSelector("#landmark")).sendKeys("Kanchan resort");

//		  Select your Location
//		driver.findElement(By.id("autocomplete")).sendKeys("kota");
//		List<WebElement> options = driver.findElements(By.xpath("//div[@class='pac-item'] /span"));
//
//		for (WebElement option : options) {
//
//			if (option.getText().equalsIgnoreCase("kota")) {
//				option.click();
//				break;
//			}
//		}

//		 Pincode
		driver.findElement(By.cssSelector("#inputZip")).sendKeys("324005");

//		 PAN Number
		driver.findElement(By.cssSelector(
				"body > section:nth-child(8) > form:nth-child(1) > div:nth-child(1) > div:nth-child(21) > input:nth-child(2)"))
				.sendKeys("QWERT1234L");

//		 Long Biography
		driver.findElement(By.cssSelector("div[role='textbox']")).sendKeys("Test Description");

//		 Bank Name
		driver.findElement(By.cssSelector("input[placeholder='Bank Name']")).sendKeys("State Bank Of India");

//		 IFSC Code
		driver.findElement(By.cssSelector("input[placeholder='IFSC Code']")).sendKeys("SBIN0032065");

//		 Account No
		driver.findElement(By.cssSelector("input[placeholder='Account No']")).sendKeys("58846976548");

//		  Account Type
		WebElement staticDropdownAC = driver.findElement(By.name("account_type"));
		Select dropdownAccount = new Select(staticDropdownAC);
		dropdownAccount.selectByVisibleText("Current");

//		 Account Holder Name
		driver.findElement(By.cssSelector("input[placeholder='Account Holder Name']")).sendKeys("John Methew");

//		 Add Document

//		  Do You Have Any Writing Experience

//		 Writing Language
		driver.findElement(By.cssSelector("#writing_language")).sendKeys("test");

//		 Writing Details
		driver.findElement(By.cssSelector("#writing_details")).sendKeys("test");

//		  Do You Have Any Teaching Experience

//		 Teaching Subjects
		driver.findElement(By.cssSelector("#teaching_subject")).sendKeys("test");

//		 Teaching Year (Number of Years)
		driver.findElement(By.xpath("//input[@id='teaching_year']")).sendKeys("10");

//		  Do You Have Any Existing Website

//		 Your Existing Consultation Fees
		driver.findElement(By.cssSelector("#existing_fees")).sendKeys("500");

//		  Are You Associate With any Temple

//		  
//		  
//		  
//		  
//		  WebElement dropdownAvailableGadgets = driver.findElement(By.xpath("//section[contains(@class,'text-light bg-light p-2 formsection')]//form"));
//		  dropdownAvailableGadgets.click();
//	      WebElement option = driver.findElement(By.xpath("//section[contains(@class,'text-light bg-light p-2 formsection')]//form//option[text()='Desktop']"));
//	      option.click();
//	      

//	      WebElement dropdownCategory = driver.findElement(By.xpath("//section[contains(@class,'text-light bg-light p-2 formsection')]//form"));
//	      dropdownCategory.click();

//	      WebElement element = driver.findElement(By.id("continue"));
//	      Actions actions = new Actions(driver);
//	      actions.moveToElement(element).click().build().perform();

		// css div[class='pac-item'] span
//		driver.findElement(By.id("autocomplete")).sendKeys("kota");
//		Thread.sleep(2000);
//		List<WebElement> options = driver.findElements(By.cssSelector("iv[class='pac-item'] span"));
//
//		for (WebElement option11 : options) {
//
//			if (option11.getText().equalsIgnoreCase("Rajasthan, India")) {
//				option11.click();
//				break;
//			}
//		}

//	        WebElement uploadButton = driver.findElement(By.cssSelector(".upload-icn"));
//	        uploadButton.click();
//	        WebElement fileInput = driver.findElement(By.cssSelector(".upload-icn"));
//	        fileInput.sendKeys("C:\\Users\\pc\\Downloads\\6369.jpg");

	}
}
