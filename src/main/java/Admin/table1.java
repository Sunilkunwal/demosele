package Admin;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Wait;

public class table1 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String astroMobileNumber = "+918104488289";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://astro.synilogictech.com/sy-admin/login");

        // Login
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Click on "Users"
        driver.findElement(By.xpath("//a[contains(@href, '#user_management')]")).click();

        // Click on "Astrologer"
        WebElement astrologer = driver.findElement(By.xpath("//span[normalize-space()='Astrologer']"));
        action.moveToElement(astrologer).click().build().perform();

        // Define elements for navigation and status button
        WebElement nextPage = driver.findElement(By.xpath("//a[contains(text(),'›')]"));
        List<WebElement> statusButton = driver.findElements(By.cssSelector(".form-check-input.updateStatus"));

        // Loop to search for the desired mobile number
        List<String> row;
        do {
            List<WebElement> mobileRows = driver.findElements(By.xpath("//tr/td[4]"));
            row = locateMobileNumber(js, mobileRows, astroMobileNumber);
            row.forEach(System.out::println);
            if (row.size() < 1) {
                action.moveToElement(nextPage).click().build().perform();
            }
        } while (row.size() < 1);

        // Click on the status button
        action.moveToElement(statusButton.get(0)).click().build().perform();

        driver.quit();
    }

    private static List<String> locateMobileNumber(JavascriptExecutor js, List<WebElement> mobileRows, String astroMobileNumber) {
        return mobileRows.stream().filter(s -> {
            String script = "return arguments[0].textContent.trim();";
            String mobileText = (String) js.executeScript(script, s);
            return mobileText.contains(astroMobileNumber);
        }).map(s -> getAstroMobileNumber(s)).collect(Collectors.toList());
    }

    private static String getAstroMobileNumber(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[3]")).getText();
    }
}
