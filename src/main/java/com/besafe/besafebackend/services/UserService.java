package com.besafe.besafebackend.services;

import com.besafe.besafebackend.dao.UserDao;
import com.besafe.besafebackend.modals.Classes.User.CheckIfUserExistsResult;
import com.besafe.besafebackend.modals.Classes.User.GenerateUserSaltResult;
import com.besafe.besafebackend.modals.Classes.User.SaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    SaltGenerator saltGenerator;

    public boolean checkIfUserExists( String userId){
        return userDao.checkIfUserExists(userId);
    }

    public String generateAndStoreUserSalt(String userId){
        try{
            String userSalt = saltGenerator.generateSalt();
            int dbResult = userDao.addUserInfo(userId, userSalt);
            if(dbResult==1){
                return userSalt;
            }
            else{
                return null;
            }
        }
        catch(Exception e){
            return null;
        }
    }

    public int storeUserDigest(String userId, String userDigest){
        return userDao.storeUserDigest(userId, userDigest);
    }

    public String getUserSalt(String userId){
        return userDao.getUserSalt(userId);
    }

    public String getUserDigest(String userId){
        return userDao.getUserDigest(userId);
    }
}
