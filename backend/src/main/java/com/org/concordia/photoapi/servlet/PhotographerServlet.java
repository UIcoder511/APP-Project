package com.org.concordia.photoapi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.service.PhotographerService;
import com.org.concordia.photoapi.service.PhotographerServiceImpl;

@WebServlet(name = "photographerServlet", urlPatterns = "/photographer")
public class PhotographerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2872241476921678269L;
	private PhotographerService photographerService = new PhotographerServiceImpl();
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		
		String photographerName = req.getParameter("photographerName");
		System.out.println(photographerName);
		
		try
		{
			List<Photo> photos = photographerService.getPhotosByPhotographerName(photographerName);
			
			System.out.println(photos.size());
			System.out.println(photos.get(0).getPhoto_id());
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(photos);
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
