package com.company.design.newsFeed.exceptions;

public class PostCommentNotExistException extends  Exception{

    public PostCommentNotExistException(String postCommentId){
        super("No PostComment exist with the following postCommentId: "+postCommentId);
    }
}
