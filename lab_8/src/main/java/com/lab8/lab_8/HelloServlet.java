package com.lab8.lab_8;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lab_8_war_exploded/hello")
public class HelloServlet extends HttpServlet {

    public void init() {
        System.out.println("HelloServlet on init");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("HelloServlet on GET request");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h1>Java is the best language in the Universe(after PHP)</h1>");
    }

    public void destroy() {
        System.out.println("HelloServlet on destroy");
    }
}