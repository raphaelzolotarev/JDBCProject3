package hilal.models;


public class PostTopic {

  private long postId;
  private long topicId;

  public PostTopic(){}
  public PostTopic(long postId, long topicId) {
    this.postId = postId;
    this.topicId = topicId;
  }

  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public long getTopicId() {
    return topicId;
  }

  public void setTopicId(long topicId) {
    this.topicId = topicId;
  }

}
