package requestBody;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class RequestBodyThroughExternalJSON {

	@Test
	public void createUser() {
		
		File jsonBodyFile = new File("./src/test/resources/createUser.json");
		
		given()
			.contentType(ContentType.JSON)
			.body(jsonBodyFile)
		.when()
			.post("https://petstore.swagger.io/v2/user")
		.then()
			.log().all();
	}
}
