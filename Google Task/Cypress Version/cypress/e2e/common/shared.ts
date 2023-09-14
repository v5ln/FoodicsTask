import { When } from "@badeball/cypress-cucumber-preprocessor";
import GoogleSearchPageAction from "../../pageObjects/googleSearch/actions";

const googleSearchPageAction = new GoogleSearchPageAction();

When("[COMMON]: User in Google first page", ()=>{
    cy.visit('search?hl=en');
})

When("[COMMON]: User is on the Google result page for {string}", (keyword: string) => {
    googleSearchPageAction.searchForKeyword(keyword);
  });
