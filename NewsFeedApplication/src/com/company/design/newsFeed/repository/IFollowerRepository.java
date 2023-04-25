package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public interface IFollowerRepository {

    Follow addFollower(Follow follow);

    HashSet<Follow> getUserFollowerList(String userId);

    Follow getMapping(String followedId, String followerId);
}
