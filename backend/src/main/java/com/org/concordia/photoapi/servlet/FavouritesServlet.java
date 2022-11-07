package com.org.concordia.photoapi.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.service.PhotosService;
import com.org.concordia.photoapi.service.PhotosServiceImpl;
import com.org.concordia.photoapi.service.UsersService;
import com.org.concordia.photoapi.service.UsersServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "favouritesServlet", urlPatterns = "/getFavouritePhotos")
public class FavouritesServlet extends HttpServlet {

  private static final long serialVersionUID = 2872241476921678269L;
  private PhotosService photosService = new PhotosServiceImpl();
  private UsersService userService = new UsersServiceImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    String username = req.getParameter("username");
    System.out.println(username);

    try {
      int user_id = userService.getUserIdByUsername(username);
      List<Photo> photos = photosService.getUserFavouritePhotos(user_id);

      System.out.println(photos.size());
      System.out.println(photos.get(0).getPhotoId());

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
