package com.besafe.besafebackend.modals.Classes.Authentication;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;

public class VerifyOtpResult extends ResultImpl {
    boolean otpHashIdentical;

    public VerifyOtpResult(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public boolean isOtpHashIdentical() {
        return otpHashIdentical;
    }

    public void setOtpHashIdentical(boolean otpHashIdentical) {
        this.otpHashIdentical = otpHashIdentical;
    }
}
