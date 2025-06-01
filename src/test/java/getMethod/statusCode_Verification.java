package getMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class statusCode_Verification {
	
	
	@Test
	
	public void validateStatusCode() {
		// Way 1
		
				RestAssured.baseURI = "https://fakestoreapi.com/products/3";
				RequestSpecification request = RestAssured.given();
				Response response = request.get();
				
				int statusCode = response.getStatusCode();
				
				try {
				Assert.assertEquals(statusCode, 200);
				}
				catch(Exception e) {
					System.out.println("Test Faild");
				}
	}
	
	
	@Test
	public void validateStatusCodeWay2() {
		
		given()
		.when()
		.get("https://fakestoreapi.com/products/3/test")
		.then()
		.statusCode(404);
		
	}

}
