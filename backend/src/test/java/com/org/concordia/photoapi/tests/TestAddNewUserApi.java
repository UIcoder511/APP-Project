package com.org.concordia.photoapi.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.ResponseForUserCreation;

public class TestAddNewUserApi extends BaseSetup
{
	public static final String user = "testuser";
	public static final String pass = "test";
	
	@Test
	public void addNewUserSuccess() throws JsonParseException, JsonMappingException, IOException
	{
	
		String getMessageAsResponse = given().
		when().
		queryParam("username", user).
		queryParams("password",pass).
		post("/add-user").
		then().
		statusCode(200).
		extract().
		response().
		asPrettyString();
		
		ObjectMapper mapper = new ObjectMapper();
		ResponseForUserCreation response = mapper.readValue(getMessageAsResponse, ResponseForUserCreation.class);
		
		//assert values in json response
		Assert.assertEquals(response.getType(),"success");
		Assert.assertEquals(response.getMessage(),"User successfully created");	
	}
	
	@Test
	public void addNewUserFailure() throws JsonParseException, JsonMappingException, IOException
	{
		String getMessageAsResponse = given().
		when().
		queryParam("username", user).
		queryParams("password",pass).
		post("/add-user").
		then().
		statusCode(200).
		extract().
		response().
		asPrettyString();
		
		ObjectMapper mapper = new ObjectMapper();
		ResponseForUserCreation response = mapper.readValue(getMessageAsResponse, ResponseForUserCreation.class);
		
		//assert values in json response
		Assert.assertEquals(response.getType(),"error");
		Assert.assertEquals(response.getMessage(),"User " + user + " already exists in the system");	
	}

}
