package com.company.design.newsFeed.storage;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;

import java.util.*;

public class PostCommentStorage {
    
    private static List<PostComment> postCommentList = new ArrayList<>();
   // private static HashMap<String, HashSet<Follow>> userToFollowerList = new HashMap<>();
    private static HashMap<String, PostComment> IdToPostCommentMapping = new HashMap<>();
    
    public static PostComment addPostComment(PostComment postComment){
        postCommentList.add(postComment);
        addInAllIndex(postComment);
        return postComment;
    }

    private static void addInAllIndex(PostComment postComment){
        IdToPostCommentMapping.put(postComment.getId(), postComment);
    }
    
    public static PostComment getById(String id){
        return IdToPostCommentMapping.get(id);
    }

}
