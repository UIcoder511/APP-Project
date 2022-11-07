package com.org.concordia.photoapi.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class TestAddAndRemoveFavouritePhotosByUserApi extends BaseSetup
{
	public static final String user = "admin";
	public static final String photoId = "14168949";
	
	@Test
	public void addUserFavPhotos() throws JsonParseException, JsonMappingException, IOException
	{
	
	    given().
		when().
		queryParam("username", user).
		queryParams("photoId",photoId).
		post("/add-fav-photos").
		then().
		assertThat().
		statusCode(200);

	}
	
	@Test
	public void removeUserFavPhotos() throws JsonParseException, JsonMappingException, IOException
	{
		given().
		when().
		queryParam("username", user).
		queryParams("photoId",photoId).
		post("/remove-fav-photos").
		then().
		assertThat().
		statusCode(200);
	}
}
