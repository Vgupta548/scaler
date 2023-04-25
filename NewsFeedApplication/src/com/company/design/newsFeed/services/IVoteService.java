package com.company.design.newsFeed.services;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;

public interface IVoteService {

    VoteDTO addVote(String sessionId, String postId, String postCommentId, boolean isUpVote) throws PostNotExistException, PostCommentNotExistException;
    
    Vote getVoteById(String voteId);
    
}