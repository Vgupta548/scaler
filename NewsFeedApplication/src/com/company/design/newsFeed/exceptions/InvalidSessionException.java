package com.company.design.newsFeed.exceptions;

public class InvalidSessionException extends Exception{

    public InvalidSessionException(String sessionId){
        super("SessionId: "+sessionId+" is invalid. Please login first with valid credentials");
    }
}
