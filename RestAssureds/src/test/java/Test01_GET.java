



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test01_GET {
	
    @Test(priority=1)
	void test_01(){
		
	  // first we will validate the success code.
		 
				 given()
				 .get("https://api.spacexdata.com/v4/launches/latest")
				 .then().assertThat().statusCode(200);
				 
		
		 
	}
	
    @Test(priority=2)
	void test_02(){
		
	  // here we are validating the recovert attempt and recoverd is true or not 
		
				 given()
				 .get("https://api.spacexdata.com/v4/launches/latest")
				 .then()
				 .body("fairings.recovery_attempt", equalTo(true))
				 .and().body("fairings.recovered", equalTo(true));
				 
		 
	}
    
    
    @Test(priority=3)
   	void test_03(){
   		
   	  // we are validating the rocket and name  and success is true or not 
   		
   				 given()
   				 .get("https://api.spacexdata.com/v4/launches/latest")
   				 .then()
   				 .body("fairings.x.success", equalTo(true))
   				 .and().body("name", contains("Starlink-10"))
   				 .and().body("rocket", equalTo("5e9d0d95eda69973a809d1ec"));
   				 
   		 
   	}
    
    
    
    
    
    

}
