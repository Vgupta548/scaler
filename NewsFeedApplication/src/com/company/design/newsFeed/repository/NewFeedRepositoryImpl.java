package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.helpers.*;
import com.company.design.newsFeed.storage.*;

public class NewFeedRepositoryImpl implements INewsFeedRepository {

    

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }

    @Override
    public User getUserByUserEmail(String email) {
        return null;
    }

    @Override
    public User addUser(User user) {
        BaseEntityHelper.addDefaultDataOnSave(user);
        UserStorage.addUser(user);
        return user;
    }
}
