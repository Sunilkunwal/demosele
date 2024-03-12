package First.demosele;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyTest {
    public static void main(String[] args) {
        // Specify the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pc\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Instantiate ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Add headless argument
        options.addArguments("--headless");

        // Pass ChromeOptions to ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // Example: Navigate to a website
        driver.get("https://astro.synilogictech.com/");

        // Example: Print the page title
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
