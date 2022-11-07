package com.org.concordia.photoapi.servlet;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.concordia.photoapi.model.ResponseForUserCreation;
import com.org.concordia.photoapi.service.UsersService;
import com.org.concordia.photoapi.service.UsersServiceImpl;

@WebServlet(name = "createUserServlet", urlPatterns = "/add-user")
public class createUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2872241476921678269L;
	private UsersService userService = new UsersServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		
		String username = req.getParameter("username");
		System.out.println(username);
		
		String password = req.getParameter("password");
		System.out.println(password);
		
		//Decode password coming from UI to backend to validate authentication
		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(password);
		String decodedPassword = new String(bytes);
		System.out.println("Decrypted password:" + decodedPassword);
		
		ResponseForUserCreation responseForUser=null;
		
		try
		{
			int userId = userService.getUserIdByUsername(username);
			if(userId == -1)
			{
				if(userService.addUser(username, password))
				{
					responseForUser = new ResponseForUserCreation("success","User successfully created");
				}
			}
			else
			{
				responseForUser = new ResponseForUserCreation("error", "User " + username + " already exists in the system");
			}
			
			ObjectMapper mapper = new ObjectMapper();
		    String jsonString = mapper.writeValueAsString(responseForUser);
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
