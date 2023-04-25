package com.company.design.newsFeed.services;

import com.company.design.newsFeed.constants.*;
import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.mapper.*;
import com.company.design.newsFeed.repository.*;

public class PostServiceImpl implements IPostService{

    private IPostRepository postRepository;
    private IUserService userService;

    public PostServiceImpl(IPostRepository postRepository, IUserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public PostDTO addPost(String sessionId, String text) {
        Post post = new Post();
        post.setText(text);
        post.setUser(userService.getUserBySessionId(sessionId));
        post.setStatus(FeedStatus.APPROVED);
        post = postRepository.addPost(post);
        PostDTO postDTO = ObjectMapper.mapPostToPostDTO(post);
        return postDTO;
    }

    @Override
    public Post getPostByPostId(String postId) {
        return postRepository.getPostByPostId(postId);
    }

    @Override
    public String getUserLatestPostPaginated(String userId, int password) throws InvalidLoginCredentials {
        return null;
    }
}
