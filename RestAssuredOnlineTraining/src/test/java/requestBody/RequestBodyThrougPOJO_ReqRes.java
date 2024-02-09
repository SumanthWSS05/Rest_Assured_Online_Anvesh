package requestBody;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RequestBodyThrougPOJO_ReqRes {

	@Test
	public void createUser() {
		
		ReqRes_CreateUser_POJO body = new ReqRes_CreateUser_POJO("Sumanth", "Trainer");
		
		given()
			.contentType(ContentType.JSON)
			.body(body)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.log().all();
	}
}
