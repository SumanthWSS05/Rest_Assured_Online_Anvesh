package requestBody;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojo.Category;
import pojo.CreatePet;
import pojo.Tags;

public class RequestBodyThroughPOJO_PetStore {

	@Test
	public void createUser() {
		Category categoryData = new Category(201, "Dog");
		
		ArrayList<String> photoUrls = new ArrayList<String>();
		photoUrls.add("https://www.zomato.com");
		photoUrls.add("https://www.swiggy.com");
		
		Tags tag1 = new Tags(111, "SDAF");
		Tags tag2 = new Tags(222, "KSAJ");
		ArrayList<Tags> tagsData = new ArrayList<Tags>();
		tagsData.add(tag1);
		tagsData.add(tag2);
		
		CreatePet body = new CreatePet(0, categoryData, "Ginger", photoUrls, tagsData, "not available");
		
		given()
			.contentType(ContentType.JSON)
			.body(body)
		.when()
			.post("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all();
		
	}
}
