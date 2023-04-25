package com.company.design.newsFeed.services;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;

public interface IUserService {

    public UserDTO registerUser(String userName, String password, String email) throws UserRegistrationException;

    String login(String userName, String password) throws InvalidLoginCredentials;
    
    User getUserByUserId(String userId);

    User getUserByUserName(String userName);

    User getUserByEmail(String email);

    User getUserBySessionId(String sessionId);
}