package hilal.app;

import hilal.models.Post;
import hilal.models.Topic;
import hilal.models.User;
import hilal.repositories.PostRepository;
import hilal.repositories.TopicRepository;
import hilal.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class SelectApp {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        try {
            //1
            List<User> users = userRepository.read();
            for (User u : users) {
                System.out.println(u);
            }
            //2
            User user = userRepository.read(2);
            System.out.println(user);
            //3
            List<User> users2 = userRepository.read(user);
            for (User u : users2) {
                System.out.println(u);
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
        }
        System.out.println("END USER**************************");


        PostRepository postRepository = new PostRepository();
        try {
            //1
            List<Post> posts = postRepository.read();
            for (Post p : posts) {
                System.out.println(p);
            }
            //2
            Post post = postRepository.read(1);
            System.out.println(post);
            //3
            List<Post> posts2 = postRepository.read(post);
            for (Post p : posts2) {
                System.out.println(p);
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
        }
        System.out.println("END POST**************************");


        TopicRepository topicRepository = new TopicRepository();
        try {
            //1
            List<Topic> topics = topicRepository.read();
            for (Topic t : topics) {
                System.out.println(t);
            }
            //2
            Topic topic = topicRepository.read(1);
            System.out.println(topic);
            //3
            List<Topic> topic2 = topicRepository.read(topic);
            for (Topic t : topic2) {
                System.out.println(t);
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
        }
        System.out.println("END TOPIC**************************");

    }


}
