package com.besafe.besafebackend.controllers;

import com.besafe.besafebackend.modals.BackupFile.UserFile;
import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;
import com.besafe.besafebackend.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FileController {

    @Autowired
    FileService fileService;

    @PutMapping("/file/add")
    public ResultImpl deleteFile(@RequestBody UserFile userFile){
        ResultImpl fileAddResult = new ResultImpl(1,"Failure");
        try{
            boolean daoResult = fileService.addFile(userFile);
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

    @PostMapping("/file/update")
    public ResultImpl updateFile(@RequestBody UserFile userFile){
        ResultImpl fileAddResult = new ResultImpl(1,"Failure");
        try{
            boolean daoResult = fileService.updateFile(userFile);
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
    public ResultImpl deleteFile(@PathVariable String fileId){
        ResultImpl fileDeleteResult = new ResultImpl(1,"Failure");
        try{
            boolean daoResult = fileService.deleteFile(fileId);
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