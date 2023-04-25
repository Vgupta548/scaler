package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;

public interface IPostCommentRepository {

    PostComment addPostComment(PostComment postComment);

    PostComment getPostCommentById(String postCommentId);

}
