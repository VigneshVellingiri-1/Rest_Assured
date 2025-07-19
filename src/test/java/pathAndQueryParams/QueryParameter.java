package pathAndQueryParams;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class QueryParameter {

	@Test
	public void queryParam() {

		RestAssured.given()
			.queryParam("id", 9)
			.header("x-api-key", "reqres-free-v1")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.log().body();
	}

}
