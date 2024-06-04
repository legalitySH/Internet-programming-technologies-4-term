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

@WebServlet(name = "authServlet", urlPatterns = "/auth-servlet")
public class AuthServlet extends HttpServlet {

    private String message;

    public AuthServlet() {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String hashedPassword = PasswordHasher.hashPassword(password, "SHA-256");
        System.out.println("Login:" + login);
        System.out.println("Password: " + hashedPassword);

        User user = new User(login,hashedPassword, "default");

        UsersDataBase db = new UsersDataBase();

        db.openConnection();



        if(db.isHasUser(user))
        {
            System.out.println("Пользователь существует!");
            request.getRequestDispatcher("welcome.jsp").
                    forward(request, response);
            request.setAttribute("authMessage", "");
        }
        else
        {
            System.out.println("Пользователь не существует!");
            request.setAttribute("authMessage", "Неправильный логин или пароль!");
            PrintWriter out = response.getWriter();
            request.getRequestDispatcher("auth.jsp").
                    forward(request, response);

        }






    }

}