package hilal.repositories;

import hilal.models.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopicRepository {

    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "1234"
        );
        System.out.println("CONNECTION TO DB IS MADE");
        return connection;
    }

    public long create(Topic newTopic) throws SQLException {
        String query = "insert into topic (name,slug) values(?,?)";
        PreparedStatement insertStatement = getConnection().prepareStatement(query);
        insertStatement.setString(1, newTopic.getName());
        insertStatement.setString(2, newTopic.getSlug());
        return insertStatement.executeUpdate();
    }

    public Topic read(long id) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from topic where id="+id;
        ResultSet result = selectStatement.executeQuery(query);
        if (result.next()) {
            return new Topic(result.getInt("id"),result.getString("name"),result.getString("slug"));
        }
        return null;
    }

    public List<Topic> read(Topic example) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from topic where id="+example.getId();
        ResultSet result = selectStatement.executeQuery(query);
        List<Topic> list = new ArrayList<>();
        if (result.next()) {
            list.add(new Topic(result.getInt("id"),result.getString("name"),result.getString("slug")));
            return list;
        }
        return Collections.emptyList();
    }

    public List<Topic> read() throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        List<Topic> topicList = new ArrayList<>();
        String query = "select id,name,slug from topic";
        ResultSet result = selectStatement.executeQuery(query);
        while (result.next()) {
            Topic topic = new Topic();
            topic.setId(result.getInt("id"));
            topic.setName(result.getString("name"));
            topic.setSlug(result.getString("slug"));
            topicList.add(topic);
        }
        return topicList;
    }

    public int update(int id, Topic existingTopic) throws SQLException {
        String query = "Update topic Set name=?,slug=? where id =?";
        PreparedStatement updateStatement = getConnection().prepareStatement(query);
        updateStatement.setString(1, existingTopic.getName());
        updateStatement.setString(2, existingTopic.getSlug());
        updateStatement.setLong(3, id);
        return updateStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String query = "Delete from topic where id=?";
        PreparedStatement deleteStatement = getConnection().prepareStatement(query);
        deleteStatement.setInt(1, id);
        return deleteStatement.executeUpdate();
    }

}
