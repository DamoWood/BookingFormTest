package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.TestContext;
import pages.HomePage;

public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^I am on the booking form home page$")
    public void iAmOnTheBookingFormHomePage() {
    }

    @When("^I enter a new booking$")
    public void iEnterANewBooking() {
        homePage.enterBooking("Jack", "White", "50", "false");
    }

    @When("^I delete the booking$")
    public void iDeleteTheBooking() {
        homePage.deleteBooking();
    }

    @Then("^I should see the booking added to the list of bookings$")
    public void iShouldSeeTheBookingAddedToTheListOfBookings() {
        homePage.checkThereIsANewBooking();
    }

    @Then("^I should see the booking removed from the list of bookings$")
    public void iShouldSeeTheBookingRemovedFromTheListOfBookings() {
        homePage.checkBookingHasBeenRemoved();
    }

    @Given("^I am a user$")
    public void iAmAUser() {
    }

    @When("^I navigate to the homepage$")
    public void iNavigateToTheHomepage() {
    }

    @Then("^I see the booking homepage$")
    public void iSeeTheBookingHomepage() {
        homePage.validatePage();
    }

    @When("^I enter a new booking with missing data in the (.*) field$")
    public void iEnterANewBookingWithMissingDataInFields(String field) {
        homePage.enterNewBookingWithMissingField(field);
    }

    @Then("^I should not see the booking added to the booking form$")
    public void iShouldNotSeeTheBookingAddedToTheBookingForm() {
        homePage.checkBookingHasNotBeenAdded();
    }
}