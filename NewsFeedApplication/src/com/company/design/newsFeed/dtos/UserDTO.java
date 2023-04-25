package com.company.design.newsFeed.dtos;

import com.company.design.newsFeed.constants.*;

import java.util.*;

public class UserDTO extends AccountDTO {
    
    private UserType userType;
    private UserStatus userStatus;
    private UserStatsDTO userStats;
    private List<PostDTO> feeds = new ArrayList<>();
    private List<FollowDTO> following = new ArrayList<>();
    private List<FollowDTO> followers = new ArrayList<>();
   
    public UserDTO(){
        super();
    }
    
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public UserStatsDTO getUserStats() {
        return userStats;
    }

    public void setUserStats(UserStatsDTO userStats) {
        this.userStats = userStats;
    }

    public List<PostDTO> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<PostDTO> feeds) {
        this.feeds = feeds;
    }

    public List<FollowDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<FollowDTO> following) {
        this.following = following;
    }

    public List<FollowDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<FollowDTO> followers) {
        this.followers = followers;
    }
}
