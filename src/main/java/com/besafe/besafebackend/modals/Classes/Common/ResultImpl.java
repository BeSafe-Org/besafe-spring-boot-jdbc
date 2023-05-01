package com.besafe.besafebackend.modals.Classes.Common;

import com.besafe.besafebackend.modals.Interfaces.Common.Result;

public class ResultImpl implements Result {
    private int errorCode;
    private String errorMessage;

    public ResultImpl(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
