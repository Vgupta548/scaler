package com.company.design.newsFeed.services;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.mapper.*;
import com.company.design.newsFeed.repository.*;

public class VoteServiceImpl implements IVoteService{
    
    private IVoteRepository voteRepository;
    private IUserService userService;
    private IPostService postService;
    private IPostCommentService postCommentService;
    
    public VoteServiceImpl(IVoteRepository voteRepository, IPostService postService, IPostCommentService postCommentService, IUserService userService){
        this.voteRepository = voteRepository;
        this.postService = postService;
        this.postCommentService = postCommentService;
        this.userService = userService;
    }

    @Override
    public VoteDTO addVote(String sessionId, String postId, String postCommentId, boolean isUpVote) throws PostNotExistException, PostCommentNotExistException {
        Post post = null;
        if(postId != null) {
            post = postService.getPostByPostId(postId);
            if (post == null) {
                throw new PostNotExistException(postId);
            }
        }
        PostComment postComment = null;
        if(postCommentId !=null){
            postComment = postCommentService.getPostCommentById(postCommentId);
            if (postComment == null) {
                throw new PostCommentNotExistException(postCommentId);
            }
        }
        
        User user = userService.getUserBySessionId(sessionId);
        
        Vote vote = voteRepository.getVoteByUserPostCommentId(user.getId(), postId, postCommentId);
        if(vote == null){
            vote = new Vote();
            vote.setUser(user);
            vote.setPost(post);
            vote.setComment(postComment);
        }
        vote.setUpVote(isUpVote);
        voteRepository.addOrUpdateVote(vote);
        
        VoteDTO voteDTO = ObjectMapper.mapVoteToVoteDTO(vote);
        return voteDTO;
    }

    @Override
    public Vote getVoteById(String voteId) {
        return voteRepository.getVoteById(voteId);
    }
}
