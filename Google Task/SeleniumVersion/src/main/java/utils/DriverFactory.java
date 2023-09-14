package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("–disk-cache-dir=/path/to/empty/dir");
        options.addArguments("–disk-cache-size=0");
        return new ChromeDriver(options);
    }
}
