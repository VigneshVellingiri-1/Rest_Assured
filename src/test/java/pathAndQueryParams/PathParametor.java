package pathAndQueryParams;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PathParametor {
	@Test
	public void pathParam() {
		RestAssured.given()
		.pathParam("id", 9)
		.header("x-api-key","reqres-free-v1")
		.when()
		.get("https://reqres.in/api/users/{id}")
		.then()
		.log().body();
	}

}
