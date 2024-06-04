package by.belstu.Lab10.classes;


import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DAO implements IConnection, IQuery {
    private static Logger logger = LogManager.getLogger(DAO.class);

    private String url;
    private String user;
    private String password;
    private String driver;
    private Connection con;
    private Statement statement;

    public DAO() {
        logger.debug("DAO class is created");
    }

    public ArrayList<String> getProperties() {
        logger.debug("Fetching database connection properties from resource bundle");

        ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
        url = resourceBundle.getString("db.url");
        user = resourceBundle.getString("db.username");
        password = resourceBundle.getString("db.password");
        driver = resourceBundle.getString("db.driver");

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            logger.info("Driver class found in classpath");
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            logger.error("Driver class is missing in classpath", e);
            throw new RuntimeException("Driver class is missing in classpath", e);
        }

        ArrayList<String> ret = new ArrayList<>();
        ret.add(url);
        ret.add(user);
        ret.add(password);
        return ret;
    }

    public Boolean getConnection() {
        logger.debug("Establishing database connection");

        try {
            getProperties();
            con = DriverManager.getConnection(url, user, password);
            statement = con.createStatement();
            logger.info("Connection established");
            return true;
        } catch (Exception ex) {
            logger.error("Failed to establish a connection", ex);
            return false;
        }
    }

    public int ExecuteUpdate(String sqlQuery, Object... params) {
        logger.debug("Executing SQL update query: {}", sqlQuery);

        try {
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            return statement.executeUpdate();
        } catch (SQLException ex) {
            logger.error("Error executing SQL update query: {}", sqlQuery, ex);
            return 0;
        }
    }

    public ResultSet ExecuteQuery(String sqlQuery) {
        logger.debug("Executing SQL query: {}", sqlQuery);

        try {
            return statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            logger.error("Error executing SQL query: {}", sqlQuery, ex);
            return null;
        }
    }

    public void closeConnection() {
        logger.debug("Closing database connection");

        try {
            con.close();
        } catch (Exception ex) {
            logger.error("Error closing database connection", ex);
        }
    }

    public ArrayList<UniversityClass> getClasses() {
        logger.debug("Fetching classes from the Timetable table");

        ArrayList<UniversityClass> timetable = new ArrayList<>();
        ResultSet rs = ExecuteQuery("select * from Timetable");

        try {
            while (rs.next()) {
                UniversityClass currentUniversityClass = new UniversityClass();
                currentUniversityClass.setClassId(rs.getInt("ClassId"));
                currentUniversityClass.setClassName(rs.getString("ClassName"));
                currentUniversityClass.setClassDay(rs.getString("ClassDay"));
                currentUniversityClass.setClassHours(rs.getString("ClassHours"));
                timetable.add(currentUniversityClass);
            }
        } catch (SQLException e) {
            logger.error("Error fetching classes from the Timetable table", e);
        }

        return timetable;
    }

    public void addUser(String login, String password) throws SQLException {
        logger.debug("Adding a new user with login: {}", login);

        String query = "insert into Users (User_Login, User_Password, User_Role) values (?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, login);
        statement.setString(2, HashPassword.getHash(password));
        if (login.equals("admin")) {
            statement.setString(3, "admin");
        } else {
            statement.setString(3, "user");
        }
        statement.executeUpdate();
        statement.close();
    }

    public ResultSet checkUser(String login, String password) throws SQLException {
        logger.debug("Checking user with login: {}", login);

        PreparedStatement statement = con.prepareStatement("select * from Users where User_Login = ?");
        statement.setString(1, login);
        return statement.executeQuery();
    }

    public ResultSet checkUsersCount(String login, String password) throws SQLException {
        logger.debug("Checking count of users with login: {}", login);

        PreparedStatement statement = con.prepareStatement(
                "select count(*) AS count from Users where User_Login = ? and User_Password = ?");
        statement.setString(1, login);
        statement.setString(2, HashPassword.getHash(password));
        return statement.executeQuery();
    }
}