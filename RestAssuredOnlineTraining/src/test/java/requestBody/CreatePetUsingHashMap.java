package requestBody;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePetUsingHashMap {

	@Test
	public void createPet() {
		
		HashMap<String , Object> categoryData = new HashMap<String, Object>();
		categoryData.put("id", 101);
		categoryData.put("name", "cat");
		
		String [] photoUrlData = {"https://www.google.com"};
		
		HashMap<String, Object> tagsData = new HashMap<String, Object>();
		tagsData.put("id", 1);
		tagsData.put("name", "Omni");
				
		Object[] tags = {tagsData};
		
		HashMap<String, Object> body = new HashMap<String, Object>();
		body.put("category", categoryData);
		body.put("name", "King");
		body.put("photoUrls", photoUrlData);
		body.put("tags", tags);
		body.put("status", "available");
		
		given()
			.contentType(ContentType.JSON)
			.body(body)
		.when()
			.post("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all();
		
		
	}
}
