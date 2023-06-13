package com.travel.pages;

import com.travel.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripBookingPage extends BasePage{

    public TripBookingPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//h2[@id='dates_and_prices_title']")
    public WebElement scrollDown;

    @FindBy(xpath = "//div[@class='nbf_tpl_pms_calendar_next nbf_tpl_pms_calendar_update']")
    public WebElement nextButton;

    @FindBy(xpath = "//div[@class='nbf_tpl_pms_calendar']/div/div[3]/label")
    public WebElement label;

    @FindBy(xpath = "//span[@id='tour-price']/span")
    public WebElement totalPrice;

    @FindBy(xpath = "//div[@class='fielderror']")
    public WebElement errorField;

    @FindBy(xpath = "//div[@id='paxDepDateInfo']")
    public WebElement dateDeparturePassengerField;

    @FindBy(xpath = "//div[@class='nbf_tpl_pms_bf_passenger_number unit size1of2 lastUnit']")
    public WebElement adultQuantity;

    @FindBy(xpath = "//div[@class='nbf_tpl_pms_bf_departure_value unit size1of2 lastUnit']")
    public WebElement departureAirport;

    @FindBy(xpath = "//div[@class='nbf_tpl_pms_bf_departuredate']")
    public WebElement departureDate;

    @FindBy(xpath = "//div[@id='accommodationSelection']")
    public WebElement accommodationSelection;

    @FindBy(xpath = "(//div[@class='nbf_grid_item nbf_w25 txt-right'])[1]/select")
    public WebElement roomType;

    @FindBy(xpath = "//button[@class='nbf_button nbf_tpl_pms_book_button']")
    public WebElement selectYourRoomButton;

    @FindBy(xpath = "//select[@id='pax-a-title-1']")
    public WebElement firstTitleField;

    @FindBy(xpath = "//select[@id='pax-a-title-2']")
    public WebElement secondTitleField;

    @FindBy(xpath = "//input[@id='contact-name']")
    public WebElement inputContactName;

    @FindBy(xpath = "//input[@id='contact-mobile']")
    public WebElement inputContactPhoneNumber;

    @FindBy(xpath = "//input[@id='contact-email']")
    public WebElement inputContactEmail;

    @FindBy(xpath = "//input[@id='contact-address1']")
    public WebElement inputAddress1;

    @FindBy(xpath = "//input[@id='contact-address2']")
    public WebElement inputAddress2;

    @FindBy(xpath = "//input[@id='contact-city']")
    public WebElement inputCity;

    @FindBy(xpath = "//input[@id='contact-postcode']")
    public WebElement inputPostCode;

    @FindBy(xpath = "//select[@id='contact-country']")
    public WebElement selectCountry;

    @FindBy(xpath = "//select[@id='contact-hearabout']")
    public WebElement hearAboutField;

    @FindBy(xpath = "//h1[.='Confirm Details + Book']")
    public WebElement confirmDetails;

    @FindBy(xpath = "//button[@id='nbf_booknow_button']")
    public WebElement bookNowButton;

    @FindBy(xpath = "//input[@id='terms-accept']")
    public WebElement termsAndConditionCheckBox;

}
