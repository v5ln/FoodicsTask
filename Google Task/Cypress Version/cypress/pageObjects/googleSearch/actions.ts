class GoogleSearchPageAction {
    searchForKeyword(keyword: string) {
        cy.get('textarea[name="q"]')
        .type(keyword + "{enter}")
        return this;
    }

    getNumberOfResults(): Cypress.Chainable<number> {
        return cy.get('#result-stats').invoke('text').then((text) => {
          const match = text.match(/\d+/);
          if (match) return parseFloat(match[0]);
          return 0;
        });
    }
    
    clickMoreResultButton() {
        cy.get('div').contains('span','More results').click();
        return this;
    }

    scrollToBottomOfPage() {
        cy.window().then(($window) => {
            $window.scrollTo(0, $window.document.body.scrollHeight);
        });
        return this
    }
}

export default GoogleSearchPageAction;
