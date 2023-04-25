package com.company.design.newsFeed.controllers;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.services.*;

public class PostController {
    private IPostService postService;
    private IPostCommentService postCommentService;
    private IVoteService voteService;
    private SessionService sessionService;

    public PostController(IPostService postService, IPostCommentService postCommentService, IVoteService voteService, SessionService sessionService){
        this.postService = postService;
        this.postCommentService = postCommentService;
        this.voteService = voteService;
        this.sessionService = sessionService;
    }
    
    public PostDTO addPost(String sessionId, String text) throws InvalidSessionException {
        sessionService.checkIsSessionValid(sessionId);
        return postService.addPost(sessionId, text);
    }

    public PostCommentDTO postComment(String sessionId, String postId, String comment, String parentPostCommentId) throws InvalidSessionException, PostNotExistException, PostCommentNotExistException {
        sessionService.checkIsSessionValid(sessionId);
        PostCommentDTO postCommentDTO = postCommentService.addPostComment(sessionId, postId, comment, parentPostCommentId);
        return postCommentDTO;
    }

    public VoteDTO addVote(String sessionId, String postId, String postCommentId, boolean isUpVote) throws InvalidSessionException, PostNotExistException, PostCommentNotExistException {
        sessionService.checkIsSessionValid(sessionId);
        VoteDTO voteDTO = voteService.addVote(sessionId, postId, postCommentId, isUpVote);
        return voteDTO;
    }
}
