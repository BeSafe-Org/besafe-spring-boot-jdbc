package com.besafe.besafebackend.modals.Classes.User;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;

public class GetUserSaltResult extends ResultImpl {
    String userSalt;

    public GetUserSaltResult(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }
}
