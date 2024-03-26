package hilal.repositories;

import hilal.models.Post;

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
////        statement.executeUpdate() -> creates a record, or updates a record.
//        return createStatement.executeUpdate(query);
//        //Statement createStatement = getConnection().createStatement();
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


        // return null if fails
        return null;
    }

    public List<Post> read(Post example) throws SQLException {

        Statement selectStatement = getConnection().createStatement();

        // add read statements here..

        // return empty collection if fails
        return Collections.emptyList();
    }

    public List<Post> read() throws SQLException {
        List<Post> postList=new ArrayList<>();
        Statement selectStatement = getConnection().createStatement();

        String query="SELECT id,userid,title FROM POST";
        ResultSet result=selectStatement.executeQuery(query);

        while(result.next()){
            Post post=new Post();
            post.setId(result.getLong("id"));
            post.setUserId(result.getLong("userid"));
            post.setTitle(result.getString("title"));
            postList.add(post);
        }
        return postList;

    }

    public boolean update(long id, Post existingPost) throws SQLException {

        Statement updateStatement = getConnection().createStatement();

        // return false if fails
        return false;
    }

    public boolean delete(long id) throws SQLException {

        Statement deleteStatement = getConnection().createStatement();

        // return false if fails
        return false;
    }

}
