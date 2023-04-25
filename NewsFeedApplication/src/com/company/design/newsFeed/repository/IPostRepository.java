package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public interface IPostRepository {
    
    List<Post> getUserLatestPostPaginated(String userId,  int pageNo, int size);

    Post addPost(Post post);

    Post getPostByPostId(String postId);
}
