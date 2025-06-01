package authentications;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerToken_Authentication {
	
	@Test
	public void BearerToken_Get_M1() {
		
		RestAssured.baseURI = "https://api.github.com";
		RestAssured.basePath = "/user/repos";
		
		RequestSpecification request = RestAssured.given();
		//request.header("Authorization", "");
		
		Response response = request.get();
		
		System.out.println(response.getBody().asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 1)
	public void BearerToken_Get_M2() {
		RestAssured.given()
			//.header("Authorization", " ")
		.when()
			.baseUri("https://api.github.com")
			.basePath("/user/repos")
			.get()
		.then()
		.statusCode(200)
		.body("name[0]", Matchers.equalTo("Rest_Assured"))
		.log().status();
		
	}
	
}
