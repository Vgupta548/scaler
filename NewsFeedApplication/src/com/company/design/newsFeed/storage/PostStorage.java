package com.company.design.newsFeed.storage;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public class PostStorage {
    
    public static List<Post> postsList = new ArrayList<>();
    public static HashMap<String, List<Post>> userPost = new HashMap<>();
    public static HashMap<String, Post> postIdPost = new HashMap<>();
    
    public static void addPost(Post post){
        postsList.add(post);
        addPostInAllIndex(post);
    }
    
    private static void addPostInAllIndex(Post post){
        List<Post> posts = getAllPostForUser(post.getUser().getId());
        if(posts == null){
            posts = new ArrayList<>();
        }
        posts.add(post);
        userPost.put(post.getUser().getId(), posts);
        postIdPost.put(post.getId(), post);
    }

    public static List<Post> getAllPostForUser(String userId){
        return userPost.get(userId);
    }

    public static Post getPostById(String postId){
        return postIdPost.get(postId);
    }

    public static List<Post> getLatestUserPost(String userId, int pageNo, int size){
        List<Post> posts = new ArrayList<>();
        List<Post> userPosts = getAllPostForUser(userId);
        int total = userPosts == null ? 0: userPosts.size();
        if(total != 0){
            int startIndex = total - ((size+1)*pageNo); //10
            int endIndex = total - (size*pageNo); //20
            if(startIndex >= 0 && endIndex<= total) {
                posts = userPosts.subList(startIndex, endIndex);
            }
        }
        return posts;
    }
}
