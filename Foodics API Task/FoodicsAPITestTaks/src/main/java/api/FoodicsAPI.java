package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class FoodicsAPI {

    private static final String BASE_URL = "https://pay2.foodics.dev/cp_internal";

    public Response login(String email, String password, String API_TOKEN) {
        RequestSpecification request = RestAssured.given();
        request.body("{\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"token\": \"" + API_TOKEN + "\"\n" +
                "}");
        request.contentType("application/json");

        return request.post(BASE_URL + "/login");
    }

    public Response whoAmI(String token) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + token);

        return request.get(BASE_URL + "/whoami");
    }
}
