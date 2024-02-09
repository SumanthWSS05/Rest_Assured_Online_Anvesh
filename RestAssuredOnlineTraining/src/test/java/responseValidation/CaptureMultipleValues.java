package responseValidation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CaptureMultipleValues {

	@Test
	public void getUser() {
		
		Response responseBody = given()
		
		.when()
			.get("https://reqres.in/api/users/4");
		
		responseBody.then().log().all();
		responseBody.then().header("", "");
		responseBody.then().assertThat().contentType("").statusCode(200);
	
		JsonPath js = new JsonPath(responseBody.asString());
		
		System.out.println(js.getString("data.first_name"));
		System.out.println(js.getString("data.avatar"));
		
		Assert.assertEquals("js.getString(\"data.avatar\")", "https://reqres.in/img/faces/4-image.jpg");
			
	}
}
