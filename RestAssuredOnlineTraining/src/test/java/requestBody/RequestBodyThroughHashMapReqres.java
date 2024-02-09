package requestBody;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RequestBodyThroughHashMapReqres {

	@Test
	public void createAUser() {
		
		HashMap<String, String> userData = new HashMap();
		userData.put("name", "Virat");
		userData.put("job", "Cricketer");
		
		given()
			.contentType(ContentType.JSON)
			.body(userData)
		
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.log().all();
		
		
	}
}
