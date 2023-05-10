package com.besafe.besafebackend.modals.Classes.User;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;

public class UserSaltResult extends ResultImpl {
    private String userSalt;

    public UserSaltResult(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
        this.userSalt = userSalt;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }
}
