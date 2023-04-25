package com.company.design.newsFeed.storage;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public class FollowStorage {
    
    private static List<Follow> followList = new ArrayList<>();
    private static HashMap<String, HashSet<Follow>> userToFollowerList = new HashMap<>();
    private static HashMap<String, Follow> followedFollowerMapping = new HashMap<>();
    
    public static Follow addFollower(Follow follow){
        followList.add(follow);
        addFollowInAllIndex(follow);
        return follow;
    }

    public static void addFollowInAllIndex(Follow follow){
        followedFollowerMapping.put(getKey(follow.getFollowedUser().getId(), follow.getFollowerUser().getId()), follow);
        HashSet<Follow> followerSet = userToFollowerList.getOrDefault(follow.getFollowedUser().getId(), new HashSet<>());
        followerSet.add(follow);
    }

    public static HashSet<Follow> getUserFollowerList(String userId){
        return userToFollowerList.getOrDefault(userId, new HashSet<>());
    }

    public static Follow getMapping(String followedId, String followerId){
        return followedFollowerMapping.get(getKey(followedId, followerId));
    }
    
    private static String getKey(String followedId, String followerId){
        return followedId+"_"+followerId;
    }
    
}
