package requestBody;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class RequestBodyThroughHashMapPetStore {

	@Test
	public void createAPet() {
		
		HashMap data = new HashMap();
		
		HashMap<String, String> category = new HashMap();
		category.put("name", "Elephant");
		
		data.put("category", category);
		data.put("name", "Blacky");
		
		given()
			.contentType(ContentType.JSON)
			.body(data).log().all()
		
		.when()
			.post("https://petstore.swagger.io/v2/pet")
		
		.then()
			.log().all();
	}
}
