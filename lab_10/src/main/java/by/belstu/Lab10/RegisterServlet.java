package by.belstu.Lab10;

import by.belstu.Lab10.classes.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private final DAO db = new DAO();
    private static final Logger logger = LogManager.getLogger(RegisterServlet.class);

    @Override
    public void init() throws ServletException {
        logger.debug("RegisterServlet initialization");
        db.getConnection();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Handling POST request for RegisterServlet");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if (login.length() != 0 && password.length() != 0) {
            ResultSet rs = db.ExecuteQuery("select count(*) AS count from Users where User_Login = '" + login + "'");
            try {
                rs.next();
                if (rs.getInt("count") != 0) {
                    logger.info("User with login '{}' already exists", login);
                    request.setAttribute("ErrorMessage", "Пользователь с таким логином уже сущестует");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    out.close();
                } else {
                    logger.info("Registering new user with login '{}'", login);
                    db.addUser(login, password);
                    ShowMessage(out, "Регистрация прошла успешно!", "login.jsp");
                    out.close();
                }
            } catch (SQLException e) {
                logger.error("Error checking or adding user", e);
                throw new RuntimeException(e);
            }
        } else {
            logger.info("Login or password is empty");
            request.setAttribute("ErrorMessage", "Поля не могут быть пустыми");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            out.close();
        }
    }

    private void ShowMessage(PrintWriter out, String message, String location) {
        logger.debug("Showing message: {}", message);
        out.println("<script type=\"text/javascript\">");
        out.println("alert('" + message + "');");
        out.println("window.location.href = '" + location + "';");
        out.println("</script>");
        out.println("</body></html>");
    }
}