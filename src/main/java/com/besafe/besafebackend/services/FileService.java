package com.besafe.besafebackend.services;

import com.besafe.besafebackend.dao.File;
import com.besafe.besafebackend.modals.BackupFile.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    @Autowired
    File fileDao;
    public boolean addFile(UserFile userFile){
        return fileDao.addFile(userFile);
    }

    public boolean deleteFile(String fileId){
        return fileDao.deleteFile(fileId);
    }

    public boolean updateFile(UserFile userFile){
        return fileDao.updateFile(userFile);
    }

    public List<UserFile> getFilesByUserId(String userId) {
        return fileDao.getFilesByUserId(userId);
    }

    public List<UserFile> getUltraSafeFilesByUserId(String userId) {
        return fileDao.getUltraSafeFilesByUserId(userId);
    }

    public List<UserFile> getStarredFilesByUserId(String userId) {
        return fileDao.getStarredFilesByUserId(userId);
    }

    public List<UserFile> getDeletedFilesByUserId(String userId) {
        return fileDao.getDeletedFilesByUserId(userId);
    }
}
