package com.company.design.newsFeed.controllers;

import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.services.*;

public class AuthController {
    
    private IUserService userService;

    public AuthController(IUserService userService){
        this.userService = userService;
    }

    public UserDTO registerUser(AccountDTO accountDTO) throws UserRegistrationException {
        UserDTO userDto = new UserDTO();
        userDto = userService.registerUser(accountDTO.getUserName(), accountDTO.getPassword(), accountDTO.getEmailId());
        return userDto;
    }

    public String login(AccountDTO accountDTO) throws InvalidLoginCredentials {
        String sessionId = userService.login(accountDTO.getUserName(), accountDTO.getPassword());
        return sessionId;
    }

}
