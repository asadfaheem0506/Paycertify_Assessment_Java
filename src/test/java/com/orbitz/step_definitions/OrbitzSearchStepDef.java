package com.orbitz.step_definitions;

import com.orbitz.pages.Elements;
import com.orbitz.utilities.ConfigurationReader;
import com.orbitz.utilities.Driver;
import com.orbitz.utilities.BrowserUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class OrbitzSearchStepDef extends BrowserUtils {
    Elements elements = new Elements();

    @Given("I go to Orbitz")
    public void goToOrbitz() {
        Driver.getDriver().get(ConfigurationReader.getProperty("orbitzUrl"));
    }

    @When("I select flight tab and multi city option")
    public void selectFlightMultiCity() {
        waitForVisibility(elements.flightsBtn, 10);
        elements.flightsBtn.click();
        waitForVisibility(elements.multiCityBtn, 10);
        elements.multiCityBtn.click();
        try {
            elements.notifCloseBtn.click();
        } catch (Exception e) {
            System.out.println("No Notifications present");
        }
    }

    @When("I Search for 2 adults and 2 children with ages")
    public void selectAdultsAndChildren() {
        waitFor(1);
        elements.adultAgeBtn.click();
        waitForVisibility(elements.adultAgeSelectBtn, 10);
        elements.adultAgeSelectBtn.click();
        elements.childrenBtn.click();
        waitForVisibility(elements.childrenNumBtn, 10);
        elements.childrenNumBtn.click();
        elements.children1AgeBtn.click();
        waitForVisibility(elements.children1AgeSelectBtn, 10);
        elements.children1AgeSelectBtn.click();
        elements.children2AgeBtn.click();
        waitForVisibility(elements.children2AgeSelectBtn, 10);
        elements.children2AgeSelectBtn.click();
        waitFor(1);
        elements.child1AgeLabel.click();
    }

    @When("I select route using three flight destinations")
    public void selectFlightDestinations() {
        waitFor(2);
        elements.addFlightBtn.click();
        clearAndFillText(elements.source1Btn, ConfigurationReader.getProperty("DFW"));
        waitForVisibility(elements.loc1And3Select, 10);
        elements.loc1And3Select.click();
        clearAndFillText(elements.destination1Btn, ConfigurationReader.getProperty("SFO"));
        waitForVisibility(elements.loc2Select, 10);
        elements.loc2Select.click();
        clearAndFillText(elements.source2Btn, ConfigurationReader.getProperty("SFO"));
        waitForVisibility(elements.loc2Select, 10);
        elements.loc2Select.click();
        clearAndFillText(elements.destination2Btn, ConfigurationReader.getProperty("NYC"));
        waitForVisibility(elements.loc1And3Select, 10);
        elements.loc1And3Select.click();
        clearAndFillText(elements.source3Btn, ConfigurationReader.getProperty("NYC"));
        waitForVisibility(elements.loc1And3Select, 10);
        elements.loc1And3Select.click();
        clearAndFillText(elements.destination3Btn, ConfigurationReader.getProperty("DFW"));
        waitForVisibility(elements.loc1And3Select, 10);
        elements.loc1And3Select.click();
    }

    @When("I select travel dates for each flight")
    public void selectTravelDates() {
        elements.flight1DateBtn.click();
        waitForVisibility(elements.datesPicker, 10);
        int availDates = getElements("(//button[@class='datepicker-cal-date'])").size();
        System.out.println("Available Dates are: " + availDates);
        elements.flight1Date.click();
        waitFor(1);
        elements.flight2DateBtn.click();
        elements.flight2Date.click();
        waitFor(1);
        elements.flight3DateBtn.click();
        elements.flight3Date.click();
    }

    @When("I search with the selected criteria")
    public void searchWithSelectedCriteria() {
        waitFor(1);
        elements.searchBtn.click();
    }

    @Then("I verify results select flights and validate itinerary")
    public void validateResultsAndItinerary() {
        waitForVisibility(elements.flightsResult, 10);
        int numOfFlights = getElements("(//div[@class='grid-container standard-padding '])").size();
        System.out.println("Number of Results from the Search Criteria: " + numOfFlights);
        try {
            elements.nonstopFlightSelect.click();
        } catch(Exception e) {
            elements.onestopFlightSelect.click();
        }
        System.out.println("Selecting the Lowest Price Flight with Least Stops");
        waitFor(2);
        elements.lowestPriceFlight.click();
        waitForVisibility(elements.selectFareBtn, 10);
        elements.lowestPriceFlight.click();
        System.out.println("Waiting on Selecting Second Flight");
        waitForVisibility(elements.noExtraCostFlight, 10);
        System.out.println("Selecting Flight with No Extra Cost");
        waitFor(1);
        elements.lowestPriceFlight.click();
        waitForVisibility(elements.selectFareBtn, 10);
        elements.lowestPriceFlight.click();
        System.out.println("Waiting on Selecting Third Flight");
        waitForVisibility(elements.noExtraCostFlight, 10);
        System.out.println("Selecting Flight with No Extra Cost");
        waitFor(1);
        elements.lowestPriceFlight.click();
        waitForVisibility(elements.selectFareBtn, 10);
        elements.lowestPriceFlight.click();
        waitFor(10);
        switchToWindow();
        System.out.println("Validating Confirmation of First Flight");
        String flight1Source = elements.flight1Sourceconfirmation.getText();
        String flight1Dest = elements.flight1DestConfirmation.getText();
        System.out.println("Flight 1 Source: " + flight1Source);
        System.out.println("Flight 1 Dest: " + flight1Dest);
        assertTrue(flight1Source.contains(ConfigurationReader.getProperty("Dallas")));
        assertTrue(flight1Dest.contains(ConfigurationReader.getProperty("sanFran")));
        System.out.println("Validating Confirmation of Second Flight");
        String flight2Source = elements.flight2Sourceconfirmation.getText();
        String flight2Dest = elements.flight2DestConfirmation.getText();
        System.out.println("Flight 2 Source: " + flight2Source);
        System.out.println("Flight 2 Dest: " + flight2Dest);
        assertTrue(flight2Source.contains(ConfigurationReader.getProperty("sanFran")));
        assertTrue(flight2Dest.contains(ConfigurationReader.getProperty("newYork")));
        System.out.println("Validating Confirmation of Third Flight");
        String flight3Source = elements.flight3Sourceconfirmation.getText();
        String flight3Dest = elements.flight3DestConfirmation.getText();
        System.out.println("Flight 3 Source: " + flight3Source);
        System.out.println("Flight 3 Dest: " + flight3Dest);
        assertTrue(flight3Source.contains(ConfigurationReader.getProperty("newYork")));
        assertTrue(flight3Dest.contains(ConfigurationReader.getProperty("Dallas")));
    }
}
