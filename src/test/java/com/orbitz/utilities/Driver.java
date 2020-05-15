package com.orbitz.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class Driver {

    private static WebDriver driver;
    private static String host;

    public static WebDriver getDriver() {
        if (driver == null) {
            if ("api".equalsIgnoreCase(System.getProperty("testType"))) {
                return new HtmlUnitDriver();
            }
            if ("api-remote".equalsIgnoreCase(System.getProperty("testType"))) {
                System.setProperty("browser", "remote-headless");
            }
            if (System.getProperty("browser") == null) {
                System.setProperty("browser", "chrome");
            }
            switch (System.getProperty("browser")) {

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "remote-firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                    host = ConfigurationReader.getProperty("host");
                    try {
                        driver = new RemoteWebDriver(new URL(host + "/wd/hub"), firefoxOptions);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid Host: " + host);
                        System.exit(1);
                    }
                    break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions localChromeOptions = new ChromeOptions();
                    localChromeOptions.addArguments("--start-maximized");
                    localChromeOptions.addArguments("--disable-cache");
                    LoggingPreferences loggingPreferences = new LoggingPreferences();
                    loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
                    localChromeOptions.setCapability("goog:loggingPrefs", loggingPreferences);
                    driver = new ChromeDriver(localChromeOptions);
                    break;

                case "remote-chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-extensions");
                    // chromeOptions.addArguments("--start-maximized");
                    LoggingPreferences loggingPreferences2 = new LoggingPreferences();
                    loggingPreferences2.enable(LogType.PERFORMANCE, Level.ALL);
                    chromeOptions.setCapability("goog:loggingPrefs", loggingPreferences2);
                    chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                    host = ConfigurationReader.getProperty("host");
                    try {
                        driver = new RemoteWebDriver(new URL(host + "/wd/hub"), chromeOptions);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid Host: " + host);
                        System.exit(1);
                    }
                    break;

                case "remote-headless":
                    ChromeOptions headless = new ChromeOptions();
                    headless.addArguments("--no-sandbox");
                    headless.addArguments("--disable-extensions");
                    headless.addArguments("--headless");
                    headless.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                    host = ConfigurationReader.getProperty("host");
                    try {
                        driver = new RemoteWebDriver(new URL(host + "/wd/hub"), headless);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid Host: " + host);
                        System.exit(1);
                    }
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "container-chrome":
                    ChromeOptions localco = new ChromeOptions();
                    localco.addArguments("--no-sandbox");
                    localco.addArguments("--disable-extensions");
                    localco.addArguments("--start-maximized");
                    LoggingPreferences loggingPreferences3 = new LoggingPreferences();
                    loggingPreferences3.enable(LogType.PERFORMANCE, Level.ALL);
                    localco.setCapability("goog:loggingPrefs", loggingPreferences3);
                    localco.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                    host = "http://localhost:4444";
                    try {
                        driver = new RemoteWebDriver(new URL(host + "/wd/hub"), localco);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid Host: " + host);
                        System.exit(1);
                    }
                    break;

                case "container-firefox":
                    FirefoxOptions containerfirefox = new FirefoxOptions();
                    containerfirefox.addArguments("-width -1920");
                    containerfirefox.addArguments("-height 1080");
                    containerfirefox.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                    host = "http://localhost:4444";
                    try {
                        driver = new RemoteWebDriver(new URL(host + "/wd/hub"), containerfirefox);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid Host: " + host);
                        System.exit(1);
                    }
                    break;

                case "container-opera":
                    OperaOptions operaOptions = new OperaOptions();
                    operaOptions.addArguments("-width -1920");
                    operaOptions.addArguments("-height 1080");
                    operaOptions.setCapability(CapabilityType.BROWSER_NAME, "operablink");
                    host = "http://localhost:4444";
                    try {
                        driver = new RemoteWebDriver(new URL(host + "/wd/hub"), operaOptions);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid Host: " + host);
                        System.exit(1);
                    }
                    break;
                default:
                    Assert.fail("browser  = " + System.getProperty("browser") + " | Please check spelling");
            }

        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
