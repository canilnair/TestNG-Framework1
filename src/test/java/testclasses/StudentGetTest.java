package testclasses;

import static com.jayway.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class StudentGetTest {
	
	@BeforeClass
	public static void init(){
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/";
		//RestAssured.basePath="/domainName";
		
	}
		
	@Test
	public void getActivityFeed(){
		
		/**
		 * given()
		 * set cookies, add, auth, adding, parameters, setting header info
		 * .when()
		 * GET, POST, PUT, DELETE..etc
		 * .then()
		 * validate status code, extract response, extract header, cookies, extract the response body
		 */
		
		Response reponse = given().when().get("/posts");
		
		String x = reponse.body().prettyPrint();
		
		String y = reponse.asString();
		
		if(x.equals(y)){
			System.out.println("Pass");
		} else System.out.println("Fail");
			
		given()
		.when()
		.get("/posts")
		.then()
		.statusCode(300);
		
	}
	

}
