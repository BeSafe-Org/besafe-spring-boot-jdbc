package com.besafe.besafebackend.modals.BackupFile;

public class UserFile {
        String userId;
        String fileId;
        String fileName;
        String mimeType;
        boolean deleted;
        boolean starred;

    public UserFile(String userId, String fileId, String fileName, String mimeType, boolean deleted, boolean starred) {
        this.userId = userId;
        this.fileId = fileId;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.deleted = deleted;
        this.starred = starred;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }
}
