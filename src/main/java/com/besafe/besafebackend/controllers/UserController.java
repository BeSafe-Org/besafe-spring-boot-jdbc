package com.besafe.besafebackend.controllers;

import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;
import com.besafe.besafebackend.modals.Classes.User.CheckIfUserExistsResult;
import com.besafe.besafebackend.modals.Classes.User.GenerateUserSaltResult;
import com.besafe.besafebackend.modals.Classes.User.GetUserSaltResult;
import com.besafe.besafebackend.modals.Classes.User.UserImpl;
import com.besafe.besafebackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/health")
    public String getHealth(){
        return "BeSafe is running";
    }

    @GetMapping("/user/exists/{userId}")
    public CheckIfUserExistsResult checkIfUserExists(@PathVariable String userId){

        CheckIfUserExistsResult checkIfUserExistsResult = new CheckIfUserExistsResult(1,"Failure");
        try{
            boolean dbResult = userService.checkIfUserExists(userId);
            checkIfUserExistsResult.setErrorCode(0);
            checkIfUserExistsResult.setErrorMessage("Success");
            checkIfUserExistsResult.setUserExists(dbResult);
            return checkIfUserExistsResult;
        }
        catch(Exception e){
            return checkIfUserExistsResult;
        }
    }

    @PutMapping("/user/salt/{userId}")
        public GenerateUserSaltResult generateAndStoreUserSalt(@PathVariable String userId){
        GenerateUserSaltResult generateUserSaltResult = new GenerateUserSaltResult(1, "Failure");
        try{
            String salt = userService.generateAndStoreUserSalt(userId);
            if(salt==null){
                return generateUserSaltResult;
            }
            generateUserSaltResult.setErrorCode(0);
            generateUserSaltResult.setErrorMessage("Success");
            generateUserSaltResult.setUserSalt(salt);
            return generateUserSaltResult;
        }
        catch(Exception e){
            return  generateUserSaltResult;
        }
    }

    @PutMapping("/user/digest")
    public ResultImpl storeUserDigest(@RequestBody UserImpl user){
        ResultImpl result = new ResultImpl(1,"Failure");
        try{
            int dbResult = userService.storeUserDigest(user.getUserId(),user.getUserDigest());
            if(dbResult==0){
                return result;
            }
            else{
                result.setErrorCode(0);
                result.setErrorMessage("Success");
                return result;
            }
        }
        catch(Exception e){
            return result;
        }
    }

    @GetMapping("/user/salt/{userId}")
    public GetUserSaltResult getUserSalt(@PathVariable String userId){
        GetUserSaltResult getUserSaltResult = new GetUserSaltResult(1,"Failure");
        try{
            String dbResult = userService.getUserSalt(userId);
            getUserSaltResult.setErrorCode(0);
            getUserSaltResult.setErrorMessage("Success");
            getUserSaltResult.setUserSalt(dbResult);
            return getUserSaltResult;
        }
        catch(Exception e){
            return getUserSaltResult;
        }
    }

    @GetMapping("/user/digest/{userId}")
    public ResultImpl getUserDigest(@PathVariable String userId){
        ResultImpl result = new ResultImpl(1,"Failure");
        try{
            return result;
        }
        catch(Exception e){
            return result;
        }
    }
}
