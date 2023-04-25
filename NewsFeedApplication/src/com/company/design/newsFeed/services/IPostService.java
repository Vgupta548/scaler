package com.company.design.newsFeed.services;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;

public interface IPostService {

    PostDTO addPost(String sessionId, String text);

    Post getPostByPostId(String postId);

    String getUserLatestPostPaginated(String userId, int password) throws InvalidLoginCredentials;
}