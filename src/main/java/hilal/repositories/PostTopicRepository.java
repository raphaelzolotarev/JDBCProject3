package hilal.repositories;

import hilal.models.PostTopic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostTopicRepository {

private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "1234"
        );
        System.out.println("CONNECTION TO DB IS MADE");
        return connection;
    }

    public long create(PostTopic newPostTopic) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement();
        String query = "insert into posttopic (postid, topicid) values (?,?) where postid="+newPostTopic.getPostId();
        preparedStatement.setLong(1, newPostTopic.getPostId());
        preparedStatement.setLong(2, newPostTopic.getTopicId());
        return preparedStatement.executeUpdate(query);
    }

    public PostTopic read(long id) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        Statement statement = getConnection().createStatement();
        String query = "select * from posttopic where postid="+id;
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()){
            return new PostTopic(resultSet.getInt("postid"), resultSet.getInt("topicid"));
        }
        return null;
    }

    public List<PostTopic> read(PostTopic example) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        Statement statement = getConnection().createStatement();
        String query = "select * from posttopic where postid="+example.getPostId();
        ResultSet resultSet = statement.executeQuery(query);
        List<PostTopic> list = new ArrayList<>();
        if (resultSet.next()){
            list.add(new PostTopic(resultSet.getInt("postid"), resultSet.getInt("topicid")));
        }
        if (list.size()>0){
            return list;
        }
        return Collections.emptyList();
    }

    public List<PostTopic> read() throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from posttopic";
        ResultSet resultSet = selectStatement.executeQuery(query);
        List<PostTopic> list = new ArrayList<>();
        while (resultSet.next()){
            list.add(new PostTopic(resultSet.getInt("postid"), resultSet.getInt("topicid")));
        }
        if (list.size()>0){
            return list;
        }
        return Collections.emptyList();
    }

    public boolean update(long id, PostTopic existingPostTopic) throws SQLException {
        String query = "update posttopic set postid=?, topicid=? where postid=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setLong(1, existingPostTopic.getPostId());
        preparedStatement.setLong(2, existingPostTopic.getTopicId());
        preparedStatement.setLong(3, existingPostTopic.getPostId());
        return preparedStatement.execute();
    }

    public boolean delete(long id) throws SQLException {
        Statement deleteStatement = getConnection().createStatement();
        String query = "delete from posttopic where postid="+id;
        return deleteStatement.execute(query);
    }

}
