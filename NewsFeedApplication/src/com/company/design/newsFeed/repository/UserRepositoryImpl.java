package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.helpers.*;
import com.company.design.newsFeed.storage.*;

public class UserRepositoryImpl implements IUserRepository {

    @Override
    public User getUserByUserName(String userName) {
        return UserStorage.getUserByUserName(userName);
    }

    @Override
    public User getUserByUserEmail(String email) {
        return UserStorage.getUserByEmail(email);
    }

    @Override
    public User addUser(User user) {
        BaseEntityHelper.addDefaultDataOnSave(user);
        UserStorage.addUser(user);
        return user;
    }

    @Override
    public User getUserByUserId(String id) {
        return UserStorage.getUserById(id);
    }
}
