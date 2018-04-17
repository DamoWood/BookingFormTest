package managers;

import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class PageObjectManager {

    private final HomePage homePage;

    public PageObjectManager(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }
}
