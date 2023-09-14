package apiTests;

import org.testng.annotations.BeforeClass;
import api.FoodicsAPI;

public class BaseTest {

    protected final String API_TOKEN = "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO";
    protected final String EMAIL = "merchant@foodics.com";
    protected final String PASSWORD = "123456";
    protected FoodicsAPI foodicsAPI;

    @BeforeClass
    public void setup() {
        this.foodicsAPI = new FoodicsAPI();
    }
}
