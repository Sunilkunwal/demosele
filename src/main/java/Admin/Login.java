package Admin;

import static org.testng.Assert.expectThrows;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Login {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://astro.synilogictech.com/sy-admin/login");

		// login
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// click on users
		driver.findElement(By.xpath("//a[contains(@href, '#user_management')]")).click();

		// click on astrologer
		WebElement Astrologer = driver.findElement(By.xpath("//span[normalize-space()='Astrologer']"));
		action.moveToElement(Astrologer).click().build().perform();

		// click on add new button
		driver.findElement(By.xpath("//a[contains(text(),'+  Add New')]")).click();

		// Fill From
		driver.findElement(By.id("name")).sendKeys("Test");
		driver.findElement(By.id("email")).sendKeys("test@test.com");
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		driver.findElement(By.id("display_name")).sendKeys("Astro Test");
		WebElement GenderDropDown = driver.findElement(By.id("gender"));
		Select GenderDD = new Select(GenderDropDown);
		GenderDD.selectByValue("male");
		driver.findElement(By.id("house_no")).sendKeys("123");
		driver.findElement(By.id("street_area")).sendKeys("borkhedha");
		driver.findElement(By.id("landmark")).sendKeys("near kanchan resort");

		// Address
		WebElement Address = driver.findElement(By.xpath("//div[@role='textbox']//p"));
		action.moveToElement(Address).click().build().perform();
		WebElement AddressField = driver.findElement(By.name("address"));
		AddressField.sendKeys("kota");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//body/div[@class='pac-container pac-logo']/div[1]/span[2]/span[1]")));
		AddressField.sendKeys(Keys.DOWN);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//body/div[@class='pac-container pac-logo']/div[1]/span[2]/span[1]")));
		AddressField.sendKeys(Keys.TAB);

		driver.findElement(By.id("pin_code")).sendKeys("324005");
		driver.findElement(By.id("birth_date")).sendKeys("01january	2000");
		driver.findElement(By.id("inputPanNumber")).sendKeys("qwert1234a");

		// upload profile image
		WebElement AstroImage = driver.findElement(By.id("astro_img"));
		File UploadFile = new File("src\\test\\java\\First\\demosele\\userimage.png");
		AstroImage.sendKeys(UploadFile.getAbsolutePath());

		driver.findElement(By.id("experience")).sendKeys("5");
		driver.findElement(By.xpath("//input[@id='New']")).click();

		// Language
		WebElement LanguageField = driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]"));
		action.moveToElement(LanguageField).click().sendKeys(Keys.ENTER).build().perform();

		// Category
		WebElement CategoryField = driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[2]"));
		action.moveToElement(CategoryField).click().sendKeys(Keys.ENTER).build().perform();

		// Skill
		WebElement SkillField = driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[3]"));
		action.moveToElement(SkillField).click().sendKeys(Keys.ENTER).build().perform();

		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("test");
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(Keys.TAB);

		driver.findElement(By.id("admin_percentage")).sendKeys("50");
		driver.findElement(By.id("call_price")).sendKeys("10");
		driver.findElement(By.id("internal_call_price")).sendKeys("10");
		driver.findElement(By.id("chat_price")).sendKeys("10");
		driver.findElement(By.id("video_price")).sendKeys("10");
		driver.findElement(By.id("callwithlive_price")).sendKeys("10");
		driver.findElement(By.id("videocallwithlive_price")).sendKeys("10");

//		 Add Document
		WebElement AddButton = driver.findElement(By.cssSelector("[class='btn btn-success add-tr']"));
		action.moveToElement(AddButton).click().build().perform();
		WebElement DocumentDropdown1 = driver.findElement(By.id("th1"));
		Select Docdropdown1 = new Select(DocumentDropdown1);
		Docdropdown1.selectByValue("Aadhaar Card");
		WebElement fileInputADfront = driver.findElement(By.cssSelector("[id='front']"));
		fileInputADfront.sendKeys(UploadFile.getAbsolutePath());
		WebElement fileInputADback = driver.findElement(By.cssSelector("[id='back']"));
		fileInputADback.sendKeys(UploadFile.getAbsolutePath());
		action.moveToElement(AddButton).click().build().perform();
		WebElement DocumentDropdown2 = driver.findElement(By.id("th2"));
		Select Docdropdown2 = new Select(DocumentDropdown2);
		Docdropdown2.selectByValue("Pan Card");
		WebElement fileInputPCfront = driver.findElement(By.xpath("(//input[@id='front'])[2]"));
		fileInputPCfront.sendKeys(UploadFile.getAbsolutePath());
		WebElement fileInputPCback = driver.findElement(By.xpath("(//input[@id='back'])[2]"));
		fileInputPCback.sendKeys(UploadFile.getAbsolutePath());

		// Add Gallery Images
		WebElement AddGaralerrButton = driver.findElement(By.cssSelector("[class='btn btn-success add-tr-gallery']"));
		action.moveToElement(AddGaralerrButton).click().build().perform();
		WebElement GalleryImage = driver.findElement(By.xpath("(//input[@id='image'])[1]"));
		GalleryImage.sendKeys(UploadFile.getAbsolutePath());
		action.moveToElement(AddGaralerrButton).click().build().perform();
		WebElement GalleryImage2 = driver.findElement(By.xpath("(//input[@id='image'])[2]"));
		GalleryImage2.sendKeys(UploadFile.getAbsolutePath());

//		  Do You Have Any Writing Experience
		WebElement RadioWriting = driver.findElement(By.id("writing_experience"));
		action.moveToElement(RadioWriting).click().build().perform();

//		 Writing Language
		driver.findElement(By.cssSelector("#writing_language")).sendKeys("test");

//		 Writing Details
		driver.findElement(By.cssSelector("#writing_details")).sendKeys("test");

//		  Do You Have Any Teaching Experience
		WebElement RadioTeaching = driver.findElement(By.id("teaching_experience"));
		action.moveToElement(RadioTeaching).click().build().perform();

//		 Teaching Subjects
		driver.findElement(By.cssSelector("#teaching_subject")).sendKeys("test");

//		 Teaching Year (Number of Years)
		driver.findElement(By.xpath("//input[@id='teaching_year']")).sendKeys("10");

//		  Do You Have Any Existing Website
		WebElement RadioWebsite = driver.findElement(By.id("existing_website"));
		action.moveToElement(RadioWebsite).click().build().perform();

//		 Your Existing Consultation Fees
		driver.findElement(By.cssSelector("#existing_fees")).sendKeys("500");

//		  Are You Associate With any Temple
		WebElement RadioTemple = driver.findElement(By.id("associate_temple"));
		action.moveToElement(RadioTemple).click().build().perform();

		// Available Gadgets
		WebElement GadgetsField = driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[4]"));
		action.moveToElement(GadgetsField).click().sendKeys(Keys.ENTER).build().perform();

		// submit
		WebElement SubmitButton = driver.findElement(By.xpath("//button[normalize-space()='CREATE']"));
		action.moveToElement(SubmitButton).click().build().perform();

		// submit Toast
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='alert alert-danger alert-dismissible text-white']")));
		System.out.println(driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible text-white']")).getText());

//		driver.close();
	}

}
