package com.company.design.newsFeed.entites;

import com.company.design.newsFeed.constants.*;

import java.util.*;

public class User extends BaseEntity{
    private String userName;
    private String password;
    private String emailId;
    private UserType userType;
    private UserStatus userStatus;
    private List<Post> feeds = new ArrayList<>();
    private List<Follow> following = new ArrayList<>();
    private List<Follow> followers = new ArrayList<>();

    public User(){
        
    }
    public User(String userName, String password, String emailId, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public List<Post> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Post> feeds) {
        this.feeds = feeds;
    }

    public List<Follow> getFollowing() {
        return following;
    }

    public void setFollowing(List<Follow> following) {
        this.following = following;
    }

    public List<Follow> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follow> followers) {
        this.followers = followers;
    }
}
