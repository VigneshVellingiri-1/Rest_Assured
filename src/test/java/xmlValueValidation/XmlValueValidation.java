package xmlValueValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XmlValueValidation {
	
	@Test
	public void xmlValueValidation() {
		
		RestAssured.baseURI = "";
		
		RequestSpecification req = RestAssured.given();
		req.contentType("Application/xml");
		Response response = req.get();
		
		XmlPath path = response.xmlPath();
		
		String node = path.get("").toString();
		
		Assert.assertEquals(node, "value");
	}

}
