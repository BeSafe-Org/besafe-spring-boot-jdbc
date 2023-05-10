package com.besafe.besafebackend.modals.Interfaces.Common;

public interface Result {
    public int getErrorCode();

    public void setErrorCode(int errorCode);

    public String getErrorMessage();

    public void setErrorMessage(String errorMessage);
}
