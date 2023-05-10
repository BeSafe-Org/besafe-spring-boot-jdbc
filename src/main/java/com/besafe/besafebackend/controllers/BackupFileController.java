package com.besafe.besafebackend.controllers;

import com.besafe.besafebackend.modals.BackupFile.UserFile;
import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;
import com.besafe.besafebackend.services.BackupFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BackupFileController {

    @Autowired
    BackupFileService backupFileService;

    @PutMapping("/file/add")
    public ResultImpl addBackupFile(@RequestBody UserFile userFile){
        ResultImpl fileAddResult = new ResultImpl(1,"Failure");
        try{
            boolean daoResult = backupFileService.addBackupFile(userFile);
            if(daoResult==false){
                return fileAddResult;
            }
            fileAddResult.setErrorCode(0);
            fileAddResult.setErrorMessage("Success");
            return fileAddResult;
        }
        catch(Exception e){
            return fileAddResult;
        }
    }

    @DeleteMapping("/file/delete/{fileId}")
    public ResultImpl addBackupFile(@PathVariable String fileId){
        ResultImpl fileDeleteResult = new ResultImpl(1,"Failure");
        try{
            boolean daoResult = backupFileService.deleteBackupFile(fileId);
            if(daoResult==false){
                return fileDeleteResult;
            }
            fileDeleteResult.setErrorCode(0);
            fileDeleteResult.setErrorMessage("Success");
            return fileDeleteResult;
        }
        catch(Exception e){
            return fileDeleteResult;
        }
    }
}
