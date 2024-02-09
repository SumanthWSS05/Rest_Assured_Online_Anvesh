package responseValidation;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidatingBody {

	@Test
	public void getListOfUsers() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.body("page", equalTo(2))
			.body("total_pages", equalTo(2));
	}
}
