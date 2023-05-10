package com.besafe.besafebackend.modals.BackupFile;

public class UserFile {
    String userId;
    String fileBytes;

    public UserFile(String userId, String fileBytes) {
        this.userId = userId;
        this.fileBytes = fileBytes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(String fileBytes) {
        this.fileBytes = fileBytes;
    }
}
