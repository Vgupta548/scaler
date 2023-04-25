package com.company.design.newsFeed.exceptions;

public class InvalidUserNameException extends UserRegistrationException{

    public InvalidUserNameException(String userName){
        super("UserName: "+userName+" is invalid." );
    }
}
