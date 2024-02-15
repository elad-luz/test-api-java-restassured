package API_JavaTestingInfra;

import org.testng.Assert;

public class ApiClientTest {  // TEST itself...
/** TASK:  I enhanced this task, and created 2 test-cases:  1st will PASS Assert  -&-  2ed will FAIL it
	Automated API test, that sends a GET request to url -> https://jsonplaceholder.typicode.com/todos/1
	Then verifies, the status code is 200 and the title is “delectus aut autem” !!!
 */

	// APIs' BaseUrl Legs (slash-divided…) = https://jsonplaceholder.typicode.com/todos/1
	static String API_BaseURL = "https://jsonplaceholder.typicode.com";
	static String URL_API1stLeg = "todos";
	static String URL_API2edLeg = "1"; // TODO: instead of hard-coded, it can be interesting to implement dynamic id choice: 1, 2, 3, 4, 5…
	// Combined APIs' Url for Requests…
	static String apiUrl = API_BaseURL +"/"+ URL_API1stLeg +"/"+ URL_API2edLeg;
	
	//	Running the Test Cases:
	public static void main(String[] args) { // TODO -> comment-out the Debugging Print-outs on Real-Runs (not a Demo-Mode) !!!

		/** CASE #1 - issue a 'GET' request, for retrieving the record data for id #1  -&-  assert on the replied response code + title… */
		System.out.println("Start Case #1  -> To Succeed:");
		FetchGeneratedApiResponse fetchGeneratedApiResponse = new FetchGeneratedApiResponse();
		ApiResponse getRresponse = fetchGeneratedApiResponse.returnApiResponseOfGetRequest(apiUrl);
		String getResponseBody = getRresponse.getResponseBody();
		System.out.println("Get-Response Body: " + getResponseBody); // Only print when debugging…
		Assert.assertTrue(getResponseBody.toLowerCase().contains("\"title\": \"delectus aut autem\""), "title: \"delectus aut autem\" DON'T exist!");
		int statusCodeOfGet = getRresponse.getStatusCode();
		System.out.println("Get-Response Code: " + statusCodeOfGet); // Only print when debugging…
		Assert.assertEquals(statusCodeOfGet, 200, "Request returned-status-code is Not as Expected (200)"); // Note: 200 = HttpStatus.SC_OK
		System.out.println("★ End of Case #1  -> Properly Passed Title & Status Assertions!\n"); // Only print when debugging… TODO -> comment-out !!

		System.out.println("===============================================================\n");

		/** CASE #2 - issue a 'GET' request, for retrieving the record data for id #1 (as above)  -BUT NOW-  Fail the assert on the response code… */
		System.out.println("Start Case #2  -> To Deliberatly Fail on Exception:  Request returned-status-code is Not as Expected:");
		ApiResponse getRresponseFailure = fetchGeneratedApiResponse.returnApiResponseOfGetRequest(apiUrl);
		String getResponseBodyX = getRresponseFailure.getResponseBody();
		System.out.println("Get-Response Body: " + getResponseBody); // Only print when debugging…
		Assert.assertTrue(getResponseBodyX.toLowerCase().contains("\"title\": \"delectus aut autem\""), "title: \"delectus aut autem\" DON'T exist");
		int statusCodeOfGetX = getRresponseFailure.getStatusCode();
		System.out.println("Get-Response Code: " + statusCodeOfGet); // Only print when debugging…
		System.out.println("About to Deliberately FAIL Test-Case, on Missmatch : Request returned-status-code is Not as Expected (...) INTESIONAL!");
		Assert.assertEquals(statusCodeOfGetX, 100, "Request returned-status-code is Not as Expected (100)"); // Will Fail on StatusCode mismatch: 100
		System.out.println("★ End of Case #2 \n");
	
	}
}
/* NOTE this is a simpler way, BUT-ONLY for just making sure the Title is OK (so it could be IGNORED for now)…:
	//	Needs: import org.apache.http.HttpStatus;
	//	System.out.println("Test url -> " + apiUrl); // this print (& following) is for debugging… -> api url taken from above!
	//	Init the Responses-Fetcher Object:
	FetchGeneratedApiResponse fetchGeneratedApiResponse = new FetchGeneratedApiResponse();
	//	System.out.println("|----► #1. about to issue 'GET' request, for retrieving first response-record…"); //	Only print when debugging…
	//	Send GET request and Assert (& Print) the Returned JSON Response to match expected !!!
	String jsonToStringGetApiResponse1 = fetchGeneratedApiResponse.returnApiResponseStringOfGetRequest(apiUrl); // reply as String to Print response & Assert
	//	System.out.println("GET Response #1:\n" + jsonToStringGetApiResponse1); //	Only print when debugging…
	//	Assert on Response-Record -> expected response json: {"userId": 1,"id": 1,"title": "delectus aut autem","completed": false}
	Assert.assertTrue(jsonToStringGetApiResponse1.toLowerCase().contains("\"title\": \"delectus aut autem\""), "title: \"delectus aut autem\" DON'T exist!");
*/