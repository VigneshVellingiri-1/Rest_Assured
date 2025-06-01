package authentications;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basic_Authentications {
	
	@Test
	public void basic_Authentication_M1() {
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		
		RequestSpecification request = RestAssured.given();
		request.auth().basic("postman", "password");
		
		Response response = request.get();
		
		JsonPath jsonPath = response.jsonPath();
		
		String authentication = jsonPath.getString("authenticated");
		
		Assert.assertEquals(authentication, "true");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test
	public void basic_Authentication_M2() {
		
		given()
		.auth().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true));
		
	}

}
