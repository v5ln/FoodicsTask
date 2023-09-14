package apiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WhoAmITest extends BaseTest {

    @Test
    public void testWhoAmI() {
        var loginResponse = foodicsAPI.login(EMAIL, PASSWORD, API_TOKEN);
        String token = loginResponse.jsonPath().getString("token");

        var whoAmIResponse = foodicsAPI.whoAmI(token);

        Assert.assertEquals(whoAmIResponse.getStatusCode(), 200, "WhoAmI failed!");
        Assert.assertTrue(whoAmIResponse.getContentType().contains("application/json"), "WhoAmI response isn't JSON.");
    }

    @Test
    public void testWhoAmIWithoutToken() {
        var response = foodicsAPI.whoAmI("");
        Assert.assertFalse(response.getContentType().contains("application/json"), "WhoAmI response is unexpectedly JSON for missing token.");
    }

    @Test
    public void testWhoAmIWithInvalidToken() {
        var response = foodicsAPI.whoAmI("invalidtoken");
        Assert.assertFalse(response.getContentType().contains("application/json"), "WhoAmI response is unexpectedly JSON for invalid token.");
    }
}
