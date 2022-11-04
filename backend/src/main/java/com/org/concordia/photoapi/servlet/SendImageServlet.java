package com.org.concordia.photoapi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.service.PhotosService;
import com.org.concordia.photoapi.service.PhotosServiceImpl;

@WebServlet(name = "sendImageServlet", urlPatterns = "/assets")
public class SendImageServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2872241476921678269L;
	private PhotosService photosService = new PhotosServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		try
		{
			List<Photo> photos = photosService.getPhotos();
			
			System.out.println(photos.size());
			System.out.println(photos.get(0).getPhoto_id());
			
			String photoId=req.getParameter("photoId"); 
			System.out.println(photoId);
			Integer photo_id = Integer.parseInt(photoId);
			
			for(int i=0;i<photos.size();i++)
			{
				if(photos.get(i).getPhoto_id().equals(photo_id))
				{
					System.out.println("Photo id match found in DB");
					System.out.println(photos.get(i).getPhoto_id());
					ServletContext sc = getServletContext();
					String url_medium_Image= sc.getRealPath("/WEB-INF/photos/"+photos.get(i).getImageMediumSize());
					String url_large_Image= sc.getRealPath("/WEB-INF/photos/"+photos.get(0).getImageLargeSize());
					String url_original_Image= sc.getRealPath("/WEB-INF/photos/"+photos.get(0).getImageOrignalSize());
					
					List<String> listOfUrls = new ArrayList<String>();
					listOfUrls.add(url_medium_Image);
					listOfUrls.add(url_large_Image);
					listOfUrls.add(url_original_Image);
					
//					String page = "/photo-api/assets/" + photos.get(0).getImageMediumSize();
					//OutputStream os = resp.getOutputStream();
//					String currentDir  = System.getProperty("user.dir");
//					System.out.println(currentDir + "\\resources\\Photos\\"+photos.get(i).getImageMediumSize());
//					InputStream is = sc.getResourceAsStream("/WEB-INF/photos/"+photos.get(0).getImageMediumSize());
//					if (is == null) {
//
//		                resp.setContentType("text/plain");
//		                resp.getOutputStream().write("Failed to send image".getBytes());
//		            } else { 	
//		            	
//		                resp.setContentType("image/jpeg");
//		                resp.sendRedirect(page);
//		                
//		                byte[] buffer = new byte[1024];
//		    			int bytesRead;
//		    			
//		                while ((bytesRead = is.read(buffer)) != -1) {
//
//		                	resp.getOutputStream().write(buffer, 0, bytesRead);
//		                }
		                
		                ObjectMapper mapper = new ObjectMapper();
		    			String jsonString = mapper.writeValueAsString(listOfUrls);
		                System.out.println(jsonString);
		                resp.setContentType("application/json");
		    			resp.setCharacterEncoding("UTF-8");
		    			resp.getWriter().write(jsonString);
		            }
				}
				
			
        } catch (Exception e) {
            e.printStackTrace();
        }	
	}
}
