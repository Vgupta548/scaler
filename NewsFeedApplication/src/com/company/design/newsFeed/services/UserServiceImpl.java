package com.company.design.newsFeed.services;

import com.company.design.newsFeed.constants.*;
import com.company.design.newsFeed.dtos.*;
import com.company.design.newsFeed.entites.*;
import com.company.design.newsFeed.exceptions.*;
import com.company.design.newsFeed.mapper.*;
import com.company.design.newsFeed.repository.*;
import com.company.design.newsFeed.session.*;

public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;
    private SessionManager sessionManager;
    private SessionService sessionService;

    public UserServiceImpl(IUserRepository userRepository,  SessionService sessionService, SessionManager sessionManager){
        this.userRepository = userRepository;
        this.sessionManager= sessionManager;
        this.sessionService = sessionService;
    }

    @Override
    public UserDTO registerUser(String userName, String password, String email) throws UserRegistrationException {
       try {
           validateUserName(userName);
           validateEmail(email);
       }catch (UserRegistrationException e){
           System.out.println(e.getMessage());
           throw e;
       }
        User user = new User(userName, password, email, UserType.MEMBER);
        user.setUserStatus(UserStatus.ACTIVE);
        user = userRepository.addUser(user);
        UserDTO userDto = ObjectMapper.mapUserToUserDTO(user);
        return userDto;
    }

    @Override
    public String login(String userName, String password) throws InvalidLoginCredentials {
        User user = userRepository.getUserByUserName(userName);
        if(user == null || password == null || !password.equals(user.getPassword())){
            System.out.println(ErrorMessages.INVAID_LOGIN_CREDENTIALS);
            throw new InvalidLoginCredentials(ErrorMessages.INVAID_LOGIN_CREDENTIALS);
        }
        String sessionId = sessionManager.createSession(userName, password);
        return sessionId;
    }

    @Override
    public User getUserByUserId(String userId) {
        return userRepository.getUserByUserId(userId);
    }

    @Override
    public User getUserByUserName(String userName){
        return userRepository.getUserByUserName(userName);
    }

    @Override
    public User getUserByEmail(String email){
        return userRepository.getUserByUserEmail(email);
    }

    public User getUserBySessionId(String sessionId) {
        return getUserByUserName(sessionService.getUserNameFromSession(sessionId));
        
    }

    private void validateUserName(String userName) throws UserNameAlreadyExistException, InvalidUserNameException {
        if(userName == null){
            throw new InvalidUserNameException(userName);
        }
        User user = userRepository.getUserByUserName(userName);
        if(user != null){
            throw new UserNameAlreadyExistException(userName);
        }
    }
    


    private void validateEmail(String email) throws EmailAlreadyExistException, InvalidEmailException {
        if(email == null){
            throw new InvalidEmailException(email);
        }
        User user = userRepository.getUserByUserEmail(email);
        if(user != null){
            throw new EmailAlreadyExistException(email);
        }
    }
}
