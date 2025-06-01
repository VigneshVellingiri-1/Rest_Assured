package deserialization;

import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deserialization {

	@Test
	public void decreialization() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		Response response = req.get();

		api_response fet = response.as(api_response.class);

		List<de_user> obj = fet.getData();

		for (int i = 0; i < obj.size(); i++) {
			System.out.println(obj.get(i).getId());
		}

		for (de_user user : fet.getData()) {
			assertNotNull(user.getId(), "ID is missing");
			assertNotNull(user.getEmail(), "Email is missing");
			assertNotNull(user.getFirst_name(), "First name is missing");
			assertNotNull(user.getLast_name(), "Last name is missing");
			assertNotNull(user.getAvatar(), "Avatar is missing");

		}
	}

}
