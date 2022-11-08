package com.org.concordia.photoapi.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.Photographer;
import com.org.concordia.photoapi.model.PhotographerWithPhotos;
import com.org.concordia.photoapi.util.DBConnect;

public class TestGetAllPhotosByPhotographer extends BaseSetup {

	@Test
	public void showAllPhotosToUserByPhotographer() throws JsonParseException, JsonMappingException, IOException {
		String getAllPhotosInResponse = given().when().get("/get-photographers-with-photos").then().statusCode(200)
				.extract().response().asPrettyString();

		ObjectMapper mapper = new ObjectMapper();
		List<PhotographerWithPhotos> photographerPhotos = mapper.readValue(getAllPhotosInResponse,
				new TypeReference<List<PhotographerWithPhotos>>() {
				});
		
		
		for (int index=0;index<photographerPhotos.size();index++) {
			if(photographerPhotos.get(index).getPhotographer().getphotographerId().equals(1234))
			{
				
				List<Photo> photos = photographerPhotos.get(index).getPhotos();

				// assert values for Photographer details
				Assert.assertEquals(photographerPhotos.get(index).getPhotographer().getphotographerId(), 1234);
				Assert.assertEquals(photographerPhotos.get(index).getPhotographer().getphotographerName(), "test");
				Assert.assertEquals(photographerPhotos.get(index).getPhotographer().getphotographerUrl(), "@test");

				// assert values for photos by Photographer
				Assert.assertEquals(photos.get(0).getPhotoId(), 1234567);
				Assert.assertEquals(photos.get(0).getPhotographerId(), 1234);
				Assert.assertEquals(photos.get(0).getAvgColor(), "#515149");
				Assert.assertEquals(photos.get(0).getTitle(), "Its Test Data");
				Assert.assertEquals(photos.get(0).getImageMediumSize(), "photo-1234567-md.jpeg");
				Assert.assertEquals(photos.get(0).getImageLargeSize(), "photo-1234567-lg.jpeg");
				Assert.assertEquals(photos.get(0).getImageOrignalSize(), "photo-1234567-o.jpeg");

			}
		}
	
	}

}
