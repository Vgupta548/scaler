package com.company.design.newsFeed.dtos;

public class VoteDTO extends BaseDto {
    private boolean isUpVote;
    private UserDTO user;
    private PostDTO post;
    private PostCommentDTO comment;

    public boolean isUpVote() {
        return isUpVote;
    }

    public void setUpVote(boolean upVote) {
        isUpVote = upVote;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public PostDTO getPost() {
        return post;
    }

    public void setPost(PostDTO post) {
        this.post = post;
    }

    public PostCommentDTO getComment() {
        return comment;
    }

    public void setComment(PostCommentDTO comment) {
        this.comment = comment;
    }
}
