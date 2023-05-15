package EndToEndScenario;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import PojoClasses.CreateProject;
import genericUtility.BaseClass;
import genericUtility.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProjectAndVerifyInDataBase extends BaseClass{
	@Test
	public void createProje() throws SQLException {
		
		//Step 1: create pre requisites
		CreateProject cp =new CreateProject("sachin", "TYSS"+jLib.randomNum(), "createdBy", 12);
		
		 //Step 2: send the request
		Response resp=given()
		.spec(reqst).body(cp)
		.when().post(EndPointsLibrary.createProject);
		 //Step 3: capture the project ID	
		
	    String	expdata=rLib.getJsonData(resp, "projectId");
	    System.out.println(expdata);
	
	    //Step 4: validate the id in database
	    String query = "select* from project;";
	    String actData=dLib.readDataFromDBAndValidate(query, 1, expdata);
		  
		  Assert.assertEquals(expdata, actData);
		  System.out.println("TC pass");
	    
		resp.then().log().all();
	}

}
