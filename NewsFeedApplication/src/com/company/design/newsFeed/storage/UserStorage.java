package com.company.design.newsFeed.storage;

import com.company.design.newsFeed.entites.*;

import java.util.*;

public class UserStorage {
    
    public static List<User> userList = new ArrayList<>();
    public static HashMap<String, User> userByUserName = new HashMap<>();
    public static HashMap<String, User> userByEmail = new HashMap<>();
    public static HashMap<String, User> userById = new HashMap<>();
    
    public static void addUser(User user){
        userList.add(user);
        addUserInAllIndex(user);
    }

    private static void addUserInAllIndex(User user){
        userByUserName.put(user.getUserName(), user);
        userByEmail.put(user.getEmailId(), user);
        userById.put(user.getId(), user);
    } 

    public static User getUserByEmail(String email){
        return userByEmail.get(email);
    }

    public static User getUserByUserName(String userName){
        return userByUserName.get(userName);
    }

    public static User getUserById(String id){
        return userById.get(id);
    }


}
