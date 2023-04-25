package com.company.design.newsFeed.exceptions;

public class InvalidEmailException extends UserRegistrationException{

    public InvalidEmailException(String email){
        super("Email: "+email+" is invalid." );
    }
}
