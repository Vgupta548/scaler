package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.helpers.*;
import com.company.design.newsFeed.storage.*;

import java.util.*;

public class PostRepositoryImpl implements IPostRepository {

    @Override
    public List<Post> getUserLatestPostPaginated(String userId, int pageNo, int size) {
        return PostStorage.getLatestUserPost(userId, pageNo, size);
    }

    @Override
    public Post addPost(Post post) {
        BaseEntityHelper.addDefaultDataOnSave(post);
        PostStorage.addPost(post);
        return post;
    }

    @Override
    public Post getPostByPostId(String postId) {
        return PostStorage.getPostById(postId);
    }
}
