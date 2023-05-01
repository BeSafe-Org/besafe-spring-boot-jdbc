package com.besafe.besafebackend.modals.Classes.User;


import com.besafe.besafebackend.modals.Interfaces.User.User;

import java.time.LocalDateTime;

public class UserImpl implements User {
    String userId;
    String userName;
    String userEmail;
    String dob;
    String joinedOn;
    String userSalt;
    String userDigest;

    public UserImpl(String userId, String userName, String userEmail, String dob, String joinedOn, String userSalt, String userDigest) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.dob = dob;
        this.joinedOn = joinedOn;
        this.userSalt = userSalt;
        this.userDigest = userDigest;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(String joinedOn) {
        this.joinedOn = joinedOn;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public String getUserDigest() {
        return userDigest;
    }

    public void setUserDigest(String userDigest) {
        this.userDigest = userDigest;
    }
}
