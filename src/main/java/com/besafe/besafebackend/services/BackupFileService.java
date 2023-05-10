package com.besafe.besafebackend.services;

import com.besafe.besafebackend.dao.BackupFileDao;
import com.besafe.besafebackend.modals.BackupFile.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackupFileService {

    @Autowired
    BackupFileDao backupFileDao;
    public boolean addBackupFile(UserFile userFile){
        return backupFileDao.addBackupFile(userFile);
    }

    public boolean deleteBackupFile(String fileId){
        return backupFileDao.deleteBackupFile(fileId);
    }
}
