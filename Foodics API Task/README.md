
# Foodics API Task

The focus here is on the Foodics API Using RestAssured.

## Files:

1. **BaseTest.java**: This file lays the groundwork for the API tests. It sets up the connection and authentication details needed for testing different endpoints.
```java
public class BaseTest {
    protected final String API_TOKEN = "Your_API_Token";
    protected FoodicsAPI foodicsAPI;

    @BeforeClass
    public void setup() {
        this.foodicsAPI = new FoodicsAPI();
    }
}
```

**LoginTest.java**: Focused on logging in scenarios. It checks for valid credentials and handles cases for invalid data inputs.
```java
public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        var response = foodicsAPI.login(EMAIL, PASSWORD, API_TOKEN);
        Assert.assertEquals(response.getStatusCode(), 200, "Login failed!");
    }
}
```

**MyTestListener.java**: This class provides test listeners for TestNG to report test execution events.
```java
public class MyTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());
    }
}
```

**TestRunner.java**: This is the driver class for TestNG. It groups tests and sets listeners.
```java
public class TestRunner {
    public static void main(String[] args) {
        TestNG testSuite = new TestNG();

        Class[] classes = new Class[]{ LoginTest.class };
        testSuite.setTestClasses(classes);
        testSuite.addListener(new MyTestListener());
        testSuite.run();
    }
}
```

**WhoAmITest.java**: Examines the whoAmI endpoint functionality. It evaluates both valid and invalid token scenarios.
```java
public class WhoAmITest extends BaseTest {
    @Test
    public void testWhoAmI() {
        var response = foodicsAPI.whoAmI("valid_token");
        Assert.assertEquals(response.getStatusCode(), 200, "WhoAmI failed!");
    }
}
```

All the tests cover a variety of scenarios ensuring the robustness of the API and highlighting any potential issues.

## Setup:
- Install Java and set up environment variables.
- Install Maven for dependencies management.
- Clone the repository and navigate to the 'Foodics API Task' folder.
- Run the tests using the command: `mvn test`.

