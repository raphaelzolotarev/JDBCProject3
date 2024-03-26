package hilal.app;

import hilal.models.Post;
import hilal.models.Topic;
import hilal.models.User;
import hilal.repositories.PostRepository;
import hilal.repositories.TopicRepository;
import hilal.repositories.UserRepository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class InsertApp {

    public static void main(String[] args) {
/*
        UserRepository userRepository=new UserRepository();

        try {
            User user=new User();
            user.setUsername("eric");
            user.setEmail("eric@mail.be");
            user.setPassword("5644");
            user.setRole("visitor");
            user.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            long noOfNewUser=userRepository.create(user);
            System.out.println("Number of new users: "+noOfNewUser);
        }
        catch (SQLException sqlException) {
            System.out.println("SQL Exception: "+sqlException.getMessage());;
        }

        System.out.println("*****************************");
*/

        /*
        PostRepository postRepository = new PostRepository();

        try {

            Post post=new Post();
            post.setTitle("title3");
            post.setSlug("slug3");
            post.setImage("image3");
            post.setBody("body3");
            post.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
            post.setPublished(2);long noOfNewPost=postRepository.create(post);
            System.out.println("Number of new post: "+noOfNewPost);

        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: "+sqlException.getMessage());;
        }

        System.out.println("*****************************");
*/


        TopicRepository topicRepository = new TopicRepository();
        Topic topic = new Topic();
        try {
            topic.setName("name3");
            topic.setSlug("slug3");
            long noOfNewTopics = topicRepository.create(topic);
            System.out.println("No Of New Topics: " + noOfNewTopics);

        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
            ;
        }
        System.out.println("*****************************");


    }
}
