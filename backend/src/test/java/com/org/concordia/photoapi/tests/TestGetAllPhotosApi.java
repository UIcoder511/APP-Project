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

public class TestGetAllPhotosApi extends BaseSetup
{
	@Test
	public void showAllPhotosToUser() throws JsonParseException, JsonMappingException, IOException
	{
		String getAllPhotosInResponse = given().
		when().
		get("/get-all-photos").
		then().
		statusCode(200).
		extract().
		response().
		asPrettyString();
		
		ObjectMapper mapper = new ObjectMapper();
		List<Photo> photos = mapper.readValue(getAllPhotosInResponse, new TypeReference<List<Photo>>() {});
		
		//assert values in json response
		Assert.assertEquals(photos.get(0).getPhotoId(),2811476);
		Assert.assertEquals(photos.get(0).getPhotographer().getphotographerId(),384585);
		Assert.assertEquals(photos.get(0).getPhotographer().getphotographerName(),"Urte Bara");
		Assert.assertEquals(photos.get(0).getPhotographer().getphotographerUrl(),"https://www.pexels.com/@urtebara");
		Assert.assertEquals(photos.get(0).getAvgColor(),"#808285");
		Assert.assertEquals(photos.get(0).getTitle(),"Free stock photo of 120mm film, analog, analog photography");
		Assert.assertEquals(photos.get(0).getImageMediumSize(),"photo-2811476-md.jpeg");
		Assert.assertEquals(photos.get(0).getImageLargeSize(),"photo-2811476-lg.jpeg");
		Assert.assertEquals(photos.get(0).getImageOrignalSize(),"photo-2811476-o.jpeg");
		
		
	}

}
