package requestHeader;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Coops {

//	@Test
//	public void getInfo() {
//		
//		given()				
//			.auth().oauth2("8a19bb0957329d62402d174f5220827635ecf371")
//			.pathParam("userID", 4823)
//		.when()
//			.post("	http://coop.apps.symfonycasts.com/api/{userID}/eggs-collect")
//		.then()
//			.log().all();
//	}
	
	
	@Test
	public void getInfo() {
		
		Response res = given()
			.formParam("client_id", "GenerateToken")
			.formParam("client_secret", "c533c87079ad8a8fb8f469e373a3e45c")
			.formParam("grant_type", "client_credentials")
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		
		res.then().log().all();
//		System.out.println("``````````````````````````````````````");
//		String auth = res.getHeader("Set-Cookie");
//		String[] keyValuePAirs = auth.split(";");
//		String[] keyValues = keyValuePAirs[0].split("=");
//		String outh2 = keyValues[1];
//		System.out.println("==========================");
//		System.out.println(outh2);
//		System.out.println("==========================");
//		given()
//			.auth().oauth2(outh2)
//			.pathParam("userID", 4823)
//		.when()
//			.post("http://coop.apps.symfonycasts.com/api/{userID}/eggs-collect")
//		.then()
//			.log().all();
		
	}

	
}
