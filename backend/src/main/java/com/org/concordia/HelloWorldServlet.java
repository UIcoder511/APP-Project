package com.org.concordia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloWorldServlet", urlPatterns = "/helloworld")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


        try {

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }
}