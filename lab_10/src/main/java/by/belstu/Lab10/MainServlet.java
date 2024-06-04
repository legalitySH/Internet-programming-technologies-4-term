package by.belstu.Lab10;

import by.belstu.Lab10.classes.DAO;
import by.belstu.Lab10.classes.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    private static final DAO db = new DAO();
    private static final Logger logger = LogManager.getLogger(MainServlet.class);

    @Override
    public void init() throws ServletException {
        logger.debug("MainServlet initialization");
        db.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Handling GET request for MainServlet");

        String classId = request.getParameter("id");
        logger.info("Deleting class with ID: {}", classId);
        db.ExecuteUpdate("delete from Timetable where classId = " + classId);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("current_user");
        request.setAttribute("name", user.getLogin());
        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.debug("Handling POST request for MainServlet");

        String action = request.getParameter("action");
        if (action != null && action.equals("edit")) {
            logger.info("Handling class edit request");

            String idEdit = request.getParameter("idEdit");
            String nameEdit = request.getParameter("nameEdit");
            String institutionEdit = request.getParameter("institutionEdit");
            String quantityEdit = request.getParameter("quantityEdit");

            logger.debug("Updating class with ID: {}", idEdit);
            db.ExecuteUpdate("UPDATE Timetable SET ClassName = '" + nameEdit + "', ClassDay = '" + institutionEdit + "', ClassHours = '" + quantityEdit + "' WHERE classId = " + idEdit);

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("current_user");
            request.setAttribute("name", user.getLogin());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            logger.info("Handling class add request");

            String className = request.getParameter("name");
            String classInstitution = request.getParameter("institution");
            String classQuantity = request.getParameter("quantity");

            logger.debug("Inserting new class: {}, {}, {}", className, classInstitution, classQuantity);
            db.ExecuteUpdate("INSERT INTO Timetable (ClassName, ClassDay, ClassHours) VALUES ('"
                    + className + "', '" + classInstitution + "', '" + classQuantity + "');");

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("current_user");
            request.setAttribute("name", user.getLogin());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
    }
}