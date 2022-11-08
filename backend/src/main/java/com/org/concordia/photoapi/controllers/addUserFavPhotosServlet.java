package com.org.concordia.photoapi.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.service.PhotosService;
import com.org.concordia.photoapi.service.PhotosServiceImpl;
import com.org.concordia.photoapi.service.UsersService;
import com.org.concordia.photoapi.service.UsersServiceImpl;

@WebServlet(name = "addUserFavPhotosServlet", urlPatterns = "/add-fav-photos")
public class addUserFavPhotosServlet extends HttpServlet {

	private static final long serialVersionUID = 2872241476921678269L;
	private PhotosService photosService = new PhotosServiceImpl();
	private UsersService userService = new UsersServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		System.out.println(username);

		int photoId = Integer.parseInt(req.getParameter("photoId"));
		System.out.println(photoId);

		try {
			int userId = userService.getUserIdByUsername(username);
			if (userId != -1) {
				photosService.addUserFavPhotos(userId, photoId);
			}
			else
			{
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString("Please check username: "+ username);
				System.out.println(jsonString);
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				resp.getWriter().write(jsonString);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
