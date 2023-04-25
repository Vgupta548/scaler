package com.company.design.newsFeed.services;

import com.company.design.newsFeed.constants.*;
import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.mapper.*;
import com.company.design.newsFeed.repository.*;

import java.util.*;

public class FollowerServiceImpl implements IFollowerService{

    private IFollowerRepository followerRepository;
    private IUserService userService;

    public FollowerServiceImpl(IFollowerRepository followerRepository, IUserService userService){
        this.followerRepository = followerRepository;
        this.userService = userService;
    }


    @Override
    public FollowDTO addFollower(String sessionId, String followerId) throws FollowerNotExistException {
         User followedUser = userService.getUserBySessionId(sessionId);
         User followerUser = userService.getUserByUserId(followerId);
         if(followerUser == null){
             throw new FollowerNotExistException(followerId);
         }
         
         Follow follow = followerRepository.getMapping(followedUser.getId(), followerUser.getId());
         if(follow == null){
             follow = new Follow();
             follow.setFollowedUser(followedUser);
             follow.setFollowerUser(followerUser);
             follow.setStatus(RelationshipStatus.ACTIVE);
             followerRepository.addFollower(follow);
         }else{
             System.out.println("User already following the same user");
         }
        FollowDTO followDTO = ObjectMapper.mapFollowToFollowDTO(follow);
        return followDTO;
    }

    @Override
    public HashSet<FollowDTO> getUserFollowerList(String userId) {
        return null;
    }

    private User getFollower(String followedId, String followerId){
        HashSet<Follow> followDTOHashSet = followerRepository.getUserFollowerList(followedId);
        if(followDTOHashSet.contains(followerId)){
            return userService.getUserByUserId(followerId);
        }
        return null;
    }
    
    private boolean isAlreadyAFollower(String followedId, String followerId){
        HashSet<Follow> followDTOHashSet = followerRepository.getUserFollowerList(followedId);
        return followDTOHashSet.contains(followerId);
    }
}
