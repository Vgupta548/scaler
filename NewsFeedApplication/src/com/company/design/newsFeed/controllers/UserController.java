package com.company.design.newsFeed.controllers;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.services.*;

public class UserController {

    private IUserService userService;
    private IFollowerService followerService;
    private SessionService sessionService;

    public UserController(IUserService userService, IFollowerService followerService, SessionService sessionService){
        this.userService = userService;
        this.followerService = followerService;
        this.sessionService = sessionService;
    }

    public FollowDTO follow(String sessionId, String followedId) throws InvalidSessionException, FollowerNotExistException {
        sessionService.checkIsSessionValid(sessionId);
        FollowDTO followDTO = followerService.addFollower(sessionId, followedId);
        return followDTO;
    }


}
