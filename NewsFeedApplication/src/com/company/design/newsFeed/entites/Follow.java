package com.company.design.newsFeed.entites;

import com.company.design.newsFeed.constants.*;

public class Follow extends BaseEntity{
    
    private User followerUser;
    private User followedUser;
    private RelationshipStatus status;

    public User getFollowerUser() {
        return followerUser;
    }

    public void setFollowerUser(User followerUser) {
        this.followerUser = followerUser;
    }

    public User getFollowedUser() {
        return followedUser;
    }

    public void setFollowedUser(User followedUser) {
        this.followedUser = followedUser;
    }

    public RelationshipStatus getStatus() {
        return status;
    }

    public void setStatus(RelationshipStatus status) {
        this.status = status;
    }
}
