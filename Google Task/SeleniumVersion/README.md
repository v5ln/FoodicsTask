
# Selenium Version: Google Task


## Files:

1. **GoogleObjects.java**: A representation of the Google Search page encapsulating different elements and their interactions.
```java
public class GoogleObjects {
    @FindBy(xpath = "//div/span[contains(text(),'More results')]")
    private WebElement moreResultsButton;

    public void checkMoreResultButtonIsDisplayed(Boolean isDisplayed) {
        assert isDisplayed? moreResultsButton.isDisplayed():
                !moreResultsButton.isDisplayed();
    }
    ..
}
```

2. **GoogleSearch.java**: This is where the actual tests reside.
```java
public class GoogleSearch {
    WebDriver driver = DriverFactory.createDriver();
    GoogleObjects googleObjects = new GoogleObjects(driver);

    @Then("Google result page should be opened for {string}")
        public void googleResultPageShouldBeOpenedFor(String keyword) {
            googleObjects.checkResultsContainerIsContainValue(keyword, true);
        }
    ...
}
```

More details and nuances can be found inside the actual code files.
