package com.company.design.newsFeed.dtos;

import com.company.design.newsFeed.constants.*;
import com.company.design.newsFeed.entites.*;

import java.util.*;

public class PostDTO extends BaseDto {
    private String text;
    private FeedStatus status;
    private User user;
    private List<PostComment> comments = new ArrayList<>();
    private List<VoteDTO> votes = new ArrayList<>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public FeedStatus getStatus() {
        return status;
    }

    public void setStatus(FeedStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
    }

    public List<VoteDTO> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDTO> votes) {
        this.votes = votes;
    }
}
