package com.company.design.newsFeed.exceptions;

public class UserNameAlreadyExistException extends UserRegistrationException{

    public UserNameAlreadyExistException(String userName){
        super("UserName: "+userName+" is already taken." );
    }
}
