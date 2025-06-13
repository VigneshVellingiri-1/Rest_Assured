package deserialization_1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Single_user {
	
	@Test
	public void sing() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		
		Response response  = req.get();
		
		getUserapi import_data = response.as(getUserapi.class);
		
		String FName = import_data.getData().getFirst_name();
		
		System.out.println(FName);
	}

}
