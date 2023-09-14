Feature: Google Search

  Scenario: TC-1 - Search for a keyword and validate results
    When User searches for a keyword "cypress"
    Then Google result page should be opened for "cypress"
    And Result number count should be exist

  Scenario: TC-2 - Remove the keyword and search for a new one
    Given User is on the Google result page for "cypress"
    When User note the number of results for "cypress"
    And User searches for a keyword "selenium"
    Then Google result page should be opened for "selenium"
    And The number of results should be "different than" the number of results for first number

  Scenario: TC-3 - Assert that number of results exist on UI
    Given User is on the Google result page for "selenium"
    Then Result number count should be exist

  Scenario: TC-4 - Validate that More Result button is exist
    Given User is on the Google result page for "selenium"
    When User scrolls down to the bottom of the page
    Then More Result button should be exist

  Scenario: TC-5 - Validate that the number of results does not change after clicking More Result
    Given User is on the Google result page for "cypress"
    When User note the number of results for "cypress"
    And User scrolls down to the bottom of the page
    And User clicks the More Result button
    And User note the number of results for "cypress (after clicking More Result)"
    Then The number of results should be "equals" the number of results for first number

  Scenario: TC-6 - Validate the search suggestions at the bottom of the first page
    Given User is on the Google result page for "selenium"
    When User scrolls down to the bottom of the page
    Then Suggestions should be displayed at the bottom of the page

  Scenario: TC-7 - Validate the search suggestions at the bottom of the first page
    Given User is on the Google result page for "selenium"
    When User scrolls down to the bottom of the page
    And User clicks the More Result button
    Then Suggestions should not be duplicated