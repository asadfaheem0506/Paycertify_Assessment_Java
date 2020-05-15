package com.orbitz.pages;

import com.orbitz.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements {

    private WebDriver driver;

    public Elements() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='primary-header-flight']")
    public WebElement flightsBtn;

    @FindBy(xpath = "(//div[@class='col gcw-sub-nav-option-wrapper sub-nav-radio-button-for-high-contrast-mode'])[3]")
    public WebElement multiCityBtn;

    @FindBy(xpath = "(//span[@class='icon icon-close'])[2]")
    public WebElement notifCloseBtn;

    @FindBy(xpath = "//select[@id='flight-adults-flp']")
    public WebElement adultAgeBtn;

    @FindBy(xpath = "(//option[@value='2'])[1]")
    public WebElement adultAgeSelectBtn;

    @FindBy(xpath = "//select[@id='flight-children-flp']")
    public WebElement childrenBtn;

    @FindBy(xpath = "(//option[@value='2'])[2]")
    public WebElement childrenNumBtn;

    @FindBy(xpath = "(//span[contains(text(), 'Child 1 age')])[1]")
    public WebElement child1AgeLabel;

    @FindBy(xpath = "//select[@id='flight-age-select-1-flp']")
    public WebElement children1AgeBtn;

    @FindBy(xpath = "(//option[@value='10'])[1]")
    public WebElement children1AgeSelectBtn;

    @FindBy(xpath = "//select[@id='flight-age-select-2-flp']")
    public WebElement children2AgeBtn;

    @FindBy(xpath = "(//option[@value='6'])[4]")
    public WebElement children2AgeSelectBtn;

    @FindBy(xpath = "//a[@class='secondary gcw-add-fields']")
    public WebElement addFlightBtn;

    @FindBy(xpath = "(//input[@class='clear-btn-input gcw-storeable text gcw-origin gcw-required gcw-distinct-locations'])[1]")
    public WebElement source1Btn;

    @FindBy(xpath = "(//input[@class='clear-btn-input gcw-storeable text gcw-origin multidest-field'])[1]")
    public WebElement source2Btn;

    @FindBy(xpath = "(//input[@class='clear-btn-input gcw-storeable text gcw-origin multidest-field'])[2]")
    public WebElement source3Btn;

    @FindBy(xpath = "(//input[@class='clear-btn-input gcw-storeable text gcw-destination gcw-required gcw-distinct-locations'])[1]")
    public WebElement destination1Btn;

    @FindBy(xpath = "(//input[@class='clear-btn-input gcw-storeable text gcw-destination multidest-field'])[1]")
    public WebElement destination2Btn;

    @FindBy(xpath = "(//input[@class='clear-btn-input gcw-storeable text gcw-destination multidest-field'])[2]")
    public WebElement destination3Btn;

    @FindBy(xpath = "(//div[@class='multiLineDisplay details'])[2]")
    public WebElement loc1And3Select;

    @FindBy(xpath = "(//div[@class='multiLineDisplay details'])[1]")
    public WebElement loc2Select;

    @FindBy(xpath = "//input[@id='flight-departing-single-flp']")
    public WebElement flight1DateBtn;

    @FindBy(xpath = "//input[@id='flight-2-departing-flp']")
    public WebElement flight2DateBtn;

    @FindBy(xpath = "//input[@id='flight-3-departing-flp']")
    public WebElement flight3DateBtn;

    @FindBy(xpath = "(//button[@class='datepicker-cal-date'])")
    public WebElement datesPicker;

    @FindBy(xpath = "(//button[@class='datepicker-cal-date'])[2]")
    public WebElement flight1Date;

    @FindBy(xpath = "(//button[@class='datepicker-cal-date'])[6]")
    public WebElement flight2Date;

    @FindBy(xpath = "(//button[@class='datepicker-cal-date'])[10]")
    public WebElement flight3Date;

    @FindBy(xpath = "(//button[@class='btn-primary btn-action gcw-submit '])[1]")
    public WebElement searchBtn;

    @FindBy(xpath = "(//div[@class='grid-container standard-padding '])")
    public WebElement flightsResult;

    @FindBy(xpath = "//input[@id='stopFilter_stops-0']")
    public WebElement nonstopFlightSelect;

    @FindBy(xpath = "//input[@id='stopFilter_stops-1']")
    public WebElement onestopFlightSelect;

    @FindBy(xpath = "(//button[@class='btn-secondary btn-action t-select-btn'])[1]")
    public WebElement lowestPriceFlight;

    @FindBy(xpath = "(//span[contains(text(), 'Select this fare')])[1]")
    public WebElement selectFareBtn;

    @FindBy(xpath = "(//span[contains(text(), '+ $0.00')])[1]")
    public WebElement noExtraCostFlight;

    @FindBy(xpath = "(//h2[contains(text(), 'Trip Summary')])[1]")
    public WebElement itineraryConfirmation;

    @FindBy(xpath = "((//div[@class='dateAndOD cf'])[1]//div[@class='airport type-300'])[1]")
    public WebElement flight1Sourceconfirmation;

    @FindBy(xpath = "((//div[@class='dateAndOD cf'])[1]//div[@class='airport type-300'])[2]")
    public WebElement flight1DestConfirmation;

    @FindBy(xpath = "((//div[@class='dateAndOD cf'])[2]//div[@class='airport type-300'])[1]")
    public WebElement flight2Sourceconfirmation;

    @FindBy(xpath = "((//div[@class='dateAndOD cf'])[2]//div[@class='airport type-300'])[2]")
    public WebElement flight2DestConfirmation;

    @FindBy(xpath = "((//div[@class='dateAndOD cf'])[3]//div[@class='airport type-300'])[1]")
    public WebElement flight3Sourceconfirmation;

    @FindBy(xpath = "((//div[@class='dateAndOD cf'])[3]//div[@class='airport type-300'])[2]")
    public WebElement flight3DestConfirmation;
}
