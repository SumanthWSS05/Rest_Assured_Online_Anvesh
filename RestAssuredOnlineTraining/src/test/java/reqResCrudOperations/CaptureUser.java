package reqResCrudOperations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CaptureUser {

	@Test
	public void getUserInfo() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		
		.then()
			.log().all();
	}
}
