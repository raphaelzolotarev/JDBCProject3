package hilal.repositories;

import hilal.models.PostLike;
import hilal.models.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostLikeRepository {

private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "1234"
        );
        System.out.println("CONNECTION TO DB IS MADE");
        return connection;
    }

    public long create(PostLike newPostLike) throws SQLException {
        Statement createStatement = getConnection().createStatement();
        String query = "Update postlike Set postid=?,userid=? where postid=?";
        PreparedStatement updateStatement = getConnection().prepareStatement(query);
        updateStatement.setLong(1, newPostLike.getPostId());
        updateStatement.setLong(2, newPostLike.getUserId());
        return updateStatement.executeUpdate();
    }

    public PostLike read(long id) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from postlike where id="+id;
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if( resultSet.next() ){
            return new PostLike(resultSet.getInt("postid"), resultSet.getInt("userid"));
        }
        return null;
    }

    public List<PostLike> read(PostLike example) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from postlike where id="+example.getPostId();
        ResultSet result = selectStatement.executeQuery(query);
        List<PostLike> list = new ArrayList<>();
        if (result.next()) {
            list.add(new PostLike(result.getInt("postid"),result.getInt("userid")) );
            return list;
        }
        return Collections.emptyList();
    }

    public List<PostLike> read() throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from postlike";
        ResultSet result = selectStatement.executeQuery(query);
        List<PostLike> list = new ArrayList<>();
        while (result.next()) {
            list.add(new PostLike(result.getInt("postid"),result.getInt("userid")) );
        }
        if (list.size()>0){
            return list;
        }
        return Collections.emptyList();
    }

    public boolean update(long id, PostLike existingPostLike) throws SQLException {
        String query = "update postlike set postid=?, userid=? where postid=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setLong(1, existingPostLike.getPostId());
        preparedStatement.setLong(2, existingPostLike.getUserId());
        preparedStatement.setLong(3, existingPostLike.getPostId());
        return preparedStatement.execute();
    }

    public boolean delete(long id) throws SQLException {
        String query = "delete from postlike where postid="+id;
        Statement statement = getConnection().createStatement();
        return statement.execute(query);
    }

}
