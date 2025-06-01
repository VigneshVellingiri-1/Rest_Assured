package getMethod;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
public class get_Test {
	
	public static void main(String[] args) {
		/*
		// way 1
		
		RestAssured.baseURI = "https://fakestoreapi.com/products";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		
		System.out.println(response.asPrettyString()); */
		
		
		/*
		//way 2 
		
		RestAssured.baseURI = "https://fakestoreapi.com/products";
		RequestSpecification request = RestAssured.given();
		Response response = request.request(Method.GET);
		
		System.out.println("Status Code: " + response.getStatusCode());
		System.out.println(response.getTime()/ 1000);
		*/
		
		// Way 3
		// before using this we need to import this package in to our class (import static io.restassured.RestAssured.*;)
		given()
		.when()
		.get("https://fakestoreapi.com/products")
		.then()
		.log().body(); // .log().all(); -> this will print hole response body.
		
	}

}
