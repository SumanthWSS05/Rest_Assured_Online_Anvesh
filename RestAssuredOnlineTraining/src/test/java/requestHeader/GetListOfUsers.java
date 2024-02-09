package requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetListOfUsers {

	@Test
	public void getUsers() {
		
		baseURI = "https://reqres.in/";
		
		given()
			.pathParam("rp1", "api")
			.pathParam("rp2", "users")
			.queryParam("page", 1)
			.log().all()
		.when()
			.get("{rp1}/{rp2}")
		.then()
			.log().all();
	}
}
