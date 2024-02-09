package responseValidation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class CaptureAValueFromResponse {

	@Test
	public void getUser() {
		
		String userName = given()
		
		.when()
			.get("https://reqres.in/api/users/4")
		
		.then()
			.extract().jsonPath().getString("data.last_name");
		
		System.out.println(userName);
			
	}
}
