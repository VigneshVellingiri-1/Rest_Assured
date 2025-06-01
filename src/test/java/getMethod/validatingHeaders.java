package getMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class validatingHeaders {
	
	
	
	@Test
	public void printing_All_Headers()
	{
		RestAssured.baseURI = "https://fakestoreapi.com/products/2";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		Headers headers = response.getHeaders();
		
		for(Header i : headers) {
			System.out.println(i.getName()+" ==> " + i.getValue());
		}
		
		// ========================================OR============================================= //
		
		given()
		.when()
		.get("https://fakestoreapi.com/products/2")
		.then()
		.log().headers();
	}
	
	@Test
	public void printint_Specific_Header() {
		
		RestAssured.baseURI = "https://fakestoreapi.com/products/2";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeader("Etag"));
		
		// ========================================OR============================================= //
		
		Response response1 = given()
				.when()
				.get("https://fakestoreapi.com/products/2");
		
		System.out.println(response1.getHeader("Etag"));
		
	}
	
	
}
