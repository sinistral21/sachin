package genericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	
	public DatabaseLibrary dLib = new DatabaseLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	@BeforeSuite
	public  void bsConfig() throws SQLException
	{
		
		dLib.connectToDB();
		 
//		baseURI = "http://rmgtestingserver";
//		port = 8084;
		
		  reqst = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		  resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	
	}
	
	@AfterSuite
	public  void asConfig() throws SQLException
	{
		dLib.closeDB();
		
		
	}
}
