package API_JavaTestingInfra;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class FetchGeneratedApiResponse {  // Send Request and parse the Returned Response as an Object

	//	Send a 'GET' Request and Return the Response parsed as an ApiResponse object -> to extract the title & response-code from…
	public ApiResponse returnApiResponseOfGetRequest(String apiUrl) {
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(apiUrl);
			request.setHeader("Accept", "application/json");
			request.setHeader("X-HTTP-Method-Override", "GET");

			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				String responseBody = EntityUtils.toString(entity);
				int statusCode = response.getStatusLine().getStatusCode();
				return new ApiResponse(statusCode, responseBody);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//	Another way to Send 'GET' Request, BUT to Return the Response parsed directly as a String, to work & assert on & print it…
	public String returnApiResponseStringOfGetRequest(String apiUrl) { // Because its less powerful then the previous - Ignore it!
		try {
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(apiUrl);
			request.setHeader("Accept", "application/json");
			request.setHeader("X-HTTP-Method-Override", "GET"); // Use a custom header to simulate GET

			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				return EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
