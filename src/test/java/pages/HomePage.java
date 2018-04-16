package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    private final WebDriver driver;
    private int numberOfBookings;
    private int newNumberOfBookings;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterBooking(String firstName, String lastName, String price, String deposit) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPrice(price);
        selectDeposit(deposit);
        selectCheckInDate();
        selectCheckOutDate();
        saveBooking();
    }

    public void enterNewBookingWithMissingField(String field) {
        switch (field) {
            case "first name":
                enterBooking("", "White", "50", "false");
                break;
            case "surname":
                enterBooking("Jack", "", "50", "false");
                break;
            case "price":
                enterBooking("Jack", "White", "", "false");
                break;
            default:
                throw new IllegalArgumentException("No such field as: " + field);
        }
    }

    private void enterFirstName(String firstName) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
    }

    private void enterLastName(String lastName) {
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    private void enterPrice(String price) {
        driver.findElement(By.id("totalprice")).sendKeys(price);
    }

    private void selectDeposit(String deposit) {
        Select depositDropDown = new Select(driver.findElement(By.id("depositpaid")));
        depositDropDown.selectByVisibleText(deposit);
    }

    private void selectCheckInDate() {
        WebElement datePicker = driver.findElement(By.id("checkin"));
        datePicker.click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")).click();
    }

    private void selectCheckOutDate() {
        WebElement datePicker = driver.findElement(By.id("checkout"));
        datePicker.click();
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a")).click();
    }

    private void saveBooking() {
        numberOfBookings = driver.findElements(By.className("row")).size() - 2;
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[7]/input")).click();

        //TODO Implement a better way of waiting for elements after http calls
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        newNumberOfBookings = driver.findElements(By.className("row")).size() - 2;
    }

    public void deleteBooking() {
        numberOfBookings = driver.findElements(By.className("row")).size() - 2;
        driver.findElements(By.cssSelector("[value='Delete']")).get(0).click();
        newNumberOfBookings = driver.findElements(By.className("row")).size() - 2;
    }

    // Assertions
    public void validatePage() {
        checkTitle();
        checkBookingHeaders();
    }

    private void checkBookingHeaders() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[1]/div[1]/h3")).getText(), "Firstname");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[1]/div[2]/h3")).getText(), "Surname");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[1]/div[3]/h3")).getText(), "Price");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[1]/div[5]/h3")).getText(), "Check-in");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[1]/div[6]/h3")).getText(), "Check-out");
    }

    public void checkThereIsANewBooking() {
        Assert.assertNotEquals(numberOfBookings, newNumberOfBookings);
    }

    public void checkBookingHasBeenRemoved() {
        Assert.assertNotEquals(numberOfBookings, newNumberOfBookings);
    }

    private void checkTitle() {
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText(), "Hotel booking form");
    }

    public void checkBookingHasNotBeenAdded() {
        Assert.assertEquals(numberOfBookings, newNumberOfBookings);
    }
}
