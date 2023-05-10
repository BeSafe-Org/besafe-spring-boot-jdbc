package com.besafe.besafebackend.controllers;

import com.besafe.besafebackend.modals.Classes.Authentication.Utils;
import com.besafe.besafebackend.modals.Classes.Common.ResultImpl;
import com.besafe.besafebackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PutMapping("/otp/send/{userId}")
    public ResultImpl sendOtp(@PathVariable String userId){
        ResultImpl sendotpResult = new ResultImpl(1, "Failure");
        try{
            int newOtp = Utils.generateOtp();
            String otpHash = Utils.convertToHash(String.valueOf(newOtp));
            boolean daoResult = authenticationService.storeOtpHash(userId, otpHash);
            if(daoResult==false){
                return sendotpResult;
            }
            sendotpResult.setErrorCode(0);
            sendotpResult.setErrorMessage("Success");
            return sendotpResult;
        }
        catch(Exception e){
            return sendotpResult;
        }
    }
}
