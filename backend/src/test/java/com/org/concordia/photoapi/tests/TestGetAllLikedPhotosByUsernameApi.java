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

public class TestGetAllLikedPhotosByUsernameApi extends BaseSetup
{
	public static final String user = "admin";
	
	@Test
	public void getLikedPhotos() throws JsonParseException, JsonMappingException, IOException
	{
	
		String getAllLikedPhotosInResponse = given().
		when().
		queryParam("username", user).
		get("/get-liked-photos").
		then().
		assertThat().
		statusCode(200).extract().response().asPrettyString();
		
		System.out.println(getAllLikedPhotosInResponse);
		
		ObjectMapper mapper = new ObjectMapper();
		List<Photo> photos = mapper.readValue(getAllLikedPhotosInResponse, new TypeReference<List<Photo>>() {});
		
		//assert values in json response
		Assert.assertEquals(photos.get(0).getPhotoId(),14072809);
		Assert.assertEquals(photos.get(0).getPhotographerId(),342801918);
		Assert.assertEquals(photos.get(0).getAvgColor(),"#515149");
		Assert.assertEquals(photos.get(0).getTitle(),"Man in Green Jacket Standing on Brown Wooden Bridge");
		Assert.assertEquals(photos.get(0).getImageMediumSize(),"photo-14072809-md.jpeg");
		Assert.assertEquals(photos.get(0).getImageLargeSize(),"photo-14072809-lg.jpeg");
		Assert.assertEquals(photos.get(0).getImageOrignalSize(),"photo-14072809-o.jpeg");
	}
}
