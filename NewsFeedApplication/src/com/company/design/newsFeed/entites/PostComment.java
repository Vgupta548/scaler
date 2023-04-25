package com.company.design.newsFeed.entites;

import com.company.design.newsFeed.constants.*;

import java.util.*;

public class PostComment extends BaseEntity{

    private String text;
    private User user;
    private Post post;
    private PostComment parentPostComment;
    private PostCommentStatus status;
    private List<PostComment> replies = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public PostComment getParentPostComment() {
        return parentPostComment;
    }

    public void setParentPostComment(PostComment parentPostComment) {
        this.parentPostComment = parentPostComment;
    }

    public PostCommentStatus getStatus() {
        return status;
    }

    public void setStatus(PostCommentStatus status) {
        this.status = status;
    }

    public List<PostComment> getReplies() {
        return replies;
    }

    public void setReplies(List<PostComment> replies) {
        this.replies = replies;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
