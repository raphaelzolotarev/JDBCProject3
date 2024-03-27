package hilal.models;


public class PostLike {

  private long postId;
  private long userId;

  public PostLike(){}
  public PostLike(long postId, long userId) {
    this.postId = postId;
    this.userId = userId;
  }

  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
