package com.company.design.newsFeed.services;

import com.company.design.newsFeed.constants.*;
import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.mapper.*;
import com.company.design.newsFeed.repository.*;

public class PostCommentServiceImpl implements IPostCommentService{

    private IPostCommentRepository postCommentRepository;
    private IPostService postService;
    private IUserService userService;

    public PostCommentServiceImpl(IPostCommentRepository postCommentRepository, IPostService postService, IUserService userService){
        this.postCommentRepository = postCommentRepository;
        this.postService = postService;
        this.userService = userService;
    }
    
    
    @Override
    public PostCommentDTO addPostComment(String sessionId, String postId, String comment, String parentPostCommentId) throws PostNotExistException, PostCommentNotExistException {
        Post post = postService.getPostByPostId(postId);
        if(post == null){
            throw new PostNotExistException(postId);
        }

        PostComment parentPostComment = addParentCommentInfo(parentPostCommentId);
        
        PostComment postComment = new PostComment();
        postComment.setPost(post);
        postComment.setText(comment);
        postComment.setParentPostComment(parentPostComment);
        postComment.setUser(userService.getUserBySessionId(sessionId));
        postComment.setStatus(PostCommentStatus.APPROVED);
        postCommentRepository.addPostComment(postComment);
        PostCommentDTO postCommentDTO = ObjectMapper.mapPostCommentToPostCommentDTO(postComment);
        return postCommentDTO;
    }

    @Override
    public PostComment getPostCommentById(String postCommentId) {
        return postCommentRepository.getPostCommentById(postCommentId);
    }

    private PostComment addParentCommentInfo(String parentPostCommentId) throws PostCommentNotExistException {
        PostComment parentPostComment = null;
        if(parentPostCommentId != null) {
            parentPostComment = postCommentRepository.getPostCommentById(parentPostCommentId);
            if(parentPostComment == null){
                throw new PostCommentNotExistException(parentPostCommentId);
            }
        }
        return parentPostComment;
    }
}
