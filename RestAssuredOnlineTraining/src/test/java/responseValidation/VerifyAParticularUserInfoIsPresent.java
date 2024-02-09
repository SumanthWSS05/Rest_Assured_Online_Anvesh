package responseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class VerifyAParticularUserInfoIsPresent {

	@Test
	public void getUsersList() {
		Response responseBody = given()
		
		.when()
			.get("https://reqres.in/api/users?page=2");
		
		int countOfUsers = responseBody.jsonPath().getInt("data.size()");
		boolean flag = false;
		for(int i=0; i<countOfUsers; i++) {
			String name = responseBody.jsonPath().getString("data["+i+"].first_name");
			if(name.equalsIgnoreCase("Lindsay")) {
				flag = true;
				break;
			}
		}
		if(flag)
			System.out.println("User is present");
		else
			System.out.println("User is not present");
	}
}
