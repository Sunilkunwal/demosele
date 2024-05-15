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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AstrologerRegistration {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

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
		driver.findElement(By.cssSelector("#inputEmail4")).sendKeys("Suni11lhfjvd754@mail.com");

//		 Mobile No.
		driver.findElement(By.cssSelector("[class='form-control integer_number_only intlinput']"))
				.sendKeys("9874541251");

//		  Birth Date
		driver.findElement(By.name("birth_date")).sendKeys("01january	2024");

//		Gender 
		WebElement staticDropdown = driver.findElement(By.name("gender"));
		Select dropdownGender = new Select(staticDropdown);
		dropdownGender.selectByValue("female");

//		Experience(Years) 	
		driver.findElement(By.cssSelector("input[placeholder='Experience']")).sendKeys("5");

//		Category 
		Actions a = new Actions(driver);
		WebElement CategoryField = driver
				.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[1]"));
		a.moveToElement(CategoryField).click().build().perform();
		WebElement VedicAstrologyoption = driver.findElement(By.xpath("//li[@class='select2-results__option'][1]"));
		VedicAstrologyoption.click();

//		Language 
		WebElement LanguageField = driver
				.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[2]"));
		a.moveToElement(LanguageField).click().build().perform();
		WebElement Englishoption = driver.findElement(By.xpath("//li[@class='select2-results__option'][1]"));
		Englishoption.click();

//		Skills 
		WebElement SkillsField = driver
				.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[3]"));
		a.moveToElement(SkillsField).click().build().perform();
		WebElement ChildBirthoption = driver.findElement(By.xpath("//li[@class='select2-results__option'][1]"));
		ChildBirthoption.click();

//		 House No
		driver.findElement(By.cssSelector("#house_no")).sendKeys("5");

//		 Street Area
		driver.findElement(By.cssSelector("#street_area")).sendKeys("boarkheda");

//		 Landmark
		driver.findElement(By.cssSelector("#landmark")).sendKeys("Kanchan resort");

//		  Select your Location
		WebElement BankDetails = driver.findElement(By.xpath("//h2[normalize-space()='Bank Deatils']"));
		a.moveToElement(BankDetails).click().build().perform();
		driver.findElement(By.id("autocomplete")).sendKeys("kota");
		List<WebElement> Locationoptions = driver
				.findElements(By.xpath("//body/div[@class='pac-container pac-logo']/div[1]/span[2]/span[1]"));

		System.out.println(Locationoptions);
		for (WebElement optionL : Locationoptions) {

			if (optionL.getText().equalsIgnoreCase("kota")) {
				Thread.sleep(1000);
				optionL.click();
				break;
			}
		}

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
		WebElement AddButton = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
		a.moveToElement(AddButton).click().build().perform();
		WebElement DocumentDropdown1 = driver.findElement(By.id("th0"));
		Select Docdropdown1 = new Select(DocumentDropdown1);
		Docdropdown1.selectByValue("Aadhaar Card");
		WebElement fileInputADfront = driver.findElement(By.cssSelector("[id='front']"));
		fileInputADfront.sendKeys(uploadFile.getAbsolutePath());
		WebElement fileInputADback = driver.findElement(By.cssSelector("[id='back']"));
		fileInputADback.sendKeys(uploadFile.getAbsolutePath());
		a.moveToElement(AddButton).click().build().perform();
		WebElement DocumentDropdown2 = driver.findElement(By.id("th1"));
		Select Docdropdown2 = new Select(DocumentDropdown2);
		Docdropdown2.selectByValue("Pan Card");
		WebElement fileInputPCfront = driver.findElement(By.xpath("(//input[@id='front'])[2]"));
		fileInputPCfront.sendKeys(uploadFile.getAbsolutePath());
		WebElement fileInputPCback = driver.findElement(By.xpath("(//input[@id='back'])[2]"));
		fileInputPCback.sendKeys(uploadFile.getAbsolutePath());

//		  Do You Have Any Writing Experience
		WebElement RadioWriting = driver.findElement(By.id("writing_experience"));
		a.moveToElement(RadioWriting).click().build().perform();

//		 Writing Language
		driver.findElement(By.cssSelector("#writing_language")).sendKeys("test");

//		 Writing Details
		driver.findElement(By.cssSelector("#writing_details")).sendKeys("test");

//		  Do You Have Any Teaching Experience
		WebElement RadioTeaching = driver.findElement(By.id("teaching_experience"));
		a.moveToElement(RadioTeaching).click().build().perform();

//		 Teaching Subjects
		driver.findElement(By.cssSelector("#teaching_subject")).sendKeys("test");

//		 Teaching Year (Number of Years)
		driver.findElement(By.xpath("//input[@id='teaching_year']")).sendKeys("10");

//		  Do You Have Any Existing Website
		WebElement RadioWebsite = driver.findElement(By.id("existing_website"));
		a.moveToElement(RadioWebsite).click().build().perform();

//		 Your Existing Consultation Fees
		driver.findElement(By.cssSelector("#existing_fees")).sendKeys("500");

//		  Are You Associate With any Temple
		WebElement RadioTemple = driver.findElement(By.id("associate_temple"));
		a.moveToElement(RadioTemple).click().build().perform();

//		Available Gadgets
		WebElement GadgetsField = driver
				.findElement(By.xpath("(//span[@class='select2-selection select2-selection--multiple'])[4]"));
		a.moveToElement(GadgetsField).click().build().perform();
		WebElement Desktopoption = driver.findElement(By.xpath("//li[@class='select2-results__option'][1]"));
		Desktopoption.click();

		// submit
		WebElement SubmitButton = driver.findElement(By.id("continue"));
		a.moveToElement(SubmitButton).click().build().perform();
		
		//submit Toast
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		

	}
}
