class GoogleSearchPageAssertion {
    isOnSearchResultPageFor(keyword: string) {
        cy.get('div[id="search"]').should('contain', keyword);
    }

    isResultNumberCountExist() {
        cy.get('#result-stats').should('be.visible');
    }

    assertEquals(numberOfResultsFirst: number, numberOfResultsSecond: number, isEqual: boolean) {
        if (isEqual) {
            assert.equal(numberOfResultsFirst, numberOfResultsSecond);
        } else {
            assert.notEqual(numberOfResultsFirst, numberOfResultsSecond);
        }
    }

    isMoreResultButtonExist() {
        cy.get('div').contains('span','More results').should('be.visible');
    }

    areSuggestionsDisplayedAtBottomOfPage() {
        cy.get('#bres').should('be.visible');
    }

    areSuggestionsUnique() {
        cy.get('#bres').should('have.length', 1);
    }
}

export default GoogleSearchPageAssertion;
