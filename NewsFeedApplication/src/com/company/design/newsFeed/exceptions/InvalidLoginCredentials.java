package com.company.design.newsFeed.exceptions;

public class InvalidLoginCredentials extends Exception{

    public InvalidLoginCredentials(String msg){
        super(msg);
    }
    
    public InvalidLoginCredentials(){
        super("UserName or Email is incorrect");
    }
}
