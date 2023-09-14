package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObject.GoogleObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.DriverFactory;

import java.util.Objects;

public class GoogleSearch {
    WebDriver driver = DriverFactory.createDriver();
    GoogleObjects googleObjects = new GoogleObjects(driver);

    Long NumberOfResults;
    Long NumberOfResults2;

    @Before
    public void beforeScenario(){
        googleObjects.visit();
        googleObjects.setLanguageToEnglish();
        googleObjects.turnOfTheScrolling();
        googleObjects.visit();
    }

    @When("User searches for a keyword {string}")
    public void userSearchesForAKeyword(String keyword) {
        googleObjects.enterSearchKeyword(keyword);
    }

    @Then("Google result page should be opened for {string}")
    public void googleResultPageShouldBeOpenedFor(String keyword) {
        googleObjects.checkResultsContainerIsContainValue(keyword, true);
    }

    @Then("Result number count should be exist")
    public void resultNumberCountShouldBeExist() {
        googleObjects.checkResultsCountIsDisplayed(true);
    }

    @Then("Suggestions should be displayed at the bottom of the page")
    public void suggestionsShouldBeDisplayedAtTheBottomOfThePage() {
        googleObjects.checkSuggestionsIsDisplayed(true);
    }

    @Given("User is on the Google result page for {string}")
    public void userIsOnTheGoogleResultPageFor(String keyword) {
        googleObjects.enterSearchKeyword(keyword);
    }

    @When("User scrolls down to the bottom of the page")
    public void userScrollsDownToTheBottomOfThePage() {
        googleObjects.scrollToBottomOfPage();
    }

    @When("User clicks the More Result button")
    public void userClicksMoreResultButton() {
        googleObjects.clickMoreResultButton();
    }

    @When("User note the number of results for {string}")
    public void userNoteResultNumber(String keyword) {
        if(Objects.equals(keyword, "cypress")){
            NumberOfResults = googleObjects.getNumberOfResults();
            System.out.println(NumberOfResults);
        }
        else{
            NumberOfResults2 = googleObjects.getNumberOfResults();
            System.out.println(NumberOfResults2);

        }
    }

    @Then("The number of results should be {string} the number of results for first number")
    public void compareResultNumbers(String isEqual) {
        googleObjects.compareResultNumbers(NumberOfResults,NumberOfResults2, Objects.equals(isEqual, "equals"));
    }

    @Then("More Result button should be exist")
    public void moreResultButtonShouldBeExist() {
        googleObjects.checkMoreResultButtonIsDisplayed(true);
    }

    @Then("Suggestions should not be duplicated")
    public void suggestionsShouldNotBeDuplicated() {
        googleObjects.checkSuggestionsIsNotDuplicated();
    }

    @After
    public void afterScenario(){
        driver.quit();
    }
}
