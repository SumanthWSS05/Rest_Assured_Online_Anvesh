package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidatingBody3 {

	@Test
	public void getListOfUsers() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.body("page", equalTo(2))
			.body("total_pages", equalTo(2))
			.body("data[1].first_name", equalTo("Lindsayy"));
	}
}
