package putMethod;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateCartUsingPUT {
	
	@Test
	public void getCartItems() {
		
		String basrURI = "https://simple-grocery-store-api.glitch.me";
		String cartId = "9z9heBOTLRWLcfX3NEXuH";
		String endPoint = "/carts/" + cartId + "/items";

		RestAssured.given()
		.baseUri(basrURI)
		.when()
		.get(endPoint)
		.then()
		.log().body();
		
	}
	
	
	@Test
	public void updateCartItem() {
		
		Map<String, Integer> body = new HashMap<>();
		body.put("productId", 4641);
		body.put("quantity", 14);
		
		String basrURI = "https://simple-grocery-store-api.glitch.me";
		String cartId = "9z9heBOTLRWLcfX3NEXuH";
		String itemId = "435772052";
		String endPoint = "/carts/" + cartId + "/items/"+itemId;
		
		
		RestAssured.given()
		.baseUri(basrURI)
		.contentType(ContentType.JSON)
		.body(body)
		.when()
		.put(endPoint)
		.then().log().body();
	}

}
