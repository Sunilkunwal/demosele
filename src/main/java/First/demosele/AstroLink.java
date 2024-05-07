package First.demosele;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AstroLink {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\Selenium Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://astrovastutalks.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int totalLinks = links.size();
        System.out.println("Total links: " + totalLinks);

        for (WebElement link : links) {
            String script = "window.open(arguments[0], '_blank');";
            ((JavascriptExecutor) driver).executeScript(script, link.getAttribute("href"));
            Thread.sleep(1000); // Adjust the wait time if needed
          

            // Switch to the new tab
            Set<String> windowHandles = driver.getWindowHandles();
            String mainHandle = driver.getWindowHandle();
            String newTabHandle = "";
            for (String handle : windowHandles) {
                if (!handle.equals(mainHandle)) {
                    newTabHandle = handle;
                    break;
                }
            }
            driver.switchTo().window(newTabHandle);

            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl()); // Get the current URL
            driver.switchTo().window(mainHandle); // Switch back to the main window
        }
        Assert.assertEquals(totalLinks, links.size());
        driver.quit();
    }
}
