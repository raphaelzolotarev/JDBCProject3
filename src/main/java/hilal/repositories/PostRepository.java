package hilal.repositories;

import hilal.models.Post;
import hilal.models.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostRepository {

private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "1234"
        );
        System.out.println("CONNECTION TO DB IS MADE");
        return connection;
    }

    public long create(Post newPost) throws SQLException {
        //        Statement createStatement = getConnection().createStatement();
        //        String query = "INSERT INTO post " +
        //                "(user_id, title) " +
        //                "VALUES " +
        //                "('" + newPost.getUserId() + "', " +
        //                "'" + newPost.getTitle() + "')";
        //        statement.executeUpdate() -> creates a record, or updates a record.
        //        return createStatement.executeUpdate(query);
        //        Statement createStatement = getConnection().createStatement();
        String query = "insert into post ( title,slug,image,body,published, createdAt) values (?,?,?,?,?,?)";
        PreparedStatement insertStatement = getConnection().prepareStatement(query);
        insertStatement.setString(1,newPost.getTitle());
        insertStatement.setString(2,newPost.getSlug());
        insertStatement.setString(3,newPost.getImage());
        insertStatement.setString(4,newPost.getBody());
        insertStatement.setLong(5,newPost.getPublished());
        insertStatement.setTimestamp(6,newPost.getCreatedAt());
        return insertStatement.executeUpdate();
    }

    public Post read(long id) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from post where id="+id;
        ResultSet result = selectStatement.executeQuery(query);
        if (result.next()) {
            return new Post(
                    result.getInt("id"),
                    result.getInt("userid"),
                    result.getString("title"),
                    result.getString("slug"),
                    result.getInt("views"),
                    result.getString("image"),
                    result.getString("body"),
                    result.getInt("published"),
                    result.getTimestamp("createdat"),
                    result.getTimestamp("updatedat")
            );
        }
        return null;
    }

    public List<Post> read(Post example) throws SQLException {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from post where id="+example.getId();
        ResultSet result = selectStatement.executeQuery(query);
        List<Post> post = new ArrayList<>();
        if (result.next()) {
            post.add(
                    new Post(
                    result.getInt("id"),
                    result.getInt("userid"),
                    result.getString("title"),
                    result.getString("slug"),
                    result.getInt("views"),
                    result.getString("image"),
                    result.getString("body"),
                    result.getInt("published"),
                    result.getTimestamp("createdat"),
                    result.getTimestamp("updatedat"))
            );
            return post;
        }
        return Collections.emptyList();
    }

    public List<Post> read() throws SQLException {
        List<Post> postList=new ArrayList<>();
        Statement selectStatement = getConnection().createStatement();
        String query="SELECT id,userid,title FROM POST";
        ResultSet result=selectStatement.executeQuery(query);
        while(result.next()){
            Post post=new Post();
            post.setId(result.getInt("id"));
            post.setUserId(result.getInt("userid"));
            post.setTitle(result.getString("title"));
            postList.add(post);
        }
        return postList;
    }

    public boolean update(long id, Post existingPost) throws SQLException {
        Statement updateStatement = getConnection().createStatement();
        String query="update post set id=?, userId=?, title=?, slug=?, views=?, image=?, body=?, published=?, createdat=?, updatedat=? where id=?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1,(int)existingPost.getId());
        preparedStatement.setInt(2,(int)existingPost.getUserId());
        preparedStatement.setString(3,existingPost.getTitle());
        preparedStatement.setString(4,existingPost.getSlug());
        preparedStatement.setInt(5,(int)existingPost.getViews());
        preparedStatement.setString(6,existingPost.getImage());
        preparedStatement.setString(7,existingPost.getBody());
        preparedStatement.setInt(8,(int)existingPost.getPublished());
        preparedStatement.setTimestamp(9,existingPost.getCreatedAt());
        preparedStatement.setTimestamp(10,existingPost.getUpdatedAt());
        return preparedStatement.execute();
    }

    public boolean delete(long id) throws SQLException {
        Statement deleteStatement = getConnection().createStatement();
        String query="delete from post where id="+id;
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        return preparedStatement.execute();
    }