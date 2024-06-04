package lab_6.DAO;

import lab_6.DatabaseManagment.DAO;
import lab_6.Models.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LettersDAOImpl implements DAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/letters_db";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "";

    private Connection connection;
    @Override
    public void openConnection() {
        try
        {
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void closeConnection() {
        try{
            if(connection != null)
            {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void sendLetterToAllRecipients(User sender, String subject, String body) {
        try {
            String recipientIdsQuery = "SELECT id FROM people WHERE id != ?";
            PreparedStatement recipientIdsStatement = connection.prepareStatement(recipientIdsQuery);
            recipientIdsStatement.setInt(1, sender.getId());
            ResultSet recipientIdsResultSet = recipientIdsStatement.executeQuery();

            while (recipientIdsResultSet.next()) {
                int recipientId = recipientIdsResultSet.getInt("id");

                String insertLetterQuery = "INSERT INTO letters (sender_id, recipient_id, subject, body, sent_date) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertLetterStatement = connection.prepareStatement(insertLetterQuery);
                insertLetterStatement.setInt(1, sender.getId());
                insertLetterStatement.setInt(2, recipientId);
                insertLetterStatement.setString(3, subject);
                insertLetterStatement.setString(4, body);
                insertLetterStatement.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
                insertLetterStatement.executeUpdate();
            }

            recipientIdsResultSet.close();
            recipientIdsStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User getMinLetterLengthUser() {
        User minLengthUser = null;
        int minLength = Integer.MAX_VALUE;

        try {
            String query = "SELECT p.id, p.full_name, p.date_of_birth, SUM(LENGTH(l.body)) AS total_length " +
                    "FROM people p " +
                    "LEFT JOIN letters l ON p.id = l.sender_id " +
                    "GROUP BY p.id " +
                    "ORDER BY total_length ASC " +
                    "LIMIT 1";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                java.sql.Date dateOfBirth = resultSet.getDate("date_of_birth");
                int totalLength = resultSet.getInt("total_length");

                if (totalLength < minLength) {
                    minLength = totalLength;
                    minLengthUser = new User(userId, fullName, dateOfBirth);
                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return minLengthUser;
    }

    @Override
    public void getUsersLetterInfo() {
        try {
            connection.setAutoCommit(false);

            String query = "SELECT p.id, p.full_name, p.date_of_birth, " +
                    "COUNT(CASE WHEN l.sender_id = p.id THEN 1 END) AS sent_letters_count, " +
                    "COUNT(CASE WHEN l.recipient_id = p.id THEN 1 END) AS received_letters_count " +
                    "FROM people p " +
                    "LEFT JOIN letters l ON p.id = l.sender_id OR p.id = l.recipient_id " +
                    "GROUP BY p.id";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                java.sql.Date dateOfBirth = resultSet.getDate("date_of_birth");
                int sentLettersCount = resultSet.getInt("sent_letters_count");
                int receivedLettersCount = resultSet.getInt("received_letters_count");

                System.out.println("ID: " + userId);
                System.out.println("ФИО: " + fullName);
                System.out.println("Дата рождения: " + dateOfBirth);
                System.out.println("Количество отправленных писем: " + sentLettersCount);
                System.out.println("Количество полученных писем: " + receivedLettersCount);
                System.out.println();
            }

            resultSet.close();
            statement.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            try {
                    connection.rollback();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    @Override
    public List<User> getUsersByReceivedLetterSubject(String subject) {
        List<User> users = new ArrayList<>();
        try {
            String query = "SELECT p.id, p.full_name, p.date_of_birth " +
                    "FROM people p " +
                    "WHERE p.id  IN ( " +
                    "  SELECT recipient_id " +
                    "  FROM letters " +
                    "  WHERE subject = ? " +
                    ")";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, subject);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                java.sql.Date dateOfBirth = resultSet.getDate("date_of_birth");

                User user = new User(userId, fullName, dateOfBirth);
                users.add(user);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }

    @Override
    public List<User> getUsersByNotReceivedLetterSubject(String subject) {
        List<User> users = new ArrayList<>();

        try {
            String query = "SELECT p.id, p.full_name, p.date_of_birth " +
                    "FROM people p " +
                    "WHERE p.id NOT IN ( " +
                    "  SELECT recipient_id " +
                    "  FROM letters " +
                    "  WHERE subject = ? " +
                    ")";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, subject);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                java.sql.Date dateOfBirth = resultSet.getDate("date_of_birth");

                User user = new User(userId, fullName, dateOfBirth);
                users.add(user);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
