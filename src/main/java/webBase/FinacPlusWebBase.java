package webBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FinacPlusWebBase {
    public static WebDriver driver;
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

    public void initializeBrowser() {
        driver = new ChromeDriver();
    }

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void quitBrowser() {
        driver.quit();
    }

    public void scrollIntoElementTillVisible(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}