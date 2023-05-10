package com.besafe.besafebackend.modals.Classes.User;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;

public class CheckIfUserExistsResult extends ResultImpl {
    private boolean userExists;

    public CheckIfUserExistsResult(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public boolean isUserExists() {
        return userExists;
    }

    public void setUserExists(boolean userExists) {
        this.userExists = userExists;
    }
}
