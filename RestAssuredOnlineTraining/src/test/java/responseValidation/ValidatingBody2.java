package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidatingBody2 {

	@Test
	public void getListOfUsers() {
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		
		.then()
			.body("data.first_name", equalTo("Jannet"));
			
	}
}
