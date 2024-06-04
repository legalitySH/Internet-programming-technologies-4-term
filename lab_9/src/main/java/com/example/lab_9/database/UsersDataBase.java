package com.example.lab_9.database;

import java.sql.*;

public class UsersDataBase implements DAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/users_db";
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
    public boolean isHasUser(User user) {
        boolean hasUser = false;
        String query = "SELECT COUNT(*) FROM users_table WHERE login = ? AND pass = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    hasUser = (count > 0);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return hasUser;
    }

    @Override
    public void createUser(User user) {
        String query = "INSERT INTO users_table (login, pass) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Пользователь успешно создан.");
            } else {
                System.out.println("Не удалось создать пользователя.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getUserRole(User user) {
        String role = null;
        String query = "SELECT user_role FROM users_table WHERE login = ? AND pass = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    role = resultSet.getString("user_role");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return role;
    }


}
