package jsonSchemaValidation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {
	
	@Test
	public void jsonSchemaValidation() {
		RestAssured.given()
		   			.when()
		   			.get("https://reqres.in/api/users?page=2")
		   			.then()
		   			.assertThat()
		   			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemavalidationtest.json"));
		   			
	}

}
