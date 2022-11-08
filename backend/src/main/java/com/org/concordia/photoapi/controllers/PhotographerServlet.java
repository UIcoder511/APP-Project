package com.org.concordia.photoapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.service.PhotographerService;
import com.org.concordia.photoapi.service.PhotographerServiceImpl;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "photographerServlet", urlPatterns = "/get-photographer")
public class PhotographerServlet extends HttpServlet {

	private static final long serialVersionUID = 2872241476921678269L;
	private PhotographerService photographerService = new PhotographerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int photographerId = Integer.parseInt(req.getParameter("photographerId"));
		System.out.println(photographerId);

		try {
			List<Photo> photos = photographerService.getPhotosByPhotographerId(photographerId);
			ObjectMapper mapper = new ObjectMapper();
			String jsonString;

			if (photos.size() != 0) {
				System.out.println(photos.size());
				System.out.println(photos.get(0).getPhotoId());
				jsonString = mapper.writeValueAsString(photos);
			} else {
				jsonString = mapper.writeValueAsString("No photos found in DB with given id:" + photographerId);
			}

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
