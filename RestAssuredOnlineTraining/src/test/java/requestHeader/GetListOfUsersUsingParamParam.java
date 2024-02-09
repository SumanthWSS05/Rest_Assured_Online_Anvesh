package requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetListOfUsersUsingParamParam {

	@Test
	public void getUsers() {
		
		baseURI = "https://reqres.in/";
		
		given()
			.pathParam("rp1", "api")
			.pathParam("rp2", "users")
			.param("page", 3)
			.log().all()
		.when()
			.get("{rp1}/{rp2}")
		.then()
			.log().all();
	}
}
