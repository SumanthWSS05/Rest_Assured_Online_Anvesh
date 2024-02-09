package requestBody;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUser {

	@Test
	public void createAUser() {
		RestAssured.given()
			.contentType(ContentType.JSON)
			.body(PayLoad.createUser())
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.log().all();
	}
}
