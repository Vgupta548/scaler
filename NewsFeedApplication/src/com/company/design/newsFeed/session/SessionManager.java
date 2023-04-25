package com.company.design.newsFeed.session;

import java.util.*;
import java.util.concurrent.*;

public class SessionManager {
    private Map<String, Session> sessions;
    
    public SessionManager(){
        this.sessions = new ConcurrentHashMap<>();
    }
    
    public String createSession(String userId, String authToken){
        String sessionId = generateSessionId() ;
        Session session = new Session(sessionId, userId, authToken);
        sessions.put(sessionId, session);
        return sessionId;
        
    }
    
    private String generateSessionId(){
        return UUID.randomUUID().toString();
    }

    public Session getSession(String sessionId){
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId){
        sessions.remove(sessionId);
    }

}
