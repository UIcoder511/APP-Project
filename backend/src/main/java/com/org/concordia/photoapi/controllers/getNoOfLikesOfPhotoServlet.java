package com.org.concordia.photoapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.service.PhotosService;
import com.org.concordia.photoapi.service.PhotosServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "getNoOfLikesOfPhotoServlet", urlPatterns = "/get-likes-of-photo")
public class getNoOfLikesOfPhotoServlet extends HttpServlet {

	private static final long serialVersionUID = 2872241476921678269L;
	private PhotosService photosService = new PhotosServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int photoId = Integer.parseInt(req.getParameter("photoId"));

		try {
			int noOfLikes = photosService.getNoOfLikesOfPhoto(photoId);

			System.out.println(photoId + ":" + noOfLikes);

			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(noOfLikes);
			System.out.println(jsonString);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
