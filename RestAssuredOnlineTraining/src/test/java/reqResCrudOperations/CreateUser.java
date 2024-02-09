package reqResCrudOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser {

	@Test
	public void createAUser() {

		pojo.CreateUser user1 = new pojo.CreateUser();
		user1.setName("Kamal");
		user1.setJob("SDET");
	
		Response res = RestAssured.given()
			.contentType(ContentType.JSON)
			.body(user1)
		.when()
			.post("https://reqres.in/api/users");
			
		res.then().log().all();
		
		System.out.println("=============================================");
		pojo.CreateUser resObj = res.as(pojo.CreateUser.class);
		System.out.println(resObj.getId());
		System.out.println(resObj.getCreatedAt());
		System.out.println(resObj.getName());
		System.out.println(resObj.getJob());
	}
}
