package com.company.design.newsFeed.session;

import java.util.*;

public class Session {
    
    private String sessionId;
    private String userName;
    private String authToken;
    private Date startTime;
    private Date endTime;

    public Session(String sessionId, String userName, String authToken) {
        this.sessionId = sessionId;
        this.userName = userName;
        this.authToken = authToken;
        this.startTime = new Date();
        this.endTime = null;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
