package com.besafe.besafebackend.modals.Classes.User;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;

public class GetUserDigestResult extends ResultImpl {
    String userDigest;

    public GetUserDigestResult(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public String getUserDigest() {
        return userDigest;
    }

    public void setUserDigest(String userDigest) {
        this.userDigest = userDigest;
    }
}
