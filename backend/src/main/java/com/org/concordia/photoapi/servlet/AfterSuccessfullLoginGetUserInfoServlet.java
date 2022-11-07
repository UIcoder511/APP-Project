package com.org.concordia.photoapi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.model.User;
import com.org.concordia.photoapi.service.PhotosService;
import com.org.concordia.photoapi.service.PhotosServiceImpl;
import com.org.concordia.photoapi.service.UsersService;
import com.org.concordia.photoapi.service.UsersServiceImpl;

@WebServlet(name = "validateUserServlet", urlPatterns = "/get-user")
public class AfterSuccessfullLoginGetUserInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2872241476921678269L;
	private PhotosService photosService = new PhotosServiceImpl();
	private UsersService userService = new UsersServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		
		String username = req.getParameter("username");
		System.out.println(username);
		
		try
		{
			int user_id = userService.getUserIdByUsername(username);
		    List<Photo> likedPhotos = photosService.getUserLikedPhotos(user_id);
		    List<Photo> favPhotos = photosService.getUserFavouritePhotos(user_id);
		    
		    System.out.println(likedPhotos.size());
		    System.out.println(favPhotos.size());
		    
		    ArrayList<Integer>  liked_photo_ids  = new ArrayList<Integer>();
		    ArrayList<Integer>  fav_photo_ids  = new ArrayList<Integer>();
		  
		    //liked photo ids list
		    for(int index=0;index<likedPhotos.size();index++)
		    {
		    	liked_photo_ids.add(likedPhotos.get(index).getPhotoId());
		    }
		    
		    //favourite photo ids list
		    for(int index=0;index<favPhotos.size();index++)
		    {
			    fav_photo_ids.add(favPhotos.get(index).getPhotoId());
		    }
		    
		    
		    User userObject = new User(user_id,username,fav_photo_ids,liked_photo_ids);
		    
		    ObjectMapper mapper = new ObjectMapper();
		    String jsonString = mapper.writeValueAsString(userObject);
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
