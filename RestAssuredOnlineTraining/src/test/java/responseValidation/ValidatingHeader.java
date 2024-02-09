package responseValidation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidatingHeader {

	@Test
	public void getListOfUsers() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.header("Connection", "keep-alive")
			.header("X-Powered-By", "express")
			.header("Server", "cloudflare");
	}
}
