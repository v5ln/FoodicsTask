
# Cypress Version: Google Task

Cypress, due to its straightforward syntax and structure, is the primary tool for this testing version. The Page Object Model is employed to ensure a clean separation between test scenarios and page elements.

## Files:

1. **asserts.ts**: This file encompasses assertions specifically related to Google Search.
```typescript
class GoogleSearchPageAssertion {
    isResultNumberCountExist() {
        cy.get('#result-stats').should('be.visible');
    }
    ...
}
```

2. **shared/actions.ts**: A module with general actions that might be applied across different tests.
```typescript
turnOffScrollingCheckBox() {
        cy.get("div[role='checkbox']").contains('Continuous scroll')
            .parent()
            .invoke('attr', 'aria-checked').then(isChecked => {
                if (isChecked === "true") {
                    cy.get("div[role='checkbox']").contains('Continuous scroll').click();
                }
            });
        return this;
    }
```

4. **googleSearch.features**: This directory houses the actual test scenarios.
```features
Feature: Google Search

    Background: 
    Given [COMMON]: User in Google first page

  Scenario: TC-1 - Search for a keyword and validate results
    When User searches for a keyword "cypress"
    Then Google result page should be opened for "cypress"
    And Result number count should be exist

  Scenario: TC-2 - Remove the keyword and search for a new one
    Given [COMMON]: User is on the Google result page for "cypress"
    When User note the number of results for "cypress"
    And User searches for a keyword "selenium"
    Then Google result page should be opened for "selenium"
    And The number of results should be "different than" the number of results for first number

  Scenario: TC-4 - Validate that More Result button is exist
    Given [COMMON]: User is on the Google result page for "selenium"
    When User scrolls down to the bottom of the page
    Then More Result button should be exist
    ...
```
