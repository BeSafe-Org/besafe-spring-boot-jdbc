package com.besafe.besafebackend.modals.Classes.Authentication;

public class VerifyOtpRequest {
    String userId;
    String otpHash;

    public VerifyOtpRequest(String userId, String otpHash) {
        this.userId = userId;
        this.otpHash = otpHash;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOtpHash() {
        return otpHash;
    }

    public void setOtpHash(String otpHash) {
        this.otpHash = otpHash;
    }
}
