package API_JavaTestingInfra;

public class ResponseRecord {  // Create the Response-Record class to represent the structure of the JSON object (for further use)…
	private int userId;
	private int id;
	private String title;
	private String completed;

	public int getUserId() {
		return userId;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCompleted() {
		return completed;
	}
}
