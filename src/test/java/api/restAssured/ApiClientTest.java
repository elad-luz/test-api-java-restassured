package api.restAssured;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiClientTest extends BaseTest {
	/** TASK:  I enhanced it to create 3 cases: 1. disabled, 2. enabled & will Pass, 3. enabled & will Fail
		Automated API test, that sends a GET request to url -> https://jsonplaceholder.typicode.com/todos/1
		Then verifies, the status code is 200 and the title is “delectus aut autem” !!!
	 */

	// A 'given, when, then' FORMAT. Example ONLY = Disabled !
	@Test(description = "Case #1. Proper GET code & title -> DISABLED", enabled = false)
	public void StatusCode200TitleUsesWT() { // in the first type, I make use of a simple when-then syntax:
		{
			given().log().all() // will log everything (not only upon ValidationFailure)
					.when().get("todos/1")
					.then().statusCode(HttpStatus.SC_OK) // (200) = expected status code
					// .statusCode(401) // log: Expected status code <401> but was <200>
					// .body("title", equalTo("delectus aut autem")); // proper title !!
					.body("title", equalTo("delectus aut autem XX")); // log: JSON path title doesn't match
		}
	}

	// Enabled - RUN to Passes !
	@Test(description = "Case #2. Proper GET request -> returns: 200 & title as Expected", enabled = true)
	public void StatusCode200TitleAssert() { // in this Type that RUN, I using an if and asserting syntax:
		{
			RequestSpecification httpRequest = RestAssured.given().log().ifValidationFails();
			Response response = httpRequest.get("todos/1");
			String Title = response.path("title");
			if (response.getStatusCode() == 200) { // print both: Code & Title, if Status is as Expected!
				System.out.println("OK Response = code: "+ response.getStatusCode() +", title: "+ Title);
			} // regardless above - make an assertion as well:
			Assert.assertEquals(response.getStatusCode(), 200, "Got worng Response code: ");
			Assert.assertEquals(Title, "delectus aut autem", "Got worng Response title: ");
		}
	}

	// Enabled - RUN to Fail !
	@Test(description = "Case #3. Deliberate Fail-Test, on Code (log only upon failure)", enabled = true)
	public void StatusCodeDeliberatedFailure() { // in this Test, I will deliberately fail assert on Code
		{
			RequestSpecification httpRequest = RestAssured.given().log().ifValidationFails(); // set log!
			Response response = httpRequest.get("todos/1");
			String Title = response.path("title");
			if (response.getStatusCode() == 200) { // print both: Code & Title, if Status is as Expected!
				System.out.println("OK Response = code: "+ response.getStatusCode() +", title: "+ Title);
			} // regardless above - make an assertion as well:
			Assert.assertEquals(response.getStatusCode(), 1, "Got worng Response code: "); // Expected: 1
			// Deliberated Failure -> Got worng Response code: expected [1] but found [200]
			Assert.assertEquals(Title, "delectus aut autem", "Got worng Response title: ");
		}
	}
}