package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.helpers.*;
import com.company.design.newsFeed.storage.*;

import java.util.*;

public class VoteRepositoryImpl implements IVoteRepository{
    
    @Override
    public Vote addOrUpdateVote(Vote vote) {
        if(getVoteById(vote.getId()) == null) {
            BaseEntityHelper.addDefaultDataOnSave(vote);
            VoteStorage.addVote(vote);
        }else{
            BaseEntityHelper.addDefaultDataOnUpdate(vote);
        }
        return vote;
    }

    @Override
    public Vote getVoteById(String voteId) {
        return VoteStorage.getById(voteId);
    }

    @Override
    public List<Vote> getVoteByPostId(String postId) {
        return VoteStorage.getByPostId(postId);
    }

    @Override
    public List<Vote> getVoteByCommentId(String postCommentId) {
        return VoteStorage.getByPostCommentId(postCommentId);
    }

    @Override
    public Vote getVoteByUserPostCommentId(Vote vote) {
        return VoteStorage.getByUserCommentPostId(vote);
    }

    @Override
    public Vote getVoteByUserPostCommentId(String userId, String postId, String postCommentId) {
        return VoteStorage.getByUserCommentPostId(userId, postId, postCommentId);
    }
}
