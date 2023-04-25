package com.company.design.newsFeed.services;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;

import java.util.*;

public interface IFollowerService {

    FollowDTO addFollower(String sessionId, String followerId) throws FollowerNotExistException;

    HashSet<FollowDTO> getUserFollowerList(String userId);
}