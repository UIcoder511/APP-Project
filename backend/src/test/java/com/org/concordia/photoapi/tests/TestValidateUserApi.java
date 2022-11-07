package com.org.concordia.photoapi.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class TestValidateUserApi extends BaseSetup {

	@Test
	public void userAuthenticationSuccess() throws JsonParseException, JsonMappingException, IOException {

		String getMessageAsResponse = given().when().queryParam("username", "testuser").queryParams("password", "test")
				.get("/validate-user").then().statusCode(200).extract().response().asPrettyString();

		// assert values in json response
		Assert.assertEquals(getMessageAsResponse, "User Authenticated");
	}
	
	
	@Test
	public void userAuthenticationWrongPassword() throws JsonParseException, JsonMappingException, IOException {

		String getMessageAsResponse = given().when().queryParam("username", "testuser").queryParams("password", "123")
				.get("/validate-user").then().statusCode(200).extract().response().asPrettyString();

		// assert values in json response
		Assert.assertEquals(getMessageAsResponse, "Please check the password entered");
	}

	@Test
	public void userAuthenticationFailure() throws JsonParseException, JsonMappingException, IOException {
		String getMessageAsResponse = given().when().queryParam("username", "test").queryParams("password", "test")
				.get("/validate-user").then().statusCode(200).extract().response().asPrettyString();

		// assert values in json response
		Assert.assertEquals(getMessageAsResponse, "User Authentication Failed");
	}


}
