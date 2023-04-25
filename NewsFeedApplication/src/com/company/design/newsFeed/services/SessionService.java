package com.company.design.newsFeed.services;

import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.session.*;

import java.util.*;

public class SessionService {
    private SessionManager sessionManager;
    
    public SessionService(SessionManager sessionManager){
        this.sessionManager = sessionManager;
    }

    public void checkIsSessionValid(String sessionId) throws InvalidSessionException {
        if(sessionId == null){
            throw new InvalidSessionException(sessionId);
        }
        Session session = sessionManager.getSession(sessionId);
        if(session == null){
            throw new InvalidSessionException(sessionId);
        }
        
        if(session.getEndTime() != null && session.getEndTime().before(new Date())){
            throw new InvalidSessionException(sessionId);
        }
        
    }
    
    public String getUserNameFromSession(String sessionId) {
        return sessionManager.getSession(sessionId).getUserName();
    }
}
