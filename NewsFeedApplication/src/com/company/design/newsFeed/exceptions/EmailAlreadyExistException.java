package com.company.design.newsFeed.exceptions;

public class EmailAlreadyExistException extends UserRegistrationException{

    public EmailAlreadyExistException(String email){
        super("email: "+email+" is already taken." );
    }
}
