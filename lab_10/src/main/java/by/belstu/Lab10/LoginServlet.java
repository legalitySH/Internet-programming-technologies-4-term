package by.belstu.Lab10;

import by.belstu.Lab10.classes.DAO;
import by.belstu.Lab10.classes.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final DAO db = new DAO();
    private static final User user = new User();
    private static final Logger logger = LogManager.getLogger(LoginServlet.class);

    @Override
    public void init() throws ServletException {
        logger.debug("LoginServlet initialization");
        db.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Handling GET request for LoginServlet");

        boolean isUserFound = false;
        Date currentDate = new Date();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        HttpSession session = request.getSession();

        if (login.isEmpty() || password.isEmpty()) {
            logger.info("Login or password is empty");
            request.setAttribute("ErrorMessage", "Поля не могут быть пустыми!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        try {
            ResultSet rs = db.checkUsersCount(login, password);
            rs.next();
            if (rs.getInt("count") != 0) {
                logger.info("User '{}' is found in the database", login);
                ResultSet userSet = db.checkUser(login, password);
                userSet.next();
                user.setLogin(userSet.getString("User_Login"));
                user.setRole(userSet.getString("User_Role"));
                isUserFound = true;
            } else {
                logger.info("User '{}' is not found in the database", login);
                request.setAttribute("ErrorMessage", "Пользователя не существует");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            logger.error("Error checking user in the database", e);
            throw new RuntimeException(e);
        }

        if (isUserFound) {
            logger.info("User '{}' with role '{}' is logged in", user.getLogin(), user.getRole());
            request.setAttribute("name", user.getLogin());
            request.setAttribute("role", user.getRole());
            request.setAttribute("date", currentDate);
            session.setAttribute("current_user", user);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        } else {
            logger.info("Invalid login or password for user '{}'", login);
            request.setAttribute("ErrorMessage", "Неверный логин или пароль");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        out.println("</body></html>");
        out.close();
    }
}