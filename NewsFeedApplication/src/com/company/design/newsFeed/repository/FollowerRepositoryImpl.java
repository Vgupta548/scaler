package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.helpers.*;
import com.company.design.newsFeed.storage.*;

import java.util.*;

public class FollowerRepositoryImpl implements IFollowerRepository {

    @Override
    public Follow addFollower(Follow follow) {
        BaseEntityHelper.addDefaultDataOnSave(follow);
        return FollowStorage.addFollower(follow);
    }

    @Override
    public HashSet<Follow> getUserFollowerList(String userId) {
        return FollowStorage.getUserFollowerList(userId);
    }

    @Override
    public Follow getMapping(String followedId, String followerId){
        return FollowStorage.getMapping(followedId, followerId);
    }
}
