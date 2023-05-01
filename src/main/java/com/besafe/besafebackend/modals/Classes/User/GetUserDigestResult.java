package com.besafe.besafebackend.modals.Classes.User;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;

public class GetUserDigestResult extends ResultImpl {
    String userDigest;

    public GetUserDigestResult(int errorCode, String errorMessage, String userDigest) {
        super(errorCode, errorMessage);
        this.userDigest = userDigest;
    }

    public String getUserDigest() {
        return userDigest;
    }

    public void setUserDigest(String userDigest) {
        this.userDigest = userDigest;
    }
}
