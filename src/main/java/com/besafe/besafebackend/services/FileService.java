package com.besafe.besafebackend.services;

import com.besafe.besafebackend.dao.File;
import com.besafe.besafebackend.modals.BackupFile.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    File FileDao;
    public boolean addFile(UserFile userFile){
        return FileDao.addFile(userFile);
    }

    public boolean deleteFile(String fileId){
        return FileDao.deleteFile(fileId);
    }

    public boolean updateFile(UserFile userFile){
        return FileDao.updateFile(userFile);
    }
}
