package com.org.concordia.photoapi.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.Photo;
import com.org.concordia.photoapi.service.PhotosService;
import com.org.concordia.photoapi.service.PhotosServiceImpl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "sendImageServlet", urlPatterns = "/assets/*")
public class SendImageServlet extends HttpServlet {

  private static final long serialVersionUID = 2872241476921678269L;
  private PhotosService photosService = new PhotosServiceImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    try {
      String imagesBase =
        Paths.get("").toAbsolutePath().toString() + "\\resources\\photos";
      List<Photo> photos = photosService.getPhotos();
      // System.out.println("hhhh");
      System.out.println(photos.size());
      // System.out.println(photos.get(0).getPhotoId());
      // System.out.println(req);
      String URLAfterWebDomain = req.getRequestURI();
      System.out.println("URLAfterWebDomain " + URLAfterWebDomain);
      if (!URLAfterWebDomain.startsWith("/photo-api/assets/")) return;
      String relativeImagePath = URLAfterWebDomain.substring(
        "/photo-api/assets".length()
      );
      // String photoIdString = req.getParameter("photoId");
      // System.out.println(aphotoId);
      // Integer photoId = Integer.parseInt(photoIdString);

      resp.setContentType("image/jpeg"); //as far as I know, this works for PNG as well. You might want to change the mapping to /images/*.jpg if it's giving problems

      ServletOutputStream outStream;
      outStream = resp.getOutputStream();
      System.out.println(imagesBase + relativeImagePath);
      FileInputStream fin = new FileInputStream(imagesBase + relativeImagePath);

      BufferedInputStream bin = new BufferedInputStream(fin);
      BufferedOutputStream bout = new BufferedOutputStream(outStream);
      int ch = 0;
      while ((ch = bin.read()) != -1) bout.write(ch);
      bin.close();

      fin.close();
      bout.close();
      outStream.close();
      // for (int i = 0; i < photos.size(); i++) {
      //   if (photos.get(i).getPhotoId().equals(photoId)) {
      //     System.out.println("Photo id match found in DB");
      //     System.out.println(photos.get(i).getPhotoId());
      //     String current_dir = System.getProperty("user.dir");
      //     current_dir = current_dir.substring(0, current_dir.lastIndexOf('\\'));

      //     String url_medium_Image = new File(
      //       current_dir +
      //       "\\resources\\photos\\" +
      //       photos.get(i).getImageMediumSize()
      //     )
      //       .getPath();
      //     String url_large_Image = new File(
      //       current_dir +
      //       "\\resources\\photos\\" +
      //       photos.get(i).getImageLargeSize()
      //     )
      //       .getPath();
      //     String url_original_Image = new File(
      //       current_dir +
      //       "\\resources\\photos\\" +
      //       photos.get(i).getImageOrignalSize()
      //     )
      //       .getPath();

      //     List<String> listOfUrls = new ArrayList<String>();
      //     listOfUrls.add(url_medium_Image);
      //     listOfUrls.add(url_large_Image);
      //     listOfUrls.add(url_original_Image);

      //     ObjectMapper mapper = new ObjectMapper();
      //     String jsonString = mapper.writeValueAsString(listOfUrls);
      //     System.out.println(jsonString);
      //     resp.setContentType("application/json");
      //     resp.setCharacterEncoding("UTF-8");
      //     resp.getWriter().write(jsonString);
      //   }
      // }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
