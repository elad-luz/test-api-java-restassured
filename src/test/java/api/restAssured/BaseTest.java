package api.restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    protected void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = new RequestSpecBuilder()
        		.addHeader("Content-Type", "application/json")
                .build();
    }
}