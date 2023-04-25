package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public interface IVoteRepository {
    
    Vote addOrUpdateVote(Vote vote);

    Vote getVoteById(String voteId);

    List<Vote> getVoteByPostId(String postId);

    List<Vote> getVoteByCommentId(String postCommentId);

    Vote getVoteByUserPostCommentId(Vote vote);

    Vote getVoteByUserPostCommentId(String userId, String postId, String postCommentId);
}
