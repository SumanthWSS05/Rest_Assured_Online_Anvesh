package requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CreateAUser {

	@Test
	public void createUsers() {
		
		given()
			.header("Content-Type","application/json")
			.pathParam("resourcePath1", "api")
			.pathParam("resourcePath2", "users")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}")
			.log().all()
		.when()
			.post("https://reqres.in/{resourcePath1}/{resourcePath2}")
		
		.then()
			.log().all();
	}
}
