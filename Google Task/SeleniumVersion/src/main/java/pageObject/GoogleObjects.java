package pageObject;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleObjects {

    private final WebDriver driver;

    // WebElements
    @FindBy(name = "q")
    private WebElement searchInput;

    @FindBy(id = "result-stats")
    private WebElement resultsCount;

    @FindBy(id = "search")
    private WebElement resultsContainer;

    @FindBy(id = "bres")
    private WebElement suggestions;

    @FindBy(id = "bres")
    private List<WebElement> allSuggestionsElements;

    @FindBy(xpath = "//div/span[contains(text(),'More results')]")
    private WebElement moreResultsButton;

    public GoogleObjects(WebDriver driver) {
        this.driver = driver;
        driver.manage().deleteAllCookies();
        PageFactory.initElements(driver, this);
    }

    public void visit() {
        driver.get("https://www.google.com/?hl=en");
    }

    public void enterSearchKeyword(String keyword) {
        searchInput.clear();
        searchInput.sendKeys(keyword);
        searchInput.sendKeys(Keys.ENTER);
    }

    public void checkResultsContainerIsContainValue(String value, Boolean isContain) {
        assert isContain? resultsContainer.getText().contains(value):
                !resultsContainer.getText().contains(value);
    }

    public void checkResultsCountIsDisplayed(Boolean isDisplayed) {
        assert isDisplayed? resultsCount.isDisplayed():
                !resultsCount.isDisplayed();
    }

    public void checkSuggestionsIsDisplayed(Boolean isDisplayed) {
        assert isDisplayed? suggestions.isDisplayed():
                !suggestions.isDisplayed();
    }

    public void clickMoreResultButton() {
        moreResultsButton.click();
    }

    public void scrollToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public Long getNumberOfResults() {
        return Long.parseLong(
                resultsCount.getText().split(" results")[0]
                        .replaceAll("[^\\d]", ""));
    }

    public void compareResultNumbers(Long numberOfResults1, Long numberOfResults2, Boolean isEqual) {
        assert isEqual? numberOfResults1.equals(numberOfResults2):
                !numberOfResults1.equals(numberOfResults2);
    }

    public void turnOfTheScrolling(){
        driver.get("https://www.google.com/preferences?hl=en");
        driver.findElement(By.xpath("//div[contains(text(),'Other settings')]")).click();
        WebElement ContinuousScrollCheckBox = driver.findElement(By.xpath("//div[@role='checkbox'][.//span[contains(text(),'Continuous scroll')]]"));
        String isChecked = ContinuousScrollCheckBox.getAttribute("aria-checked");
        if ("true".equals(isChecked)) {
            ContinuousScrollCheckBox.click();
        }
    }

    public void checkMoreResultButtonIsDisplayed(Boolean isDisplayed) {
        assert isDisplayed? moreResultsButton.isDisplayed():
                !moreResultsButton.isDisplayed();
    }

    public void checkSuggestionsIsNotDuplicated() {
        Assert.assertEquals(allSuggestionsElements.size(), 1);
    }
}
