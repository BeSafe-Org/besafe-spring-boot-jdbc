package com.besafe.besafebackend.services;

import com.besafe.besafebackend.dao.AuthenticationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    AuthenticationDao authenticationDao;

    public boolean storeOtpHash(String userId, String otpHash){
        return authenticationDao.storeOtpHash(userId, otpHash);
    }
}
