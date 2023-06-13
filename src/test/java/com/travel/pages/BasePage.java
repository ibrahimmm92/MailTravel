package com.travel.pages;

import com.github.javafaker.Faker;
import com.travel.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    Faker faker = new Faker();

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookiesButton;

    @FindBy(xpath = "//input[@id='searchtext_freetext_search_form']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@id='as_searchtext_freetext_search_form']/ul/li")
    public WebElement firstSelect;

    public void bookOnlineButton(int btn) {

        WebElement button = Driver.getDriver().findElement(By.xpath("(//button[@class='nbf_button nbf_tpl_pms_book_button nbf_rcorners'])["+ btn +"]"));

        button.click();
    }

    public void firstNameSelect(int number){

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@id='pax-a-first-"+number+"']"));
        firstName.sendKeys(faker.name().firstName());

    }

    public void lastNameSelect(int number){

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@id='pax-a-last-"+number+"']"));
        firstName.sendKeys(faker.name().lastName());

    }

    public void selectDay(int number){
        WebElement day = Driver.getDriver().findElement(By.xpath("//select[@id='pax-a-dobd-"+number+"']"));
        Select selectDay = new Select(day);
        selectDay.selectByValue(String.valueOf(faker.number().numberBetween(1,31)));
    }

    public void selectMonth(int number){
        WebElement month = Driver.getDriver().findElement(By.xpath("//select[@id='pax-a-dobm-"+number+"']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue(String.valueOf(faker.number().numberBetween(1,12)));
    }

    public void selectYear(int number){
        WebElement year = Driver.getDriver().findElement(By.xpath("//select[@id='pax-a-doby-"+number+"']"));
        Select selectYear = new Select(year);
        selectYear.selectByValue(String.valueOf(faker.number().numberBetween(1970,1985)));
    }

    public void continueButton(String str){
        WebElement button = Driver.getDriver().findElement(By.xpath("//*[.='"+str+"']"));
        button.click();
    }

}
