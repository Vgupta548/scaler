package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.helpers.*;
import com.company.design.newsFeed.storage.*;

public class PostCommentRepositoryImpl implements IPostCommentRepository{
    
    @Override
    public PostComment addPostComment(PostComment postComment) {
        BaseEntityHelper.addDefaultDataOnSave(postComment);
        return PostCommentStorage.addPostComment(postComment);
    }

    @Override
    public PostComment getPostCommentById(String postCommentId) {
        return PostCommentStorage.getById(postCommentId);
    }
}
