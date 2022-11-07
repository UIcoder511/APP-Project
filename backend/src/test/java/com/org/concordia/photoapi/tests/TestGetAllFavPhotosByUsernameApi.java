package com.org.concordia.photoapi.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;

public class TestGetAllFavPhotosByUsernameApi extends BaseSetup
{
	public static final String user = "admin";
	
	@Test
	public void getFavPhotos() throws JsonParseException, JsonMappingException, IOException
	{
	
		String getAllFavPhotosInResponse = given().
		when().
		queryParam("username", user).
		get("/get-fav-photos").
		then().
		assertThat().
		statusCode(200).extract().response().asPrettyString();
		
		System.out.println(getAllFavPhotosInResponse);
		
		ObjectMapper mapper = new ObjectMapper();
		List<Photo> photos = mapper.readValue(getAllFavPhotosInResponse, new TypeReference<List<Photo>>() {});
		
		//assert values in json response
		Assert.assertEquals(photos.get(0).getPhotoId(),14168949);
		Assert.assertEquals(photos.get(0).getPhotographerId(),250460536);
		Assert.assertEquals(photos.get(0).getAvgColor(),"#777B7A");
		Assert.assertEquals(photos.get(0).getTitle(),"Free stock photo of 35mm, 35mm camera, 35mm film");
		Assert.assertEquals(photos.get(0).getImageMediumSize(),"photo-14168949-md.jpeg");
		Assert.assertEquals(photos.get(0).getImageLargeSize(),"photo-14168949-lg.jpeg");
		Assert.assertEquals(photos.get(0).getImageOrignalSize(),"photo-14168949-o.jpeg");
	}
}
