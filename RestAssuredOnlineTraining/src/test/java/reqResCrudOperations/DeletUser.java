package reqResCrudOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeletUser {

	@Test
	public void deleteAUser() {
		
		RestAssured.given()
		
		
		.when()
			.delete("https://reqres.in/api/users/2")
		
		.then()
			.log().all();
	}
}
