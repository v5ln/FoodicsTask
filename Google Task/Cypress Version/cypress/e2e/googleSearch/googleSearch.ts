import { When, Then } from "@badeball/cypress-cucumber-preprocessor";
import GoogleSearchPageAction from "../../pageObjects/googleSearch/actions";
import GoogleSearchPageAssertion from "../../pageObjects/googleSearch/asserts";
import SharedAction from "../../pageObjects/shared/actions";

const googleSearchPageAction = new GoogleSearchPageAction();
const googleSearchPageAssertion = new GoogleSearchPageAssertion();
const sharedAction = new SharedAction();

let numberOfResultsFirst
let numberOfResultsSecond

beforeEach(()=>{
  sharedAction
    .visitPreferences()
    .clickOnOtherSettings()
    .turnOffScrollingCheckBox()
});

When("User searches for a keyword {string}", (keyword: string) => {
  googleSearchPageAction.searchForKeyword(keyword);
});

When("User note the number of results for {string}", (keyword: string) => {
  keyword == 'cypress'?
  numberOfResultsFirst = googleSearchPageAction.getNumberOfResults()
  .then(numberOfResults => {
    numberOfResultsFirst= numberOfResults}):
  numberOfResultsSecond = googleSearchPageAction.getNumberOfResults()
    .then(numberOfResults => {
      numberOfResultsSecond= numberOfResults})
});

When("User scrolls down to the bottom of the page", () => {
  googleSearchPageAction.scrollToBottomOfPage();
});

When("User clicks the More Result button", () => {
  googleSearchPageAction.clickMoreResultButton();
});

Then("Google result page should be opened for {string}", (keyword: string) => {
  googleSearchPageAssertion.isOnSearchResultPageFor(keyword);
});

Then("Result number count should be exist", () => {
  googleSearchPageAssertion.isResultNumberCountExist();
});

Then("The number of results should be {string} the number of results for first number", (isEqual: string) => {
  googleSearchPageAssertion
  .assertEquals(numberOfResultsFirst, numberOfResultsSecond, isEqual == "equals");
});

Then("More Result button should be exist", () => {
  googleSearchPageAssertion.isMoreResultButtonExist();
});

Then("Suggestions should be displayed at the bottom of the page", () => {
  googleSearchPageAssertion.areSuggestionsDisplayedAtBottomOfPage();
});

Then("Suggestions should not be duplicated", () => {
  googleSearchPageAssertion.areSuggestionsUnique();
});
