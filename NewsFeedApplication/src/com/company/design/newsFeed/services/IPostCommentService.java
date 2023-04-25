package com.company.design.newsFeed.services;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;

public interface IPostCommentService {

    PostCommentDTO addPostComment(String sessionId, String postId, String comment, String parentPostCommentId) throws PostNotExistException, PostCommentNotExistException;

    PostComment getPostCommentById(String postCommentDTO);

}