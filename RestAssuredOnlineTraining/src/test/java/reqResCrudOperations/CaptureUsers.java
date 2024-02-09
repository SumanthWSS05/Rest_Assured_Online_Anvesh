package reqResCrudOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CaptureUsers {

	@Test
	public void getUsersInfo() {
		
		//Pre condition
		RestAssured.given() 
		
		//http method
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		//response
		.then()
			.log().all();
	}
}
