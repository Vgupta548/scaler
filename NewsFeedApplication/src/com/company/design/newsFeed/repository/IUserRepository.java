package com.company.design.newsFeed.repository;

import com.company.design.newsFeed.entites.*;

public interface IUserRepository {
    
    User getUserByUserName(String userName);

    User getUserByUserEmail(String email);
    
    User addUser(User user);
    
    User getUserByUserId(String userId);
}
