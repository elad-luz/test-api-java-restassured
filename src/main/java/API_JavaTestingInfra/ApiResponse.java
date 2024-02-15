package API_JavaTestingInfra;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class ApiResponse {  // Hold the status-code and response-body of the api requests
	private int statusCode;
	private String responseBody;

	public ApiResponse(int statusCode, String responseBody) {
		this.statusCode = statusCode;
		this.responseBody = responseBody;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getResponseBody() {
		return responseBody;
	}
	
	// de-serializing the JSON response
    public <T> List<T> parseResponseAsList(Class<T> elementType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseBody, objectMapper.getTypeFactory().constructCollectionType(List.class, elementType));
    }
}
