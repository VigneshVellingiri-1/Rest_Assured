package deleteMethod;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteMethod {
	
	@Test
	public void getCartItems() {
		String baseURI = "https://simple-grocery-store-api.glitch.me";
		String cartID = "9z9heBOTLRWLcfX3NEXuH";
		String endPoint = "/carts/"+cartID+"/items/";
		
		RestAssured.baseURI = baseURI;
		RequestSpecification request = RestAssured.given();
		Response response = request.get(endPoint);
		
		JsonPath body = response.jsonPath();
		
		
		//System.out.println(response.getBody().asPrettyString());
		System.out.println(body.getString("[1].productId"));
	}
	
	@Test
	public void deleteAnCartItem() {
		String baseURI = "https://simple-grocery-store-api.glitch.me";
		String cartID = "9z9heBOTLRWLcfX3NEXuH";
		String itemId = "435772052";
		String endPoint = "/carts/"+cartID+"/items/"+itemId;
		
		RestAssured.given()
			.baseUri(baseURI)
			.basePath(endPoint)
		.when()
			.delete()
		.then()
			.statusCode(204)
			.log()
			.body();
	}

}
