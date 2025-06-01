package getMethod;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Read_And_Verify_JSONresponse {
	
	@Test
	public void Verify_JSONresponse_M1() {
		RestAssured.baseURI = "https://fakestoreapi.com/products/2";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		JsonPath jsonPath = response.jsonPath();
		
		String title = jsonPath.getString("title").trim();
		String count = jsonPath.getString("rating.count");
		
		Assert.assertEquals(title, "Mens Casual Premium Slim Fit T-Shirts");
		Assert.assertEquals(count, "259");
		
	}
	
	
	@Test
	public void Verify_JSONresponse_M2() {
		
		//need to import "import static org.hamcrest.Matchers.*;" for the matcher method use.
		
		given()
		 .when()
		 .get("https://fakestoreapi.com/products/2")
		 .then()
		 .body("title", equalTo("Mens Casual Premium Slim Fit T-Shirts "));
		
		/*
		 insted of importing static matchers package. we can also use 
		 
		 given()
		 .when()
		 .get("https://fakestoreapi.com/products/2")
		 .then()
		 .body("title", Matchers.equalTo("Mens Casual Premium Slim Fit T-Shirts "));
		 */
		
	}

}
