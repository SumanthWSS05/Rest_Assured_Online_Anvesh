package requestHeader;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

public class UploadImage {

	@Test
	public void addImageToPet() {
		
		File image1 = new File("C:\\Users\\user\\Pictures\\DummyImage.png");
		File image2 = new File("C:\\Users\\user\\Pictures\\DummyImage.png");
		
		given()
			.pathParam("petId", "9223372036854312000")
			.multiPart(image1)
			.multiPart(image2)
		.when()
			.post("https://petstore.swagger.io/v2/pet/{petId}/uploadImage")
		.then()
			.log().all();
	}
}
