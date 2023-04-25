package com.company.design.newsFeed.storage;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public class VoteStorage {
    
    private static List<Vote> voteList = new ArrayList<>();
    private static HashMap<String, Vote> IdToVoteMapping = new HashMap<>();
    private static HashMap<String, List<Vote>> postIdToVoteListMapping = new HashMap<>();
    private static HashMap<String, List<Vote>> postCommentIdToVoteListMapping = new HashMap<>();
    private static HashMap<String, Vote> userCommentPostIdToVoteMapping = new HashMap<>();
    
    public static Vote addVote(Vote vote){
        voteList.add(vote);
        addInAllIndex(vote);
        return vote;
    }

    public static Vote updateVote(Vote vote){
        addInAllIndex(vote);
        return vote;
    }

    private static void addInAllIndex(Vote vote){
        IdToVoteMapping.put(vote.getId(), vote);
        if(vote.getPost() != null) {
            List<Vote> votes = postIdToVoteListMapping.getOrDefault(vote.getPost().getId(), new ArrayList<>());
            votes.add(vote);
        }
        if(vote.getComment() != null) {
            List<Vote> votes = postIdToVoteListMapping.getOrDefault(vote.getComment().getId(), new ArrayList<>());
            votes.add(vote);
        }
        userCommentPostIdToVoteMapping.put(getKey(vote), vote);
    }
    
    public static Vote getById(String id){
        return IdToVoteMapping.get(id);
    }

    public static List<Vote> getByPostId(String postId){
        return postIdToVoteListMapping.get(postId);
    }

    public static List<Vote> getByPostCommentId(String postCommentId){
        return postCommentIdToVoteListMapping.get(postCommentId);
    }

    public static Vote getByUserCommentPostId(Vote vote){
        return userCommentPostIdToVoteMapping.get(getKey(vote));
    }

    public static Vote getByUserCommentPostId(String userId, String postId, String postCommentId){
        return userCommentPostIdToVoteMapping.get(getKey(userId, postId, postCommentId));
    }
    
    private static String getKey(Vote vote){
        StringBuilder sb = new StringBuilder();
        sb.append(vote.getUser().getId());
        
        String postId = null;
        if(vote.getPost() != null){
            postId = vote.getPost().getId();
        }
        sb.append("_"+postId);

        String postCommentId = null;
        if(vote.getComment() != null){
            postCommentId = vote.getComment().getId();
        }
        sb.append("_"+postCommentId);
        
        return sb.toString();
    }

    private static String getKey(String userId, String postId, String postCommentId){
        StringBuilder sb = new StringBuilder();
        sb.append(userId);

        sb.append("_"+postId);

        sb.append("_"+postCommentId);

        return sb.toString();
    }

}
