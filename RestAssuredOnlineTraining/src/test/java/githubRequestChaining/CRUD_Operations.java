package githubRequestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import github_POJO.CreateRepo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CRUD_Operations {

	String owner ;
	String repoName ;
	
	@Test(priority = 1)
	public void createARepo() {
		CreateRepo repoDetails = new CreateRepo("RestAssured_Train", "Performing CRUD operations", true);
		
		Response responseBody = given()
			.header("Authorization","Bearer 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")
			.contentType(ContentType.JSON)
			.body(repoDetails).log().all()     //serialization
		.when()
			.post("https://api.github.com/user/repos");		
		
		repoName = responseBody.jsonPath().getString("name");
		owner = responseBody.jsonPath().getString("owner.login");
		responseBody.then().log().all();
		responseBody.then().assertThat().statusCode(201);
//		responseBody.then().assertThat().time(Matchers.lessThan(1200l), TimeUnit.MILLISECONDS);
		
		CreateRepo res = responseBody.as(CreateRepo.class);   //deserialization
		System.out.println(res.getName());
		System.out.println(res.getDescription());
	}
	
//	@Test(priority = 2)
//	public void getRepo() {
//		given()
//			.header("Authorization","Bearer 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")
//			.pathParam("owner", owner)
//			.pathParam("repo", repoName)
//		.when()
//			.get("https://api.github.com/repos/{owner}/{repo}")
//		.then()
//			.log().body()
//			.assertThat().statusCode(200)
//		/* .assertThat().time(Matchers.lessThan(800l), TimeUnit.MILLISECONDS) */;
//			
//	}
//	
//	@Test(priority = 3)
//	public void updateRepo() {
//		CreateRepo updatedBody = new CreateRepo("RestAssured_Training7", "Updating during crud operation", false);
//		
//		given()
//			.header("Authorization","Bearer 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")
//			.pathParam("owner", owner)
//			.pathParam("repo", repoName)
//			.contentType(ContentType.JSON)
//			.body(updatedBody)
//		.when()
//			.patch("https://api.github.com/repos/{owner}/{repo}")
//		.then()
//			.log().all()
//			.assertThat().statusCode(200)
//		/* .assertThat().time(Matchers.lessThan(1100l), TimeUnit.MILLISECONDS) */;		
//	}
//	
	@Test(priority = 4)
	public void deleteRepo() {
		
		given()
			.header("Authorization","Bearer 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")
			.pathParam("owner", owner)
			.pathParam("repo", repoName)
		.when()
			.delete("https://api.github.com/repos/{owner}/{repo}")
		.then()
			.log().all()
			.assertThat().statusCode(204)
		/* .assertThat().time(Matchers.lessThan(1100l), TimeUnit.MILLISECONDS) */;		
	}
	
	
}
