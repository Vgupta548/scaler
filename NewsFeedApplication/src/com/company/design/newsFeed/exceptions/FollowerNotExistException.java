package com.company.design.newsFeed.exceptions;

public class FollowerNotExistException extends  Exception{

    public FollowerNotExistException(String userId){
        super("No User exist with the following userId: "+userId);
    }
}
