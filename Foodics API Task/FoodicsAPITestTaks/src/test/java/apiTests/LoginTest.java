package apiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        var response = foodicsAPI.login(EMAIL, PASSWORD, API_TOKEN);
        Assert.assertEquals(response.getStatusCode(), 200, "Login failed!");
    }

    @Test
    public void testInvalidEmailLogin() {
        var response = foodicsAPI.login("invalid@foodics.com", PASSWORD, API_TOKEN);
        Assert.assertNotEquals(response.getStatusCode(), 200, "API returned 200 OK for an invalid email.");
    }

    @Test
    public void testInvalidPasswordLogin() {
        var response = foodicsAPI.login(EMAIL, "wrongpassword", API_TOKEN);
        Assert.assertNotEquals(response.getStatusCode(), 200, "API returned 200 OK for an invalid password.");
    }

    @Test
    public void testLoginResponseTime() {
        var response = foodicsAPI.login(EMAIL, PASSWORD, API_TOKEN);
        Assert.assertTrue(response.getTime() < 1000, "API took more than 1 second to respond for login.");
    }

    @Test
    public void testLoginContentType() {
        var response = foodicsAPI.login(EMAIL, PASSWORD, API_TOKEN);
        Assert.assertTrue(response.getContentType().contains("application/json"), "Content type for login is not application/json.");
    }
}
