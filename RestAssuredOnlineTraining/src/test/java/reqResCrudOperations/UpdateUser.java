package reqResCrudOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateUser {

	@Test
	public void updateAnExistingUser() {
		
		RestAssured.given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}")
		.when()
			.put("https://reqres.in/api/users/2")
		
		.then()
			.log().all();
	}
}
