package requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetRepos {

	@Test
	public void getListOfRespos() {
		given()
			.pathParam("owner", "SumanthELF")
			.pathParam("repo", "ShoppersStackMobile")
			.header("Authorization","Bearer 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")
		.when()
			.get("https://api.github.com/repos/{owner}/{repo}")
		.then()
			.log().all();
	}
}
