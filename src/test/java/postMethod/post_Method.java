package postMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class post_Method {
	
	
	@Test
	public void Post() {
		
		Map<String, String> nameMap = new HashMap<>();
        nameMap.put("firstname", "Mahendra Singhq");
        nameMap.put("lastname", "Dhonqi");
        
        
        String requestBody = "{\r\n"
        		+ "    \"email\": \"Thala@seven.com\",\r\n"
        		+ "        \"username\": \"MSDhoni\",\r\n"
        		+ "        \"password\": \"@2011WC\",\r\n"
        		+ "        \"name\": {\r\n"
        		+ "          \"firstname\": \"Mahendra Singh\",\r\n"
        		+ "          \"lastname\": \"Dhoni\"\r\n"
        		+ "        }\r\n"
        		+ "}";
		
        /*
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", "Thala@sevenq.com");
		requestBody.put("username", "MSDhonqqi");
		requestBody.put("password", "@2011WC");
		requestBody.put("name", nameMap);
		*/
		
		
		RequestSpecification req = RestAssured.given();
		req.body(requestBody);
		
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(requestBody)
		.when()
		.post("https://fakestoreapi.in/api/users")
		.then()
		.statusCode(200)
		.body("user.id", equalTo(51))
		.body("status", equalTo("SUCCESS"))
		.log().body();
		
		String req1 = "{\r\n"
				+ "        \"email\": \"Virat@king.com\",\r\n"
				+ "        \"username\": \"MSDhoni\",\r\n"
				+ "        \"password\": \"@2011WC\",\r\n"
				+ "        \"name\": {\r\n"
				+ "          \"firstname\": \"Virat\",\r\n"
				+ "          \"lastname\": \"Kohli\"\r\n"
				+ "        }"
				+ "}";
		
		RestAssured.given()
		.header("Content-Type","application/json")
		.body(req1)
		.when()
		.put("https://fakestoreapi.in/api/users/51")
		.then()
		.log().body();
			
	}
	
	

}
