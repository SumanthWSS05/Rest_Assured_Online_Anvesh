package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Category;
import pojo.CreatePet;
import pojo.Tags;

public class PetStore {

	long petId;
	CreatePet pet ;
	
	@Test
	public void createPet() {
		Category category = new Category(0, "Dog");
		
		ArrayList<String> photoUrls = new ArrayList<String>();
		photoUrls.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.goodhousekeeping.com%2Flife%2Fpets%2Fg4531%2Fcutest-dog-breeds%2F&psig=AOvVaw1MJLCyU8FoYVqEYiOuiv70&ust=1707462672148000&source=images&cd=vfe&opi=89978449&ved=0CBMQjRxqFwoTCJDLmqKYm4QDFQAAAAAdAAAAABAE");
		
		Tags tag1 = new Tags(0, "Race");
		ArrayList<Tags> tags = new ArrayList<Tags>();
		tags.add(tag1);
		
		pet = new CreatePet(0, category, "Piku", photoUrls, tags, "available");
		
		Response responseBody = given()
			.contentType(ContentType.JSON)
			.body(pet)
		.when()
			.post("https://petstore.swagger.io/v2/pet");
		
		responseBody.then().log().all();
		System.out.println(responseBody.jsonPath().get());
		petId = responseBody.jsonPath().getLong("id");
		System.err.println("Pet id : " +petId);
		System.out.println();
		System.err.println("=================================================================");
		System.out.println();
	}
	
	@Test
	public void updatePet() {
		pet.setId(petId);
		pet.setStatus("not available");
		pet.setName("Brownie");
		
		given()
			.contentType(ContentType.JSON)
			.body(pet)
		.when()
			.put("https://petstore.swagger.io/v2/pet")
		.then()
			.log().all();
		
		System.out.println();
		System.err.println("=================================================================");
		System.out.println();
		
	}
		
	
//	@Test
//	public void getPet() {
//		
//	}
//	
//	@Test
//	public void deletePet() {
//		
//		
//	}
		
}
