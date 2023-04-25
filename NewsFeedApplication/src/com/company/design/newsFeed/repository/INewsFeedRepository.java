package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;

public interface INewsFeedRepository {
    
    User getUserByUserName(String userName);

    User getUserByUserEmail(String email);
    
    User addUser(User user);
}
