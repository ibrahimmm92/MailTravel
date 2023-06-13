package com.travel.step_definitions;

import com.github.javafaker.Faker;
import com.travel.pages.BasePage;
import com.travel.pages.TripBookingPage;
import com.travel.utilities.BrowserUtils;
import com.travel.utilities.ConfigurationReader;
import com.travel.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;

import static com.travel.step_definitions.Hooks.driver;

public class MainPage {

    BasePage basePage = new BasePage();
    TripBookingPage tripBookingPage = new TripBookingPage();
    Faker faker = new Faker();

    //-----step1----//
    @Given("User goes into the given page")
    public void user_goes_into_the_given_page() {
        driver.get(ConfigurationReader.getProperty("url"));
    }

    @Then("User sees {string} on page title")
    public void user_sees_on_page_title(String str) {
        String expected = "Home Page | Mail Travel";
        BrowserUtils.verifyTitle(expected);
    }

    @Then("User clicks cookies button")
    public void userClicksCookiesButton() {
        BrowserUtils.sleep(2);
        basePage.cookiesButton.click();
        BrowserUtils.sleep(2);
    }

    //-----step2-----//
    @When("User searches for India in search bar")
    public void userSearchesForIndiaInSearchBar() {
        basePage.searchInput.sendKeys("India");
        basePage.firstSelect.click();
    }

    //-----step3-----//
    @When("User clicks {int} book online button")
    public void userClicksBookOnlineButton(int button) {
        basePage.bookOnlineButton(button);
    }

    @Then("User can not see message to the User {string}")
    public void userCanNotSeeMessageToTheUser(String str) {
        Assert.assertEquals(tripBookingPage.errorField.getText(), str);
    }

    //-----step4-----//
    @When("User selects available date")
    public void userSelectsAvailableDate() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", tripBookingPage.scrollDown);
        js.executeScript("arguments[0].click();", tripBookingPage.nextButton);
        BrowserUtils.sleep(2);
        js.executeScript("arguments[0].click();", tripBookingPage.nextButton);
        BrowserUtils.sleep(2);
        tripBookingPage.label.click();

    }

    @When("User selects {string} Adults")
    public void userSelectsAdults(String adults) {
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='numAdults']")));
        select.selectByValue(adults);
    }

    @Then("User sees the total price")
    public void userSeesTheTotalPrice() {

        String totalPriceText = tripBookingPage.totalPrice.getText();
        Assert.assertEquals("prices are not equal", totalPriceText, "£3,998");

    }

    //-----step5-----//
    @When("User clicks on section for Date, Departure & Passengers")
    public void user_clicks_on_section_for_date_departure_passengers() {
        BrowserUtils.sleep(4);
        tripBookingPage.dateDeparturePassengerField.click();
    }

    @Then("User sees quantity {string} for number of Adults")
    public void user_sees_quantity_for_number_of_adults(String number) {
        BrowserUtils.sleep(2);
        Assert.assertEquals(tripBookingPage.adultQuantity.getText(), number);
    }

    @Then("User sees departure airport {string}")
    public void user_sees_departure_airport(String string) {
        Assert.assertTrue(tripBookingPage.departureAirport.getText().contains(string));
    }

    @Then("User sees departure date")
    public void user_sees_departure_date() {
        String departureDate = "Mon, 15 Jan 2024";
        Assert.assertEquals(tripBookingPage.departureDate.getText(), departureDate);
    }

    @When("User clicks on section for Accommodation details")
    public void user_clicks_on_section_for_Accommodation_details() {
        tripBookingPage.accommodationSelection.click();
    }

    @When("User selects twin room")
    public void user_selects_twin_room() {
        Select select = new Select(tripBookingPage.roomType);
        select.selectByValue("1");
    }

    @Then("User clicks on {string}")
    public void user_clicks_on(String string) {
        BrowserUtils.sleep(2);
        tripBookingPage.selectYourRoomButton.click();
    }

    //-----step6-----//
    @And("User selects first {string} on Passenger Details field")
    public void userSelectsFirstOnPassengerDetailsField(String str) {
        Select select = new Select(tripBookingPage.firstTitleField);
        select.selectByValue(str);
    }

    @And("User selects second {string} on Passenger Details field")
    public void userSelectsSecondOnPassengerDetailsField(String str) {
        Select select = new Select(tripBookingPage.secondTitleField);
        select.selectByValue(str);
    }

    @And("User types First Name on Adult {int}")
    public void userTypesFirstNameOnAdult(int number) {
        basePage.firstNameSelect(number);
    }

    @And("User types Last Name on Adult {int}")
    public void userTypesLastNameOnAdult(int number) {
        basePage.lastNameSelect(number);
    }

    @And("User selects DOB on Adult {int}")
    public void userSelectsDOBOnAdult(int number) {
        basePage.selectDay(number);
        basePage.selectMonth(number);
        basePage.selectYear(number);
    }

    @When("User types contact name, phone number and email address")
    public void userTypesContactNamePhoneNumberAndEmailAddress() {
        tripBookingPage.inputContactName.sendKeys(faker.name().fullName());
        tripBookingPage.inputContactPhoneNumber.sendKeys(faker.numerify("##########"));
        tripBookingPage.inputContactEmail.sendKeys(faker.internet().emailAddress());
    }

    @And("User types addresses, city and postcode")
    public void userTypesAddressesCityAndPostcode() {
        tripBookingPage.inputAddress1.sendKeys(faker.address().fullAddress());
        tripBookingPage.inputAddress2.sendKeys(faker.address().secondaryAddress());
        tripBookingPage.inputCity.sendKeys(faker.address().city());
        tripBookingPage.inputPostCode.sendKeys(faker.address().zipCode());
    }

    @And("User selects {string} on the form")
    public void userSelects(String str) {

        Select select = new Select(tripBookingPage.selectCountry);
        select.selectByValue(str);

    }

    @When("User selects the option from the list for {string} info")
    public void userSelectsTheOptionFromTheListForInfo(String number) {

        Select select = new Select(tripBookingPage.hearAboutField);
        select.selectByValue(number);

    }

    @And("User clicks on {string} button")
    public void userClicksOnButton(String str) {

        basePage.continueButton(str);

    }

    //-----step7-----//
    @Then("User sees confirmation details {string}")
    public void userSeesConfirmationDetails(String str) {

        Assert.assertEquals(str,tripBookingPage.confirmDetails.getText());

    }

    @Then("User clicks {string} button")
    public void userClicksBookNowButton(String str) {
        tripBookingPage.termsAndConditionCheckBox.click();
        if (str.equalsIgnoreCase("Book Now")){
            Assert.assertTrue(tripBookingPage.bookNowButton.isEnabled());
            tripBookingPage.bookNowButton.click();
        }
    }

}
