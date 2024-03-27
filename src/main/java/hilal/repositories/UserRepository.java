package hilal.repositories;

import hilal.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserRepository {

    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "1234"
        );
        System.out.println("CONNECTION TO DB IS MADE");
        return connection;
    }

    public long create(User newUser) throws SQLException {
        Statement createStatement = getConnection().createStatement();
        String query = "INSERT INTO user " +
                "(username, email, role, createdAt, password) " +
                "VALUES " +
                "('" + newUser.getUsername() + "', " +
                "'" + newUser.getEmail() + "', " +
                "'" + newUser.getRole() + "', " +
                "'" + newUser.getCreatedAt() + "', " +
                "'" + newUser.getPassword() + "')"
                ;
        return createStatement.executeUpdate(query);
    }

    public User read(long id) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from user where id="+id;
        ResultSet resultSet = selectStatement.executeQuery(query);
        if(resultSet.next()){
            return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("username"),
                    resultSet.getString("email"),
                    resultSet.getString("role"),
                    resultSet.getString("password"),
                    resultSet.getTimestamp("createdat"),
                    resultSet.getTimestamp("updatedat")
            );
        }
        return null;
    }

    public List<User> read(User example) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from user where id="+example.getId();
        ResultSet resultSet = selectStatement.executeQuery(query);
        List<User> users = new ArrayList<>();
        if(resultSet.next()){
            users.add( new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("role"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("createdat"),
                        resultSet.getTimestamp("updatedat"))
                        );
            return users;
        }
        return Collections.emptyList();
    }

    public List<User> read() throws SQLException {
        List<User> userList = new ArrayList<>();
        Statement selectStatement = getConnection().createStatement();
        String query = "SELECT id, username, email, password, createdat, updatedat FROM user";
        ResultSet result = selectStatement.executeQuery(query);
        while (result.next()) {
            User user = new User();
            user.setId(result.getLong("id"));
            user.setUsername(result.getString("username"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
            user.setCreatedAt(result.getTimestamp("createdat"));
            user.setUpdatedAt(result.getTimestamp("updatedat"));
            userList.add(user);
        }
        return userList;
    }

    public int update(int id, String password) throws SQLException {
        // Statement updateStatement = getConnection().createStatement();
        // all ? here are query parameters with parameterIndexes..
        // 1st ? index is 0, 2nd ? index is 1 .
        String preparedQuery = "UPDATE user SET  password = ? WHERE id = ?";
        PreparedStatement updateStatement = getConnection().prepareStatement(preparedQuery);
        updateStatement.setString(1, password);
        updateStatement.setInt(2, id);
        return updateStatement.executeUpdate();
    }

    public int update(int id, User existingUser) throws SQLException {
        // Statement updateStatement = getConnection().createStatement();
        // all ? here are query parameters with parameterIndexes..
        // 1st ? index is 0, 2nd ? index is 1 .
        String preparedQuery = "UPDATE user SET username = ?, email = ?, password = ? WHERE id = ?";
        PreparedStatement updateStatement = getConnection().prepareStatement(preparedQuery);
        updateStatement.setString(1, existingUser.getUsername());
        updateStatement.setString(2, existingUser.getEmail());
        updateStatement.setString(3, existingUser.getPassword());
        updateStatement.setInt(4, id);
        return updateStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String query = "DELETE FROM user WHERE id = ?";
        PreparedStatement deleteStatement = getConnection().prepareStatement(query);
        deleteStatement.setInt(1, id);
        return deleteStatement.executeUpdate();
    }

}