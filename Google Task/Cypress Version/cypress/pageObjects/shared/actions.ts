class SharedAction {
    visitPreferences() {
        cy.visit('preferences?hl=en')
        return this;
    }

    clickOnOtherSettings() {
        cy.contains('div','Other settings').click();
        return this;
    }

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
    
}

export default SharedAction;
