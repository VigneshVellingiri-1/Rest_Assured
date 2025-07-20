package uploadFile;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class UploadFile {
	
	@Test
	public void fileUpload() {
		File myfile = new File("file location//file name");
		
		given()
		.multiPart("file",myfile)
		.contentType("multipart/form-data")
		.when()
		.post("http://url")
		.then()
		.statusCode(200)
		.body("filename", equalTo("file name"));
	}

}
