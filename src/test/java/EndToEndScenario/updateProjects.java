package EndToEndScenario;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.EndPointsLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateProjects {
@Test
public void update() {
	baseURI = "http://localhost";
	port = 8084;
	
	JSONObject job = new JSONObject();
	
	job.put( "createdBy" , "Drshn");
	job.put("projectName" , "ydvv");
	job.put("status" , "Active");
	job.put("teamSize" , 4);
	
	given().body(job).pathParam("pid", "job").contentType(ContentType.JSON)
	.when().put(EndPointsLibrary.updateProject + "")
	.then().assertThat().statusCode(200).log().all();
	//get("http://localhost:8084/projects/{pid}")
}
}
