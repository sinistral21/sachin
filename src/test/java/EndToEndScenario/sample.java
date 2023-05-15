package EndToEndScenario;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import genericUtility.BaseClass;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class sample extends BaseClass{
	@Test
public void test() {
	
		Response res=given().spec(reqst).body("{\r\n"
			+ "  \"createdBy\": \"sanjay12er3qwew\",\r\n"
			+ "  \"projectName\": \"shqwhdsbqdaghsw\",\r\n"
			+ "  \"status\": \"string\",\r\n"
			+ "  \"teamSize\": 0\r\n"
			+ "}").when().post("/addProject");
		res.then().spec(resp);

}
}
