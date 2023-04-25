package com.company.design.newsFeed.exceptions;

public class PostNotExistException extends  Exception{

    public PostNotExistException(String postId){
        super("No Post exist with the following postId: "+postId);
    }
}
