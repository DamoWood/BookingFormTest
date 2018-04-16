package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;

    public WebDriverManager() {
        createDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver createDriver() {
        String testUrl = "http://hotel-test.equalexperts.io/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(testUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
