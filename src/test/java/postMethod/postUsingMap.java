package postMethod;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class postUsingMap {
	
	@Test
	public void postusingMap() {
		
		RestAssured.baseURI = "https://reqres.in/api/register";
		
		Map<String, String> body = new HashMap<>(); 
		body.put("email", "eve.holt@reqres.in");
		body.put("password", "pistol");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.header("x-api-key", "reqres-free-v1")
		.body(body)
		   .when()
		   .post()
		   .then()
		   .log().body();
	}

}
