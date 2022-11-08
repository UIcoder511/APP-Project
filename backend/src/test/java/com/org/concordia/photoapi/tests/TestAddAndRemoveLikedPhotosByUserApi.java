package com.org.concordia.photoapi.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class TestAddAndRemoveLikedPhotosByUserApi extends BaseSetup {
	public static final String user = "testuser";
	public static final String photoId = "1234567";

	@Test(priority = 0)
	public void addPhotosLikedByUser() throws JsonParseException, JsonMappingException, IOException {

		given().when().queryParam("username", user).queryParams("photoId", photoId).post("/add-liked-photos").then()
				.assertThat().statusCode(200);

	}

	@Test(priority = 1)
	public void removePhotosDislikedByUser() throws JsonParseException, JsonMappingException, IOException {
		given().when().queryParam("username", user).queryParams("photoId", photoId).post("/remove-liked-photos").then()
				.assertThat().statusCode(200);
	}

	// Negative tests
	@Test(priority = 2)
	public void addPhotosLikedByInvalidUser() throws JsonParseException, JsonMappingException, IOException {

		String invalidUser = "123";

		String response = given().when().queryParam("username", invalidUser).queryParams("photoId", photoId)
				.post("/add-liked-photos").then().extract().response().asPrettyString();

		Assert.assertEquals(response, "\"Please check username: "+invalidUser+"\"");

	}

	@Test(priority = 3)
	public void removePhotosDislikedByInvalidUser() throws JsonParseException, JsonMappingException, IOException {

		String invalidUser = "123";

		String response = given().when().queryParam("username", invalidUser).queryParams("photoId", photoId)
				.post("/remove-liked-photos").then().extract().response().asPrettyString();

		Assert.assertEquals(response, "\"Please check username: "+invalidUser+"\"");
	}

}
