package Serialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Create_user_Using_Serialization {
	
	@Test
	public void createUser() {
		
		C_user user = new C_user(); // created an object for user POJO class

		// passing values to the flags by using setters
		user.setName("Vignesh");
		user.setJob("SDET");
		
		RestAssured.given()
		              .contentType(ContentType.JSON)
		              .header("x-api-key","reqres-free-v1")
		              .body(user)
		              .when()
		              .baseUri("https://reqres.in/api/users")
		              .post()
		              .then().log().body()
		              .statusCode(201);
	}

}
