package com.app.tests;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;

import com.app.utilities.ConfigurationReader;

import io.restassured.http.ContentType;
public class APiDay3_JsonPath {
	
	/*
	 * Given Accept type is json
	 *  When I send GET request to REST url:
	 *  http://34.223.219.142:1212/ords/hr/regions
	 *  Then response status code should be 200
	 *  And Response content should be json
	 *  And 4 regions should be returned
	 *  And Americas is one of the region names
	 * 
	 * 
	 */
	@Test
	public void testItemsCountFromResponseBody() {
		given().accept(ContentType.JSON)
		.when().get(ConfigurationReader.getProperty("hrapp.baseresturl")+"/regions")
		.then().assertThat().statusCode(200)
		.and().assertThat().contentType(ContentType.JSON)
		.and().assertThat().body("items.region_id", hasSize(4)) //items.region_id gives a list
		.and().assertThat().body("items.region_name", hasItems("Americas"))
		.and().assertThat().body("items.region_name", hasItems("Americas","Asia","Middle East and Africa"));
	}
	/**PARAMETERS
	 * Given Accept type is Json
	 * And Params are limit=100
	 * And path param is 110
	 * When I set GET request to 
	 *  http://34.223.219.142:1212/ords/hr/employee
	 *  Then status code is 200
	 *  And Response coment should be json
	 *  And 100 employees data should be in json response body
		 * 
		 */
	


	@Test
	public void testWithQueryParameterAndList() {
		given().accept(ContentType.JSON)
		.and().params("limit",100)
		.when().get(ConfigurationReader.getProperty("hrapp.baseresturl")+"/employees")
		.then().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().assertThat().body("items.employee_id", hasSize(100));
		
		
	}
	/*PARAMETERS
	 * Given Accept type is Json
	 * And Params are limit=100
	 * When I set GET request to 
	 *  http://34.223.219.142:1212/ords/hr/employee
	 *  Then status code is 200
	 *  And Response content should be json
	 *  And following data should be returned:
	 *  "employee_id": 110,
	 *  "first_name": "John",
	 *  "last_name":"Chen",
	 *  "email": "JCHEN",
	 */
		
	
	
	@Test
	public void testWithPathParameters() {
		given().accept(ContentType.JSON)
		.and().params("limit",100)
		.and().pathParams("employee_id", 110)
		.when().get(ConfigurationReader.getProperty("hrapp.baseresturl")+"/employees/{employee_id}")
		.then().statusCode(200)
		.and().contentType(ContentType.JSON)
		.and().assertThat().statusCode(200)
		.assertThat().body("employee_id", equalTo(110),
							"first_name",equalTo("John"),
							"last_name",equalTo("Chen"),
							"email",equalTo("JCHEN"));
		
		
	}

}

