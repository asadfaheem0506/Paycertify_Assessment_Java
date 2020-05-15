package com.orbitz.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserUtils {
    private static WebDriver driver;

    public BrowserUtils() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToWindow() {
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
        }
    }

    public static void clearAndFillText(WebElement element, String text) {
        element.click();
        staticWait(300);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"), (text));
    }

    public static List<WebElement> getElements(String text) {
        staticWait(300);
        return Driver.getDriver().findElements(By.xpath(text));
    }

    public static void staticWait(int timeInMilliSeconds) {
        try {
            Thread.sleep(timeInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

