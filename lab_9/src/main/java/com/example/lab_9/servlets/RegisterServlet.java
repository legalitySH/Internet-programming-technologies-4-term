package com.example.lab_9.servlets;

import com.example.lab_9.database.PasswordHasher;
import com.example.lab_9.database.User;
import com.example.lab_9.database.UsersDataBase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", urlPatterns = "/reg-servlet")
public class RegisterServlet extends HttpServlet {


    public RegisterServlet() {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        String hashedPassword = PasswordHasher.hashPassword(password, "SHA-256");
        System.out.println("Login:" + login);
        System.out.println("Password:" + password);
        System.out.println("Password(hashed): " + hashedPassword);

        User user = new User(login,hashedPassword,role);

        UsersDataBase db = new UsersDataBase();

        db.openConnection();


        TODO add user to db


    }

}