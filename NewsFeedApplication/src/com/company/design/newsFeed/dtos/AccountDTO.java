package com.company.design.newsFeed.dtos;

public class AccountDTO extends BaseDto{

    private String userName;
    private String password;
    private String emailId;

    public AccountDTO(){
        
    }
    
    public AccountDTO(String userName, String password, String emailId){
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
